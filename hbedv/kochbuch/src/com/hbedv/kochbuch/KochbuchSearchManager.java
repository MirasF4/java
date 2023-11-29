/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.kochbuch.KochbuchBean;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.Aspect;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("unchecked")
public class KochbuchSearchManager extends KochbuchManager {

    /**
     * @param clientNew
     */
    public KochbuchSearchManager(ClientKochbuch clientNew) {
        super(clientNew);
        // TODO Auto-generated constructor stub
    }

    private String suchName = null;
    private String suchZutat = null;
    private Integer suchMenueId = null;
    private String suchBeschreibung = null;
    private String suchKommentar = null;
    private AliceSortMap asmSuchListe = null;
  
    /**
     * @return Returns the asmSuchListe.
     */
    public AliceSortMap getAsmSuchListe() {
        if (asmSuchListe == null) asmSuchListe = KochbuchBean.AsmSuchListe.getEmptyASM();
        return asmSuchListe;
    }
    /**
     * @param asmSuchListe The asmSuchListe to set.
     */
    public void setAsmSuchListe(AliceSortMap asmSuchListe) {
        this.asmSuchListe = asmSuchListe;
    }
    
    public void setSuchName (String s) {
        suchName = s;
    }
    
    public void setSuchZutat (String s) {
        suchZutat = s;
    }
    
    public void setSuchBeschreibung (String s) {
        suchBeschreibung = s;
    }

    public void setSuchKommentar (String s) {
        suchKommentar = s;
    }
    
    public void setSuchMenueId (Integer i) {
        suchMenueId = i;
    }
    
    public String getSuchName () {
        if (suchName == null) suchName = "";
        return suchName;
    }
    
    public String getSuchZutat () {
        if (suchZutat == null) suchZutat = "";
        return suchZutat;
    }
    
    public String getSuchBeschreibung () {
        if (suchBeschreibung == null) suchBeschreibung = "";
        return suchBeschreibung;
    }
    
    public String getSuchKommentar () {
        if (suchKommentar == null) suchKommentar = "";
        return suchKommentar;
    }
    
    public Integer getSuchMenueId () {
        if (suchMenueId == null) suchMenueId = new Integer(0);
        return suchMenueId;
    }

	public String getLogonErrMsg() {
	    return "Fehler bei der Anmeldung! Benutzer oder Paßwort ungültig.";
	}
    
	public void readAsmSuchListe()
	throws SQLException {
	    boolean mitZutaten = false;
	    AliceSortMap asm = this.getAsmMenueListe();
	    ConnectionWrapper connection = getDB().getConnection();
	    KochbuchBean kb = new KochbuchBean();
	    try {
	        Integer min = new Integer(1);
	        Integer max = new Integer(999999);
	        if (this.getSuchMenueId().intValue() > 0) {
	            min = this.getSuchMenueId();
	            max = this.getSuchMenueId();
	        }
	        ArrayList values = new ArrayList();
	        if (!this.getSuchZutat().equals("%%") && !this.getSuchZutat().equals("")) {
	            mitZutaten = true;
	            values.add(this.getSuchZutat());
	        }
	        values.add(min);
	        values.add(max);
	        values.add(this.getSuchName());
	        values.add(this.getSuchBeschreibung());
	        values.add(this.getSuchKommentar());
	        
	        asm = kb.readSuchListe (connection,values,mitZutaten);
        }
        finally {
            connection.close();
        }
        this.setAsmSuchListe(asm);
	    
	}
	
	public void checkLogin(String user, String pw)
	throws SQLException {
	    ConnectionWrapper connection = getDB().getConnection();
	    KochbuchBean kb = new KochbuchBean();
	    try {
	        boolean userOk = kb.checkLogin(connection,user,pw);
	        if (!userOk) {
	            ((ClientKochbuch) client).setAngemeldet(false);
	            ((ClientKochbuch) client).setLogonError(true);
	        }
	        else {
	            ((ClientKochbuch) client).setAngemeldet(true);
	            ((ClientKochbuch) client).setUserName(user);
	        }
	    }
        finally {
            connection.close();
        }
	}
    /* (non-Javadoc)
     * @see com.hbedv.frame.Manager#existsValues(com.hbedv.db.ConnectionWrapper, java.lang.Object, com.hbedv.frame.Aspect)
     */
    public boolean existsValues(ConnectionWrapper connection, Object bez, Aspect aspects) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
