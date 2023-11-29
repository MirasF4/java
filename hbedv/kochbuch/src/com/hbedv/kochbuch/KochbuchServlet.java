package com.hbedv.kochbuch;


import javax.servlet.*;
import javax.servlet.http.*;


import com.hbedv.frame.*;

/**
 *  Dialogeinstieg der Webapp KochbuchBean. <BR>
 *  Das KochbuchBean unterstuetzt die Marken: Audi Porsche Seat Skoda VW LNF $
 */
public class KochbuchServlet extends FrameServlet {

	private static final long serialVersionUID = 3544670685352702009L;
	
	
 
	protected Client getWebAppClient() {
	    return new ClientKochbuch();
	}

	protected ICommand lookupCommand(String commandToDo, Client client) {
	    commandToDo = super.beforeLookupCommand(commandToDo);
	    
	    ICommand superCommand = super.lookupCommand(commandToDo, client);
	    
	    if (superCommand != null)
	        return superCommand;
	    else
	        if (commandToDo.equals(TheApp.CMD_BODY)) {
	            return new KochbuchBodyCommand("body.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_MENUE)) {
	            return new KochbuchMenueCommand("menue.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_BANNER)) {
	            return new KochbuchBannerCommand("banner.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_LOGIN_ALL) || commandToDo.equals(TheApp.CMD_LOGIN)) {
	            return new LoginAllCommand("template.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_LOGIN_MOBIL)) {
	            return new LoginMobilCommand("template.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_FAMILY)) {
	            return new KochbuchFamilyCommand("family.jsp");
	        }
	        else if (commandToDo.equals(TheApp.CMD_SEARCH)) {
	            return new KochbuchSearchCommand("search.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_VORSPEISEN)) {
	            return new KochbuchVorspeisenCommand("vorspeisen.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_HAUPTSPEISEN)) {
	            return new KochbuchHauptspeisenCommand("hauptspeisen.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_DESERTS)) {
	            return new KochbuchDesertCommand("desert.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_SALATE)) {
	            return new KochbuchSalateCommand("salate.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_BACKWAREN)) {
	            return new KochbuchBackwarenCommand("backwaren.jsp");
	        }
	        else if (commandToDo.equals(Kochbuch.CMD_KEKSE)) {
	            return new KochbuchKekseCommand("kekse.jsp");
	        }
	        else {
	            throw new UnsupportedOperationException("**E: KochbuchBean, command >" + commandToDo + "< not supported!");
	        }
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
