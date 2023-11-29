package com.hbedv.kochbuch;
import com.hbedv.frame.*;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


/**
 *  <Description of the Class> $
 *
 *@Source      $Source: /repository/alice/src/com/poi/fux/portal/ClientKochbuch.java,v
 *      $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:46 $
 *@created     mac; 26. November 2003
 *
 */
public class ClientKochbuch extends Client implements HttpSessionBindingListener {
	
	private KochbuchManager kochbuchManager = null;
	private KochbuchBodyManager kochbuchBodyManager = null;
	private KochbuchMenueManager kochbuchMenueManager = null;
	private KochbuchBannerManager kochbuchBannerManager = null;
	private KochbuchFamilyManager kochbuchFamilyManager = null;
	private KochbuchSearchManager kochbuchSearchManager = null;
	private KochbuchVorspeisenManager kochbuchVorspeisenManager = null;
	private KochbuchHauptspeisenManager kochbuchHauptspeisenManager = null;
	private KochbuchDesertManager kochbuchDesertManager = null;
	private KochbuchSalateManager kochbuchSalateManager = null;
	private KochbuchBackwarenManager kochbuchBackwarenManager = null;
	private KochbuchKekseManager kochbuchKekseManager = null;
		
	
	private boolean angemeldet = false;
	private boolean logonError = false;
	private String	userName = "";
	private String  upLoadPic = "";
    private String loadCommand = null;
    private String loadSubCommand = null;
    private Integer loadRezId = null;
    private Integer loadMenId = null;


	public ClientKochbuch() {
		super();
		super.setAppl("kochbuch");
	}

	
	/**
     * @return Returns the upLoadPic.
     */
    public String getUpLoadPic() {
        return upLoadPic;
    }
    /**
     * @param upLoadPic The upLoadPic to set.
     */
    public void setUpLoadPic(String upLoadPic) {
        this.upLoadPic = upLoadPic;
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
    
	public String getUriJSPKochbuch(String filename) {
     
	    return "/kochbuch/" + filename;
	}

	
	
	public String getLocalStringForLabel(String str) 
	{
		return (getLocalStringForLabel(str, Kochbuch.PORTAL_LANGBUNDLE));
	}	
	
	public String getDirPortalProperties() {
		return getDirProperty() + "frame.properties";
	}


	public synchronized KochbuchManager getKochbuchManager() {
		//lazy initialization
		if (kochbuchManager == null) {
			kochbuchManager = new KochbuchManager(this);
		}
		return kochbuchManager;
	}

	public void setKochbuchManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchManager == null) {
			kochbuchManager = new KochbuchManager(this);
		}
		super.setCurManager(kochbuchManager);
	}

	public synchronized KochbuchBodyManager getKochbuchBodyManager() {
		//lazy initialization
		if (kochbuchBodyManager == null) {
			kochbuchBodyManager = new KochbuchBodyManager(this);
		}
		return kochbuchBodyManager;
	}

	public void setKochbuchBodyManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchBodyManager == null) {
			kochbuchBodyManager = new KochbuchBodyManager(this);
		}
		super.setCurManager(kochbuchBodyManager);
	}
	
		
	public synchronized KochbuchMenueManager getKochbuchMenueManager() {
		//lazy initialization
		if (kochbuchMenueManager == null) {
			kochbuchMenueManager = new KochbuchMenueManager(this);
		}
		return kochbuchMenueManager;
	}

	public void setKochbuchMenueManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchMenueManager == null) {
			kochbuchMenueManager = new KochbuchMenueManager(this);
		}
		super.setCurManager(kochbuchMenueManager);
	}
	
	public synchronized KochbuchBannerManager getKochbuchBannerManager() {
		//lazy initialization
		if (kochbuchBannerManager == null) {
			kochbuchBannerManager = new KochbuchBannerManager(this);
		}
		return kochbuchBannerManager;
	}
	
	public void setKochbuchBannerManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchBannerManager == null) {
			kochbuchBannerManager = new KochbuchBannerManager(this);
		}
		super.setCurManager(kochbuchBannerManager);
	}
	
	public synchronized KochbuchFamilyManager getKochbuchFamilyManager() {
		//lazy initialization
		if (kochbuchFamilyManager == null) {
			kochbuchFamilyManager = new KochbuchFamilyManager(this);
		}
		return kochbuchFamilyManager;
	}
	
	public void setKochbuchFamilyManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchFamilyManager == null) {
			kochbuchFamilyManager = new KochbuchFamilyManager(this);
		}
		super.setCurManager(kochbuchFamilyManager);
	}
	
	public synchronized KochbuchKekseManager getKochbuchKekseManager() {
		//lazy initialization
		if (kochbuchKekseManager == null) {
			kochbuchKekseManager = new KochbuchKekseManager(this);
		}
		return kochbuchKekseManager;
	}
	
	public void setKochbuchKekseManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchKekseManager == null) {
			kochbuchKekseManager = new KochbuchKekseManager(this);
		}
		super.setCurManager(kochbuchKekseManager);
	}
	
	public synchronized KochbuchBackwarenManager getKochbuchBackwarenManager() {
		//lazy initialization
		if (kochbuchBackwarenManager == null) {
			kochbuchBackwarenManager = new KochbuchBackwarenManager(this);
		}
		return kochbuchBackwarenManager;
	}
	
	public void setKochbuchBackwarenManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchBackwarenManager == null) {
			kochbuchBackwarenManager = new KochbuchBackwarenManager(this);
		}
		super.setCurManager(kochbuchBackwarenManager);
	}
	
	
	public synchronized KochbuchSalateManager getKochbuchSalateManager() {
		//lazy initialization
		if (kochbuchSalateManager == null) {
			kochbuchSalateManager = new KochbuchSalateManager(this);
		}
		return kochbuchSalateManager;
	}
	
	public void setKochbuchSalateManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchSalateManager == null) {
			kochbuchSalateManager = new KochbuchSalateManager(this);
		}
		super.setCurManager(kochbuchSalateManager);
	}

	
	public synchronized KochbuchDesertManager getKochbuchDesertManager() {
		//lazy initialization
		if (kochbuchDesertManager == null) {
			kochbuchDesertManager = new KochbuchDesertManager(this);
		}
		return kochbuchDesertManager;
	}
	
	public void setKochbuchDesertManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchDesertManager == null) {
			kochbuchDesertManager = new KochbuchDesertManager(this);
		}
		super.setCurManager(kochbuchDesertManager);
	}
	

	public synchronized KochbuchHauptspeisenManager getKochbuchHauptspeisenManager() {
		//lazy initialization
		if (kochbuchHauptspeisenManager == null) {
			kochbuchHauptspeisenManager = new KochbuchHauptspeisenManager(this);
		}
		return kochbuchHauptspeisenManager;
	}
	
	public void setKochbuchHauptspeisenManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchHauptspeisenManager == null) {
			kochbuchHauptspeisenManager = new KochbuchHauptspeisenManager(this);
		}
		super.setCurManager(kochbuchHauptspeisenManager);
	}

	public synchronized KochbuchVorspeisenManager getKochbuchVorspeisenManager() {
		//lazy initialization
		if (kochbuchVorspeisenManager == null) {
			kochbuchVorspeisenManager = new KochbuchVorspeisenManager(this);
		}
		return kochbuchVorspeisenManager;
	}
	
	public void setKochbuchVorspeisenManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchVorspeisenManager == null) {
			kochbuchVorspeisenManager = new KochbuchVorspeisenManager(this);
		}
		super.setCurManager(kochbuchVorspeisenManager);
	}
	
	public synchronized KochbuchSearchManager getKochbuchSearchManager() {
		//lazy initialization
		if (kochbuchSearchManager == null) {
			kochbuchSearchManager = new KochbuchSearchManager(this);
		}
		return kochbuchSearchManager;
	}
	
	public void setKochbuchSearchManagerAsManagerNeu() {
		//lazy initialization
		if (kochbuchSearchManager == null) {
			kochbuchSearchManager = new KochbuchSearchManager(this);
		}
		super.setCurManager(kochbuchSearchManager);
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
   
		/**
		 * @return Returns the loadMenId.
		 */
		public Integer getLoadMenId() {
			return loadMenId;
		}
		/**
		 * @param loadMenId The loadMenId to set.
		 */
		public void setLoadMenId(Integer loadMenId) {
			this.loadMenId = loadMenId;
		}
		/**
		 * @return Returns the loadRezId.
		 */
		public Integer getLoadRezId() {
			return loadRezId;
		}
		/**
		 * @param loadRezId The loadRezId to set.
		 */
		public void setLoadRezId(Integer loadRezId) {
			this.loadRezId = loadRezId;
		}
 }
