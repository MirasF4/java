package com.hbedv.frame;

import java.net.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.servlet.http.*;
import com.hbedv.frame.bean.*;
import com.hbedv.frame.clientstate.*;
import com.hbedv.frame.util.*;

public abstract class Client {

	private static final String		SINGLE_WINDOW_MODE_KEY	= "singleWindowMode";
	private static final String		NO_FRAMES_MODE_KEY			= "noFramesMode";
	private String					appl										= null;
	private static final String		TRUE_VALUE							= String.valueOf(true);
	protected final static String	fS											= java.io.File.separator;
	private String					idSession								= null;
	private TheApp					theApp									= null;
	private Manager					manager									= null;
	private LoginAllManager			loginAllManager					= null;
	private LoginMobilManager		loginMobilManager					= null;
	private Informant				informant								= null;
	private LocaleWrapper			localCur								= new LocaleWrapper();
	private boolean					doAuthenticateViaSaml		= false;
	private ClientState				clientState							= IClientState.UNDEFINED;

	//Manager ----------------------------------

	private java.net.URL			URLClient								= null;
	private String					servletpath							= null;
	private String					appRootDir							= null;
	private String					appRootUrl							= null;
	private String					httpServer							= null;
	private String					artifact								= null;
	private Integer					idMenue									= null;
	private String					jspMessage							= null;
	private CurrentUserBean			currentUser							= null;
	private boolean					singleWindowMode				= false;
	private boolean					noFramesMode						= false;
	private boolean					ignoreCertificate				= false;
	private SQLException			sqlErr									= null;
	private boolean					startFamiliFrame				= false;
	private boolean					mobileVersion					= false;
	
	private Integer bsWidth  = null;
	private Integer bsHeight = null;
	
	
	public Client() {
		super();
	}

	public void init() {
		//CurrentUser initialisieren
		this.setCurrentUser(new CurrentUserBean());
	}

	
	
	public void setAppl(String s) {
		appl = s;
	}

	public String getAppl() {
		return appl;
	}

	public Integer getIdPerson() {
		return getCurrentUser().getIdPerson();
	}

	public String getMessage() {
		if (jspMessage == null) jspMessage = "";
		return jspMessage;
	}

	public void setMessage(String msg) {
		jspMessage = msg;
	}

	public TheApp getTheApp() {
		return theApp;
	}

	public String getDirTemp() {
		return getAppRootDir() + "tmp" + Client.fS;
	}

	public String getUriImageGlobal(String filename) {
		return getAppRootUrl() + "/images/" + filename;
	}

	public String getUriCssGlobal(String filename) {
		return getAppRootUrl() + "/css/" + filename;
	}

	public String getUriJSGlobal(String filename) {
		return getAppRootUrl() + "/include/" + filename;
	}

	public String getUriJSPGlobal(String filename) {
		return getAppRootUrl() + "/jsp/" + filename;
	}

	public Manager getManager() {
		return manager;
	}

	public synchronized LoginAllManager getLoginAllManager() {
		if (loginAllManager == null) {
			loginAllManager = new LoginAllManager(this);
		}
		return loginAllManager;
	}

	public synchronized LoginMobilManager getLoginMobilManager() {
		if (loginMobilManager == null) {
			loginMobilManager = new LoginMobilManager(this);
		}
		return loginMobilManager;
	}
	
	public void setLoginAllManagerAsManagerNeu() {
		if (loginAllManager == null) {
			loginAllManager = new LoginAllManager(this);
		}
		this.setCurManager(loginAllManager);
	}

	public void setLoginMobilManagerAsManagerNeu() {
		if (loginMobilManager == null) {
			loginMobilManager = new LoginMobilManager(this);
		}
		this.setCurManager(loginMobilManager);
	}

	public String getUserName() {
		return getCurrentUser().getUserName();
	}

	public synchronized Informant getInformant() {
		if (informant == null) {
			informant = new Informant();
		}
		return informant;
	}

	public String getAuthenticatedMsg() {
		return getInformant().getAndRespectConfirmInformation();
	}

	public LocaleWrapper getLocalCur() {
		return localCur;
	}

	public String getPasswort() {
		return getCurrentUser().getPasswort();
	}

	public String getLocalStringForLabel(String token, String resourcebundle) {
		String msg = Util.UNDEFINED_STRING;
		try {
			if (resourcebundle == null) {
				throw new NullPointerException("resourcebundle==null");
			}
			if (token == null) {
				throw new NullPointerException("token==null");
			}
			if (getLocalCur() == null) {
				throw new NullPointerException("getLocalCur()==null");
			}
			if (getLocalCur().getLocaleForLabels() == null) {
				throw new NullPointerException("getLocalCur().getLocaleForLabels()==null");
			}
			msg = (ResourceBundle.getBundle(resourcebundle, getLocalCur().getLocaleForLabels())).getString(token);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return msg;
	}

	public String getLocalStringForDate(String token, String resourcebundle) {
		String msg = Util.UNDEFINED_STRING;
		try {
			if (resourcebundle == null) {
				throw new Exception("resourcebundle==null");
			}
			if (token == null) {
				throw new Exception("token==null");
			}
			if (getLocalCur() == null) {
				throw new Exception("getLocalCur()==null");
			}
			msg = (ResourceBundle.getBundle(resourcebundle, getLocalCur().getLocaleForDate())).getString(token);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return msg;
	}

	public String getUrlTemp() {
		return getAppRootUrl() + "/tmp/";
	}

	public String getDirProperty() {
		return getAppRootDir() + ".." + Client.fS + ".." + Client.fS + "prop" + Client.fS + getTheApp().getCountryCode() + Client.fS;
	}

	public String getDirAlleWebappProperties() {
		return getDirProperty() + "alle_webapps.properties";
	}

	public ClientState getClientState() {
		return clientState;
	}

	public String getIdSession() {
		return idSession;
	}

	public java.net.URL getURLClient() {
		return URLClient;
	}

	public String getAppRootDir() {
		return appRootDir;
	}

	public String getAppRootUrl() {
		return appRootUrl;
	}

	public String getUriForm() {
		return getAppRootUrl() + this.servletpath;
	}

	public java.net.URL getUrlItem(String cmd, String subcmd) throws Exception {
		if (cmd == null) {
			throw new NullPointerException("client.getUrlItem(cmd, subcmd): cmd==null");
		}
		if (subcmd == null) {
			throw new NullPointerException("subcmd==null");
		}
		return getUrlHelper(cmd, subcmd, null);
	}

	public java.net.URL getUrlItem(String cmd, String subcmd, Object idItem) throws MalformedURLException {
		if (cmd == null) {
			throw new NullPointerException("getUrlItem(cmd, subcmd, idItem): cmd==null");
		}
		if (subcmd == null) {
			throw new NullPointerException("subcmd==null");
		}
		if (idItem == null) {
			throw new NullPointerException("idItem==null");
		}
		return getUrlHelper(cmd, subcmd, idItem);
	}

	public java.net.URL getUrlItem(String cmd) throws Exception {
		if (cmd == null) {
			throw new NullPointerException("getUrlItem(cmd): cmd==null");
		}
		return getUrlHelper(cmd, null, null);
	}

	public String getLocaleCurrency() throws Exception {
		NumberFormat fmt = NumberFormat.getCurrencyInstance(localCur.getLocaleForLabels());
		return (String) Util.nvlConvert(((DecimalFormat) fmt).getPositivePrefix(), " ");
	}

	public String getLocaleMoney(Money money) throws Exception {
		NumberFormat fmt = NumberFormat.getCurrencyInstance(this.localCur.getLocaleForDate());
		String mF = fmt.format(money.getMoney().doubleValue());
		return mF;
	}

	public String getLocaleMoney(Money money, int round) throws Exception {
		NumberFormat fmt = NumberFormat.getCurrencyInstance(this.localCur.getLocaleForDate());
		fmt.setMaximumFractionDigits(round);
		String mF = fmt.format(money.getMoney().doubleValue());

		return mF;
	}

	public String getArtifact() {
		return artifact;
	}

	public Integer getIdMenue() {
		return idMenue;
	}

	public void setPersonId(Integer newPersonId) {
		getCurrentUser().setIdPerson(newPersonId);
	}

	public void setTheApp(TheApp newTheApp) {
		this.theApp = newTheApp;
	}

	public void setCurManager(Manager curManager) {
		manager = curManager;
	}

	public void setUserName(String userName) {
		getCurrentUser().setUserName(userName);
	}

	public void setLocalCur(LocaleWrapper localCur) {
		this.localCur = localCur;
	}

	public void setPasswort(String newPasswort) {
		getCurrentUser().setPasswort(newPasswort);
	}

	public void setDoAuthenticateViaSaml(boolean authenticateViaSaml) {
		this.doAuthenticateViaSaml = authenticateViaSaml;
	}

	public void setClientState(ClientState clientState) {
		this.clientState = clientState;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public void setURLClient(java.net.URL newURLClient) {
		this.URLClient = newURLClient;
	}

	public void setAppRootDir(String newAppRootDir) {
		this.appRootDir = newAppRootDir;
	}

	public void setAppRootUrl(String newAppRootUrl) {
		this.appRootUrl = newAppRootUrl;
	}

	public void setHttpServer(String newServerName, String newServerPort) {
		this.httpServer = "http://" + newServerName + ":" + newServerPort;
	}

	public String getHttpServer() {
		return this.httpServer;
	}

	public void setServletpath(String newServletpath) {
		this.servletpath = newServletpath;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public void setIdMenue(Integer idMenue) {
		this.idMenue = idMenue;
	}

	public java.sql.Date parseDateRespectEmpty(String sd) throws Exception, ParseException {
		return DateAndTime.parseDateRespectEmpty(sd, this.getLocalCur().getLocaleForDate());
	}

	public boolean doAuthenticateViaSaml() {
		return doAuthenticateViaSaml;
	}

	public String formatDate(java.sql.Date date) throws Exception {
		return DateAndTime.formatDate(date, getLocalCur().getLocaleForDate());
	}

	public String formatDate(java.sql.Timestamp date) throws Exception {
		return DateAndTime.formatDate(date, getLocalCur().getLocaleForDate());
	}

	public java.net.URL add2URLClient(String cmd) {
		java.net.URL backUrl = null;
		try {
			backUrl = new java.net.URL(URLClient.getProtocol(), URLClient.getHost(), URLClient.getPort(), cmd);
		}
		catch (java.net.MalformedURLException mEx) {
			throw new UnsupportedOperationException(mEx.getMessage());
		}
		return backUrl;
	}

	private java.net.URL getUrlHelper(String cmd, String subcmd, Object idItem) throws MalformedURLException {

		String str = this.appRootUrl + this.servletpath + "?" + TheApp.CMD + "=" + cmd;
		if (subcmd != null) {
			str += "&amp;" + TheApp.SUB_CMD_SUBCMD + "=" + subcmd;
		}

		if (idItem != null) {
			str += "&amp;" + TheApp.ID_ITEM + "=" + idItem.toString();
		}
		java.net.URL url = new java.net.URL(URLClient.getProtocol(), URLClient.getHost(), URLClient.getPort(), str);
		return url;
	}

	public CurrentUserBean getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserBean user) {
		currentUser = user;
	}

	public void setSingleWindowMode(boolean singleWindowMode) {
		this.singleWindowMode = singleWindowMode;
	}

	public void setSingleWindowMode(HttpServletRequest request) {
		setSingleWindowMode(TRUE_VALUE.equals(request.getParameter(SINGLE_WINDOW_MODE_KEY)));
	}

	public boolean isSingleWindowMode() {
		return singleWindowMode;
	}

	public void setNoFramesMode(boolean noFramesMode) {
		this.noFramesMode = noFramesMode;
	}

	public void setNoFramesMode(HttpServletRequest request) {
		setNoFramesMode(TRUE_VALUE.equals(request.getParameter(NO_FRAMES_MODE_KEY)));
	}

	public boolean isNoFramesMode() {
		return noFramesMode;
	}

	public void setIgnoreCertificate(boolean ignoreCertificate) {
		this.ignoreCertificate = ignoreCertificate;
	}

	public boolean isIgnoreCertificate() {
		return ignoreCertificate;
	}
	/**
	 * @return Returns the sqlErr.
	 */
	public SQLException getSqlErr() {
		return sqlErr;
	}
	/**
	 * @param sqlErr
	 *          The sqlErr to set.
	 */
	public void setSqlErr(SQLException sqlErr) {
		this.sqlErr = sqlErr;
	}
	/**
	 * @return Returns the bsHeight.
	 */
	public Integer getBsHeight() {
		return bsHeight;
	}
	/**
	 * @param bsHeight The bsHeight to set.
	 */
	public void setBsHeight(Integer bsHeight) {
		this.bsHeight = bsHeight;
	}
	/**
	 * @return Returns the bsWidth.
	 */
	public Integer getBsWidth() {
		return bsWidth;
	}
	/**
	 * @param bsWidth The bsWidth to set.
	 */
	public void setBsWidth(Integer bsWidth) {
		this.bsWidth = bsWidth;
	}

	public boolean isStartFamiliFrame() {
		return startFamiliFrame;
	}

	public void setStartFamiliFrame(boolean startFamiliFrame) {
		this.startFamiliFrame = startFamiliFrame;
	}

	public boolean isMobileVersion() {
		return mobileVersion;
	}

	public void setMobileVersion(boolean mobileVersion) {
		this.mobileVersion = mobileVersion;
	}
}
