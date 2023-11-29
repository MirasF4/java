package com.hbedv.frame;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbedv.db.RepositoryException;
import com.hbedv.frame.clientstate.IClientState;

/**
 * Diese Klasse kuemmert sich um den Einstieg eines jeden Requests vom Benutzer,
 * dh. jede Webapp hat eine abgeleitet Klasse davon.
 *  $
	Last change: PIG 27.11.2007 16:33:55
 */
public abstract class FrameServlet extends HttpServlet {

	public final String			jspUIFrameDir	= "/jsp/ui_frame/";
	protected final String	jspdir				= "/jsp/";
	protected final String	htmldir				= "/public_html/";
	
	private Client getClient(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		Client client = (Client) session.getAttribute(session.getId());

		if (client == null) return null;

		client.getInformant().resetAndRespectConfirm();
		client.setClientState(IClientState.UNDEFINED);

		//!!losa: Replying Party: via Saml authentifizieren?
		String artifact = request.getParameter(TheApp.SAML_ART);

		if (artifact != null) {
			client.setDoAuthenticateViaSaml(!artifact.equals(""));
		}

		try {
			if (request.getParameter(TheApp.ID_MENUE) != null) {
				client.setIdMenue(new Integer(request.getParameter(TheApp.ID_MENUE)));
			}
		}
		catch (Exception ex) {
			client.setIdMenue(null);
		}

		return client;
	}

	private Client getNewClient(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		Client client = getWebAppClient();
		//Client initialisieren
		session.setAttribute(session.getId(), client);
		client.init();
		client.setSingleWindowMode(request);
		client.setNoFramesMode(request);
		client.setIdSession(session.getId());

		//application an diesen Client anhaengen; damit wir via Client schnell auf
		//unsere TheApp zugreifen koennen.
		javax.servlet.ServletContext application = getServletConfig().getServletContext();
		TheApp theApp = (TheApp) application.getAttribute(TheApp.ATTRIBUTE_KEY);

		if (theApp == null) {
			throw new NullPointerException("theApp == null");
		}

		client.setTheApp(theApp);

		if (getServletContext().getRealPath("/").endsWith(java.io.File.separator)) {
			client.setAppRootDir(getServletContext().getRealPath("/"));
		}
		else {
			client.setAppRootDir(getServletContext().getRealPath("/") + java.io.File.separator);
		}
		client.setAppRootUrl(request.getContextPath());
		client.setServletpath(request.getServletPath());

		client.setHttpServer(request.getServerName(), new Integer(request.getServerPort()).toString());
		client.setURLClient(new java.net.URL("http", request.getServerName(), request.getServerPort(), request.getRequestURI()));

		defineLocale(client);
		client = getClient(request);

		return client;
	}

	public void init(ServletConfig config) throws ServletException {

		try {
			super.init(config);

			TheApp theApp = new TheApp();
			initTheApp(theApp, config);

			//Der Application theApp anhaengen.
			ServletContext application = getServletConfig().getServletContext();
			application.setAttribute("com.poi.fux.theapp", theApp);

			//Log4j
		}
		catch (Exception e) {
			log("**E: init: " + e.getMessage() + " >  " + Util.formatStackTrace(e));
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest oldRequest = request;
		HttpServletResponse oldResponse = response;
		Client client = null;
		String jspNext = null;
		ICommand cmd = null;
		try {
			// Command herausholen
			String commandToDo = null;
			RequestStateKeeper requestStateKeeper = null;
			if (request.isRequestedSessionIdValid()) {
				// session ist gültig
				if (TheApp.REDIRECT.equals(request.getParameter(TheApp.CMD)) && (request.getSession().getAttribute(TheApp.REDIRECT) != null)) {

					requestStateKeeper = (RequestStateKeeper) request.getSession().getAttribute(TheApp.REDIRECT);
					request = new RequestRedirectFacade(request, requestStateKeeper);
					request.getSession().removeAttribute(TheApp.REDIRECT);
				}
				client = getClient(request);
				// es hängt kein Client an der Session -
				// passiert wenn der Server neu gestartet wird und der Browser offen
				// bleibt?!
				if (client == null) client = getNewClient(request);
				commandToDo = extractCommand(request);
				cmd = cmdSession(commandToDo, client);
			}
			else {
				// entweder ein jungfraulicher Browser (ohne session id)
				// oder die Session ist bereits abgelaufen
				if (request.getRequestedSessionId() == null) {
					// jungfräulicher Browser
					client = getNewClient(request);
					commandToDo = extractCommand(request);
					cmd = cmdSessionNeu(commandToDo, client);
				
				}
				else {
					// session abgelaufen, oder user hat app normal beendet
					// und Browser ist offen geblieben
					client = getNewClient(request);
					commandToDo = extractCommand(request);
					if (!TheApp.CMD_LOGIN.equals(commandToDo) && !request.isRequestedSessionIdFromCookie()) {
						client.getInformant().setAndRespectInformation(
								client.getLocalStringForLabel("Hinweis.Session.Abgelaufen", Frame.FRAME_LANGBUNDLE));
						commandToDo = TheApp.CMD_LOGOUT;
					}
					cmd = cmdSessionNeu(commandToDo, client);
				}
				if (request != null && client != null) {
					Integer bsWidth = Util.getIntegerFromStr(request.getParameter("bs_width"));
					Integer bsHeight = Util.getIntegerFromStr(request.getParameter("bs_height"));
					client.setBsWidth(bsWidth);
					client.setBsHeight(bsHeight);
				}
			}
			logJsessionid(request);
			jspNext = cmd.execute(request, response);
			//Aktionen nach dem Ausfuehren des Commands.
			if (client.getClientState() == IClientState.NEXT_CMD_IN_COMMANDTODO) {
				//--!!losa: zB. login via saml gelaufen
				cmd = lookupCommand(commandToDo, client);
				jspNext = cmd.execute(request, response);
			}
			else if (client.getClientState() == IClientState.NEXT_CMD_IN_REQUEST_ATTRIBUTE_CMD) {
				commandToDo = (String) request.getAttribute(TheApp.CMD);
				cmd = lookupCommand(commandToDo, client);
				jspNext = cmd.execute(request, response);
			}
			if (client.getClientState() == IClientState.LOG_HIM_OUT) {
				cmd = lookupCommand(TheApp.CMD_LOGOUT, client);
				jspNext = cmd.execute(request, response);
			}

		}
		catch (RepositoryException re) {
			//--Meldung fuer den User; irgendwas mit der DB
			jspNext = workOutRepositoryException(jspNext, request, client, cmd, re);
		}
		catch (InformationOnlyException ie) {
			//--Meldung fuer den User; treten oft auf
			client.getInformant().setAndRespectInformation(ie.getMessage());
			if ((ie.getNext() != null) && (!ie.getNext().equals(""))) {
				jspNext = ie.getNext();
			}
		}
		catch (Exception e) {
			//--Programmiererfehler; treten im Betrieb nicht auf ;-)
			e.printStackTrace();
			request = oldRequest; 
			response = oldResponse;
		}

		request.setAttribute("com.hbedv.client", client);

		if (client.getClientState() != IClientState.RESPONSE_ALREADY_DONE) {
			getServletConfig().getServletContext().getRequestDispatcher(getJspDir(jspNext) + jspNext).forward(request, response);
		}

	
	}

	protected String getBundleToken() {
		throw new UnsupportedOperationException("getBundleToken is not implemented yet!");
	}

	protected abstract Client getWebAppClient();

	protected String getJspDir(String jspNext) {
		String dir = null;

		if (jspNext.endsWith(".html")) {
			dir = htmldir;
		}
		else {
			dir = jspdir;
		}

		return dir;
	}

	abstract protected void defineLocale(final Client client);

	protected void log2FindABug(Client client, HttpServletRequest request) {
	}

	protected ICommand cmdSessionNeu(String commandToDo, Client client) {

		ICommand cmd = null;

		if (client.doAuthenticateViaSaml()) {
			//losa: einloggen via Saml
			return lookupCommand(TheApp.CMD_LOGIN, client);
		}

		//--entweder echte neue session oder abgelaufen
		if (commandToDo == null) {
			cmd = lookupCommand(TheApp.CMD_LOGOUT, client);
			client.getCurrentUser().setLoginStatus(ILogin.USER_LOGGED_OUT_BY_HBEDV);
		}
		else if (commandToDo.equals(TheApp.CMD_LOGIN)) {
			cmd = lookupCommand(commandToDo, client);
		}
		else if (commandToDo.equals(TheApp.CMD_LOGIN_DIREKT)) {
			cmd = lookupCommand(commandToDo, client);
		}
		else if (commandToDo.equals(TheApp.CMD_LOGINREQUEST)) {
			cmd = lookupCommand(commandToDo, client);
		}
		else if (commandToDo.equals(TheApp.CMD_LOGIN_ALL)) {
			cmd = lookupCommand(commandToDo, client);
		}
		else if (commandToDo.equals(TheApp.CMD_LOGOUT)) {
			//--session abgelaufen und logout nachher geklickt:
			//wie logout mit session behandeln
			//client.setAuthenticatedMsg(null);
			cmd = lookupCommand(TheApp.CMD_LOGOUT, client);
			client.getCurrentUser().setLoginStatus(ILogin.SESSION_TIMEOUT);
		}
		else {
			cmd = lookupCommand(TheApp.CMD_LOGIN, client);
		}
		//postcondition
		if (cmd == null) {
			throw new NullPointerException("FrameServlet postCondition: cmd==null " + commandToDo);
		}
		return cmd;
	}

	protected ICommand cmdSession(String commandToDo, Client client) {
		ICommand cmd = null;

		if ((commandToDo != null) && commandToDo.equals(TheApp.CMD_LOGOUT)) {
			client.getCurrentUser().setLoginStatus(ILogin.USER_LOGGED_OUT_BY_HIMSELF);
		}

		if (client.doAuthenticateViaSaml()) {
			//losa: einloggen via Saml
			return lookupCommand(TheApp.CMD_LOGIN, client);
		}

		//--Session innerhalb Sessiontimeout
		if (commandToDo == null) {
			cmd = lookupCommand(TheApp.CMD_LOGIN, client);
		}
		else {
			try {
				cmd = lookupCommand(commandToDo, client);
			}
			catch (UnsupportedOperationException ce) {
				cmd = lookupCommand(TheApp.CMD_LOGOUT, client);
				client.getInformant().setAndRespectInformation("Command >" + commandToDo + "< wird nicht unterstützt; " + ce.getMessage());
			}
		}

		//postcondition
		if (cmd == null) {
			throw new NullPointerException("FrameServlet postCondition: cmd==null " + commandToDo);
		}
		return cmd;
	}

	protected ICommand lookupCommand(String commandToDo, Client client) {

		if (commandToDo.equals(TheApp.CMD_LOGOUT)) {
			return new LogoutCommand("logout.jsp");
		}

		/*
		 * if (commandToDo.equals(TheApp.CMD_LOGIN)) { return new
		 * LoginSAMLCommand("template.jsp"); } else if
		 * (commandToDo.equals(TheApp.CMD_LOGIN_DIREKT)) { return new
		 * LoginSAMLCommand("template.jsp"); } else if
		 * (commandToDo.equals(TheApp.CMD_BODY)) { return new
		 * BodyCommand("body.jsp"); } else if (commandToDo.equals(TheApp.CMD_MENUE)) {
		 * return new MenuePortalCommand("menue.jsp"); } else if
		 * (commandToDo.equals(TheApp.CMD_INFOTEXTANZEIGE)) { return new
		 * InfoTextAnzeigeCommand("ui_frame_infotextanzeige_main.jsp"); } else if
		 * (commandToDo.equals(TheApp.CMD_ONETABLE)) { return new
		 * UIFrameOneTableCommand("ui_frame_main_item.jsp"); } else if
		 * (commandToDo.equals(lj_resultsBean.CMD_CHANGEABTEILUNG)) { return new
		 * MenueCommand("template.jsp"); } else if
		 * (commandToDo.equals(lj_resultsBean.CMD_REPORT)) { return new
		 * ReportCommand("ui_frame_main_detail.jsp"); }
		 */
		return null;
	}

	protected String beforeLookupCommand(String commandToDo) {
		String oricmd = commandToDo;
		if (commandToDo == null) {
			throw new NullPointerException("commandToDo == null");
		}
		//orn; 16.12.02: spaeter raus; cmds muessen alle klein sein!
		commandToDo = oricmd.toLowerCase();
		if (!commandToDo.equals(oricmd)) {
			throw new UnsupportedOperationException("commandToDo/oricmd: " + commandToDo + "/" + oricmd);
		}

		return commandToDo;
	}

	protected abstract void doAccessStatistics(Client client, HttpServletRequest request) throws Exception;

	protected String extractCommand(HttpServletRequest request) {
		String command = request.getParameter(TheApp.CMD);
		return command;
	}

	private void logJsessionid(final HttpServletRequest request) {
	}

	private String workOutRepositoryException(final String jspNextIn, final HttpServletRequest request, final Client client,
			final ICommand cmd, final RepositoryException re) {
		 
		String jspNext = jspNextIn;
		try {
			jspNext = ((Command) cmd).getJspNext();
		}
		catch (Exception ex) {
			jspNext = jspNextIn;
			log2FindABug(client, request);
		}

		if (re.getCode() == RepositoryException.NO_RECORD_CHANGED) {
			client.getInformant().setAndRespectInformation(client.getLocalStringForLabel(("DB.Record.Changed"), Frame.FRAME_LANGBUNDLE));
		}
		else if (re.getCode() == RepositoryException.RECORD_IS_LOCKED) {
			client.getInformant().setAndRespectInformation(client.getLocalStringForLabel(("DB.Record.Locked"), Frame.FRAME_LANGBUNDLE));
		}
		else if (re.getCode() == RepositoryException.KEY_VALUE_STILL_BEING_REFERENCED) {
			client.getInformant().setAndRespectInformation(client.getLocalStringForLabel(("DB.Record.Referenced"), Frame.FRAME_LANGBUNDLE));
		}
		else if (re.getCode() == RepositoryException.CONNECTION_REFUSED) {
			client.getInformant().setAndRespectInformation(client.getLocalStringForLabel(("DB.Nicht.Da"), Frame.FRAME_LANGBUNDLE));
		}
		else if (re.getCode() == RepositoryException.INVALID_STATEMENT) {
			client.getInformant().setAndRespectInformation(client.getLocalStringForLabel(("DB.Invalid.Statement"), Frame.FRAME_LANGBUNDLE));
		}
		else {
			jspNext = "logout.jsp";
			log2FindABug(client, request);
		}
		return jspNext;
	}

	protected void initTheApp(TheApp theApp, ServletConfig config) throws Exception {
		addPropertiesToTheApp(theApp, config);
	}

	protected void addPropertiesToTheApp(TheApp theApp, ServletConfig config) throws Exception {
		theApp.setWebappName(config.getServletContext().getInitParameter("WebappName"));
		theApp.setCountryCode(config.getServletContext().getInitParameter("CountryCode"));
	}
}
