package com.hbedv.livejournal;


import javax.servlet.*;
import javax.servlet.http.*;


import com.hbedv.frame.*;

/**
 *  Dialogeinstieg der Webapp KochbuchBean. <BR>
 *   */
public class LiveJournalServlet extends FrameServlet {

	private static final long serialVersionUID = 3544670685352702009L;
	
	
 
	protected Client getWebAppClient() {
	    return new ClientLiveJournal();
	}

	protected ICommand lookupCommand(String commandToDo, Client client) {
		commandToDo = super.beforeLookupCommand(commandToDo);
		
		ICommand superCommand = super.lookupCommand(commandToDo, client);
		
		if (superCommand != null)
		    return superCommand;
		else { 
			
	        if (commandToDo.equals(TheApp.CMD_LOGIN_ALL) || commandToDo.equals(TheApp.CMD_LOGIN)) {
	            return new LoginAllCommand("start.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_START) || commandToDo.equals(LiveJournal.CMD_PAGE)) {
	            return new LiveJournalCommand("page1.jsp");
	        }
	        else if (commandToDo.equals(LiveJournal.CMD_FERTIG)) {
	            return new FertigCommand("finished.jsp");
	        }
		}
		return null;
	}
  
  

	protected void initTheApp(TheApp theApp, ServletConfig config)
	throws Exception {
	    super.initTheApp(theApp, config);
	}


	protected void defineLocale(Client client) {
		// TODO Auto-generated method stub
	}


	protected void doAccessStatistics(Client client, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
	}

}
