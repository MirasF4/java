package com.hbedv.frame;


import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.*;

import com.hbedv.db.*;


/**
 *  Implementiert das Commandpattern.
 *
 */
@SuppressWarnings("unchecked")
public abstract class Command implements ICommand {
  protected String jspNext = null;
  protected Client client = null;
  protected Manager manager = null;



  /**
   *  Constructor for the Command.
   *
   *@param  newNext  jene Defaultjspseite die als nächstes aufgerufen wird.
   */
  public Command(String newNext) {
    this.jspNext = newNext;
  }


  /**
   *  Gets the jspNext attribute of the Command object
   *
   *@return    The jspNext value
   */
  public String getJspNext() {
    return jspNext;
  }

  
  public void setJspNext(String jsp) {
  	jspNext = jsp;
  }

  /**
   *  toString().
   *
   *@return as String
   */
  public String toString() {
    return super.toString() + " " + jspNext;
  }

	protected void setClientFromRequest(HttpServletRequest request) {
		
		if (request == null) {
			throw new NullPointerException("request == null");
		}

		HttpSession session = request.getSession(true);
		try {
			client = (Client) session.getAttribute(session.getId());
		}
		catch (Exception e) {
			client = null;
		}

		if (client == null) {
			throw new NullPointerException("client == null");
		}
	}

  /**
   *  Description of the Method
   *
   *@param  request        Description of Parameter
   *@param  response       Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public synchronized String execute(HttpServletRequest request,
                                     HttpServletResponse response)
    throws Exception {

		setClientFromRequest(request);

    String subcmd = null;
    if (this instanceof LogoutCommand) {
      subcmd = TheApp.SUB_CMD_DO_NOTHING;
    }
    else {
      subcmd = request.getParameter(TheApp.SUB_CMD_SUBCMD);
    }

    //wieder den original manager setzen
    setManager();


    if (subcmd == null || subcmd.equals(TheApp.SUB_CMD_INIT)) {
      init(request);
    }
    else {
      if (subcmd.equals(TheApp.SUB_CMD_SPEICHERE)) {
        //!!sp 1: rufe Ableitung
        speichere(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_LOESCHE)) {
        loesche(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_DUPLIZIERE)) {
        dupliziere(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_NEU)) {
        neu(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_AKTUALISIERE)) {
        aktualisiere(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_REITE)) {
        reiten(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_ITEM_DOWN)) {
        itemDown(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_TABLE_DOWN)) {
        tableDown(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_DETAIL)) {
        detail(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_SORTIERE)) {
        sortiere(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_WEITER)) {
        weiter(request);
      }
      else if (subcmd.equals(TheApp.SUB_CMD_DO_NOTHING)) {
        ;//12.12.02; orn: damit immer alles gleich lauft!
      }
      else {
        specialCommand(request, response);
      }
    }
    return jspNext;
  }


  /**
   *  Gets the parameterAsQueryString attribute of the Command object
   *
   *@param  parameterMap  Description of Parameter
   *@return               The parameterAsQueryString value
   */
  protected synchronized String getParameterAsQueryString(Map parameterMap)
  throws UnsupportedEncodingException {

    StringBuffer queryString = new StringBuffer();
    Iterator it = parameterMap.keySet().iterator();
    boolean isNext = it.hasNext();
    while (isNext) {
      String key = (String) it.next();
      String values[] = (String[]) parameterMap.get(key);
      boolean doNotAddParamaeter = key.equals(TheApp.SAML_ART);
      if (!doNotAddParamaeter) {
        for (int i = 0; i < values.length; i++) {
          /* Der SAML_ARTifact wird hier nicht übernommen.
            *  Grund: Der User ist bereits authentifiziert worden über SAML (weil sonst gäbe es den ganzen Krempel hier nicht)
            *         und daher will ich nicht nochmal den SAML_ART überprüfen (der kann ja abgelaufen sein weil der user erst nach stunden
            *         auf den zurück-button klickt)
            */
          queryString.append(key);
          queryString.append("=");
		  		//queryString.append(key.equals(TheApp.SAML_ART) ? Util.encode(values[i]) : values[i]);
		  		// Alles encoden
		  	 queryString.append(Util.encode(values[i]));
          if (i < (values.length - 1)) {
            queryString.append("&");
          }
        }
      }
      isNext = it.hasNext();
      if (isNext && !doNotAddParamaeter) {
        queryString.append("&");
      }
    }
    return queryString.toString();
  }


  /**
   *  Liest idcur und req_bez aus dem request und setze diese dem Manager. Achtung:
   *  idCur und req_schluessel sind default Integer, d.h. man braucht nicht ableiten
   *  und zB. nach String casten.
   *
   *@param  request
   *@exception  Exception
   */
  protected synchronized void setManagerValues(HttpServletRequest request)
    throws Exception {
    manager.setBezCur(request.getParameter("req_bez"));
    if (manager.isNeu()) {
      if (manager.editSchluessel()) {
        manager.setKey(new Integer(Integer.parseInt(request.getParameter("req_schluessel"))));
      }
    }

    String tmpIdCur = request.getParameter("idCur");
    if (tmpIdCur == null || tmpIdCur.equals("")) {
      manager.setNeu(true);
    }
    else {
      try {
        manager.setIdCur(new Integer(request.getParameter("idCur")));
      }
      catch (NumberFormatException ex) {
        manager.setIdCur(tmpIdCur);
      }
    }
  }


  protected abstract void setManager();


 
  /**
   *  Neuanlage von Daten in der JSP.
   *
   *@param  request
   *@exception  Exception  Wenn Neuer Datensatz bereits vorhanden.
   */
  protected void neu(HttpServletRequest request)
    throws Exception {
    //kein aktualisiere
    manager.setNeu(true);

    manager.setBezCur(TheApp.NAME_NEU);
    manager.setIdCur(new Integer(0));
  }


  /**
   *  Aktualisieren der JSP.
   *
   *@param  request
   *@exception  Exception
   */
  protected synchronized void aktualisiere(HttpServletRequest request)
    throws Exception {
    manager.setNeu(false);
    setManagerValues(request);
    manager.readList(new Aspect(Repository.QUICK));
    if (manager.getIdCur() == null) {
      manager.setFirst();
    }
    manager.setBezCur(
      manager.idBezis.getKeys(0).get(manager.idBezis.indexOfValue(0, manager.getIdCur())).toString());
  }


  /**
   *  Speichern der Daten aus der JSP.
   *
   *@param  request
   *@exception  Exception  Wenn Speichern fehl schlägt.
   */
  protected synchronized void speichere(HttpServletRequest request)
    throws Exception {
    if (manager.getIdCur() != null) {
      try {
        //alle Daten aus request lesen
        setManagerValues(request);
        //manager updated jetzt db  /** @todo qs; eigentlich update! */
        if (manager.isNeu()) {
          manager.insert(null);
        }
        else {
          manager.update(null);
        }
        //den aktuellen (idCur) einstellen
        manager.setIdCur(manager.getKey());
        //jetzt liste frisch einlesen
        /**
         *@todo    orn: warum wird nach dem Update ein readList aufgerufen ?
         */
        manager.readList(new Aspect(Repository.QUICK));
        if (manager.isNeu()) {
          manager.setNeu(false);
        }
      }
      catch (RepositoryException re) {
        if (re.getCode() == RepositoryException.NO_RECORD_CHANGED) {
          //frisch reinlesen: jemand hat vor uns die daten geändert :-(
          aktualisiere(request);
        }
        throw re;
      }
    }
    else {
      throw new InformationOnlyException(client.getLocalStringForLabel("Hinweis.Neu.Eintrag", "com.poi.fux.frame.LabelsBundle"), jspNext);
    }
  }


  /**
   *  Reiterwechsel.
   *
   *@param  request
   *@exception  Exception
   */
  protected void reiten(HttpServletRequest request)
    throws Exception { }


  /**
   *  Description of the Method
   *
   *@param  request        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void detail(HttpServletRequest request)
    throws Exception { }


  /**
   *  Description of the Method
   *
   *@param  request        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void sortiere(HttpServletRequest request)
    throws Exception { }


  /**
   *  Description of the Method
   *
   *@param  request        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void weiter(HttpServletRequest request)
    throws Exception { }


  /**
   *  specialCommand.
   *
   *@param  request
   *@param  response
   *@exception  Exception
   */
  protected void specialCommand(HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception { }



  /**
   *  Initialisierung beim ersten Aufruf.
   *
   *@param  request
   *@exception  Exception
   */
  protected synchronized void init(HttpServletRequest request)
    throws Exception {
    manager.init();
    //manager.readList(new Aspect(Repository.QUICK));
    manager.setNeu(false);
    ///** @todo orn ???? */
    manager.setIdCur(null);
  }


  /**
   *  Duplizieren des aktullen Datensatzes.
   *
   *@param  request
   *@exception  Exception
   */
  protected void dupliziere(HttpServletRequest request)
    throws Exception { }


  /**
   *  Behandle den Itemdownclick, zeig die naechste Itemebene an.
   *
   *@param  request        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void itemDown(HttpServletRequest request)
    throws Exception { }


  /**
   *  Behandle den Tabledownclick vulgo zeig die Kastl an.
   *
   *@param  request        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void tableDown(HttpServletRequest request)
    throws Exception { }



  /**
   *  Lösche den aktuellen Datensatz.
   *
   *@param  request
   *@exception  Exception
   */
  protected synchronized void loesche(HttpServletRequest request)
    throws Exception {
    if (manager.getIdCur() != null) {
      manager.delete();
      manager.setIdCur(null);
      manager.readList(new Aspect(Repository.QUICK));
      manager.setFirst();
      manager.setNeu(false);
    }
  }

}
