package com.hbedv.lj_results;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.hbedv.frame.Client;


/**
 *  <Description of the Class> $
 *
 *@Source      $Source: /repository/alice/src/com/poi/fux/portal/Clientlj_results.java,v
 *      $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:46 $
 *@created     ich; 26. November 2003
 *
	Last change: PIG 27.11.2007 16:33:55
 */
public class ClientLjResults extends Client implements HttpSessionBindingListener {
	
	private LjResultsManager ljResultsManager = null;
		
	private boolean angemeldet = false;
	private boolean logonError = false;
	private String	userName = "";
    private String loadCommand = null;
    private String loadSubCommand = null;
    private String urlCode=null;


	public ClientLjResults() {
		super();
		super.setAppl("LjResults");
	}

	/**
     * @return Returns the logonError.
     */
    public boolean isLogonError() {
        return logonError;
    }

    /**
     * @param logonError The logonError to set.
     */
    public void setLogonError(boolean logonError) {
        this.logonError = logonError;
    }

    /**
     * @return Returns the angemeldet.
     */
    public boolean isAngemeldet() {
        return angemeldet;
    }
    /**
     * @param angemeldet The angemeldet to set.
     */
    public void setAngemeldet(boolean angemeldet) {
        this.angemeldet = angemeldet;
    }	
    
    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        String user = "";
        if (isAngemeldet()) {
            user = userName;
        }
        return user;
    }
    /**
     * @param userName The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }    
    
	public String getUriJSPLiveJournal(String filename) {
     
	    return "lj_results/" + filename;
	}

	
	
	public String getLocalStringForLabel(String str) 
	{
		return (getLocalStringForLabel(str, LjResults.PORTAL_LANGBUNDLE));
	}	
	
	public String getDirPortalProperties() {
		return getDirProperty() + "frame.properties";
	}


	public synchronized LjResultsManager getLjResultsManager() {
		//lazy initialization
		if (ljResultsManager == null) {
			ljResultsManager = new LjResultsManager(this);
		}
		return ljResultsManager;
	}
	

	public void setLjResultsManagerAsManagerNeu() {
		//lazy initialization
		if (ljResultsManager == null) {
			ljResultsManager = new LjResultsManager(this);
		}
		super.setCurManager(ljResultsManager);
	}

	
	/* 
	 * Wird automatisch aufgerufen (Listener) wenn der Client an die Session angehängt 
	 * wird 
	 */
	public void valueBound(HttpSessionBindingEvent sessionEvent) {

	}


	/* 
	 * Wird automatisch aufgerufen (Listener) wenn der Client von der Session entfernt 
	 * und die Session zerstört wird
	 * Wir schreiben dann noch den Grund für das Logout in die Tabelle pl_personlogin
	 * 
	 */
	public void valueUnbound(HttpSessionBindingEvent sessionEvent) {
		
	}
  
	/**
	 * @return Returns the loadCommand.
	 */
	public String getLoadCommand() {
		return loadCommand;
	}
	/**
	 * @param loadCommand The loadCommand to set.
	 */
	public void setLoadCommand(String loadCommand) {
		this.loadCommand = loadCommand;
	}
	/**
	 * @return Returns the loadSubCommand.
	 */
	public String getLoadSubCommand() {
		return loadSubCommand;
	}
	/**
	 * @param loadSubCommand The loadSubCommand to set.
	 */
	public void setLoadSubCommand(String loadSubCommand) {
		this.loadSubCommand = loadSubCommand;
	}

	public String getUrlCode() {
		if (urlCode == null || urlCode.equals("")) {
			urlCode = "&pk=" + System.currentTimeMillis();	
		}
		return urlCode;
	}

	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}
   
 }
