package com.hbedv.frame;


import java.util.HashMap;
import java.util.Timer;

import javax.servlet.http.HttpServletResponse;

import com.hbedv.lj_results.LjTask;

/**
 *  <Description of the Class>
 *
 */
@SuppressWarnings("unchecked")
public class TheApp {
	
    public final static String ATTRIBUTE_KEY = "com.poi.fux.theapp";
	
  public final static String CMD = "cmd";
  public final static String SUB_CMD_SUBCMD = "subcmd";

  public final static String CMD_FCMD = "fcmd";
  public final static String CMD_START = "cmd_start";
  public final static String CMD_BANNER = "cmd_banner";
  public final static String CMD_FAMILY = "cmd_family";
  public final static String CMD_SEARCH = "cmd_search";
  public final static String CMD_FSUBCMD = "fsubcmd";

  public final static String CMD_LOGIN_DIREKT = "login_direkt";
  public final static String CMD_LOGINREQUEST = "loginrequest";
  public final static String CMD_WYSIWYG 		= "wysiwyg";
  public final static String CMD_LOGIN_ALL = "login_all";
  public final static String CMD_LOGIN_USER = "login_user";  

  public final static String CMD_NOTIFICATION = "notification";
  public final static String CMD_ONETABLE = "onetable";
  public final static String CMD_HELPER = "helper";
  public final static String CMD_HELPERSELECT = "helperselect";

  public final static String SUB_CMD_EXPORT = "export";
  public final static String SUB_CMD_AUSWERTEN = "auswerten";
  public final static String SUB_CMD_SCHLIESSEN = "schliessen";
  public final static String SUB_CMD_CANCEL = "cancel";
  public final static String SUB_CMD_BEARBEITEN = "bearbeiten";
  public final static String SUB_CMD_INFOTEXTE = "scShInfoTXT";
  public final static String SUB_CMD_DRUCKEN = "drucken";

  public final static String SAML = "saml";
  public final static String SAML_ART = "SAMLart";
  public final static String MARKE = "Marke";
  public final static String FABRIKAT = "Fabrikat";
  public final static String URL_IS_ENCODED = "UrlIsEncoded";

  public final static String NAME_DUPLIKAT = "Dup-";

  public final static String CMD_INFOTEXTANZEIGE = "infotextanzeige";
  public final static String CMD_LOGOUT = "logout";

  public final static String CMD_LOGIN = "login";
  public final static String CMD_MENUE = "menue";
  public final static String CMD_BODY = "body";
  public final static String CMD_TEMPLATE = "template";

  public final static String ID_MENUE = "id_menue";
  public final static String ID_ITEM = "id_item";
  public final static String ID_AST = "id_ast";
  public final static int ID_MENUE_NOT_VALID = -8888;

  public final static String NAME_NEU = "Neu";

  public final static String SUB_CMD_SPEICHERE = "speichere";
  public final static String SUB_CMD_LOESCHE = "loesche";
  public final static String SUB_CMD_DUPLIZIERE = "dupliziere";
  public final static String SUB_CMD_NEU = "neu";
  public final static String SUB_CMD_AKTUALISIERE = "aktualisiere";
  public final static String SUB_CMD_REITE = "reiten";
  public final static String SUB_CMD_ITEM_DOWN = "item_down";
  public final static String SUB_CMD_TABLE_DOWN = "table_down";
  public final static String SUB_CMD_DETAIL = "detail";
  public final static String SUB_CMD_SORTIERE = "sortiere";
  public final static String SUB_CMD_SUCHE = "suchen";
  public final static String SUB_CMD_WEITER = "weiter";
  public final static String SUB_CMD_ZURUECK = "zurueck";
  public final static String SUB_CMD_VORWAERTS = "vorwaerts";
  public final static String SUB_CMD_ADD2AST = "add2ast";
  public final static String SUB_CMD_TAB = "tab";
  public final static String SUB_CMD_DO_NOTHING = "do_nothing";
  public final static String SUB_CMD_INIT = "init";

  /**  @todo: orn; dd.mm.yy: immer klein */
  public final static String SUB_CMD_ENTFERNEN = "scEntfe";
  public final static String SUB_CMD_HINZUFUEGEN = "scHinzuf";

  public final static String RECHNUNG = "rechnung";

  //Localeproperties
  public final static String LOCALE_DATE = "locale.date";
  public final static String LOCALE_LABEL = "locale.label";

	public final static String REDIRECT = "redirect";

	private AliceSortMap asmFabrikate = null;
	private String webappName = null;
	private String countryCode = null;
	
	private HashMap hmArtifact = null;
	
	  /**  Constructor for the TheApp object */
	public TheApp() {
		hmArtifact = new HashMap();
		Timer myTimer = new Timer();
		LjTask myTask = new LjTask ();
		myTimer.schedule(myTask, 120000, 1000 * 60 * 60 * 4); //Alle 4 Stunden Pic´s neu erzeugen
	}


  /**
   *  Description of the Method
   *
   *@param  origURL   Description of Parameter
   *@param  response  Description of Parameter
   *@return           Description of the Returned Value
   */
  public static String encodeURL(String origURL, HttpServletResponse response) {
    if (origURL.toLowerCase().indexOf("javascript:") > -1) {
      return origURL;
    }

    if (origURL.indexOf("?") < 0) {
      origURL = origURL + "?" + URL_IS_ENCODED + "=true";
    }
    else {
      origURL = origURL + Util.HTML_AMP + URL_IS_ENCODED + "=true";
    }

    origURL += Util.HTML_AMP + "pk=" + System.currentTimeMillis();

    return response.encodeURL(origURL);
  }


  /**
   *  Gets the asmFabrikate attribute of the TheApp object
   *
   *@return    Kopie der AliceSortMap mit den Fabrikatsinformationen
   */
  public AliceSortMap getAsmFabrikate() {
    return (AliceSortMap) asmFabrikate.clone();
  }


  

	/**
	 * Liefert den Webapp Namen in Kleinbuchstaben zurück (Einstellung in server.xml)
	 */
	public String getWebappName() {
		return webappName;
	}

	/**
	 * @param string
	 */
	public void setWebappName(String string) {
		if (string != null)
			webappName = string.toLowerCase();
	}

	/**
	 * Liefert den Country Code in Kleinbuchstaben zurück (Einstellung in server.xml)
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param string
	 */
	public void setCountryCode(String string) {
		if (string != null)
			countryCode = string.toLowerCase();
	}

  /**
   * @return Returns the hmArtifact.
   */
  public HashMap getHmArtifact() {
    return hmArtifact;
  }
  
  /**
   * Fügt ein Artifact hinzu - liefert false zurück wenn es bereits einen key mit dem selben namen gibt und 
   * das artifact nicht gespeichert werden konnte
   * @param saml_artifact
   * @param ticket
   * @return
   */
  public synchronized boolean addArtifact(String saml_artifact, Object ticket) {
    boolean saved = false;
    
    //do not allow duplicates!
    if (!hmArtifact.containsKey(saml_artifact)) {
      hmArtifact.put(saml_artifact, ticket);
      saved = true;
    }  
    return saved;
  }
}
