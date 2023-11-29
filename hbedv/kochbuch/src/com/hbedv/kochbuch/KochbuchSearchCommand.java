/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbedv.db.kochbuch.KochbuchBean;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortMapContainer;
import com.hbedv.frame.TheApp;
import com.hbedv.frame.Util;



/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("unchecked")
public class KochbuchSearchCommand extends KochbuchCommand {

    /**
     * @param newNext
     */
    public KochbuchSearchCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }

  
    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchSearchManager();
		((ClientKochbuch) client).setKochbuchSearchManagerAsManagerNeu();
	}

	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		//KochbuchSearchManager pM = (KochbuchSearchManager) manager;
		String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("search.jsp");
		super.setJspNext(jsp);
	}
	

	
	
	 protected synchronized void setManagerValues(HttpServletRequest request)
	 throws Exception {
	     super.setManagerValues(request);
	     KochbuchSearchManager pM = (KochbuchSearchManager) manager;
	     Integer menId = Util.getIntegerFromStr(request.getParameter("men_id"));
	     
	     String rezeptname = ((String) Util.nvl(request.getParameter("rezeptname"),"")).trim();
	     String zutat = ((String) Util.nvl(request.getParameter("zutat"),"")).trim();
	     String beschreibung = ((String) Util.nvl(request.getParameter("beschreibung"),"")).trim();
	     String kommentar = ((String) Util.nvl(request.getParameter("kommentar"),"")).trim();
	 	     
	     pM.setSuchMenueId(menId);
	     pM.setSuchName(rezeptname);
	     pM.setSuchZutat(zutat);
	     pM.setSuchBeschreibung(beschreibung);
	     pM.setSuchKommentar(kommentar);
	}

		
	private boolean setRezeptManager(KochbuchManager manager, String subcmd, String command, String jspName, int menue, int m_id, Integer r_id ) 
	throws Exception {
	    boolean found = false;
	    ClientKochbuch cl = ((ClientKochbuch) client);
	    if (m_id == menue) {
	        cl.setCurManager(manager);
	        manager.setCmd(command);
	        manager.init();
	        manager.readRezeptList(m_id);
	    	ArrayList list = manager.getAsmRezeptListe().getKeys(KochbuchBean.AsmRezept.KEY_ID);
	    	int row = list.indexOf(r_id);
	        if (row > -1) {
	            manager.setAsmRow(row);
	            manager.readRezept(row);
	            found = true;

	            String jsp = "";
		        if (subcmd.equals(Kochbuch.SUB_CMD_AUSWAHL)) {
		            jsp = cl.getUriJSPKochbuch(jspName);
		        }
		        else if (cl.isAngemeldet()){
		            if (subcmd.equals(Kochbuch.SUB_CMD_DELETE)) {
		                jsp = cl.getUriJSPKochbuch("delete.jsp");
		            }
		            else if (subcmd.equals(Kochbuch.SUB_CMD_EDIT)) {
		                jsp = cl.getUriJSPKochbuch("edit.jsp");
		            }
		        }
				super.setJspNext(jsp);
	        }
	    }
	    return found;
	}
	
	
	private void save(HttpServletRequest request,HttpServletResponse response) 
	throws SQLException,Exception {
		ClientKochbuch cl = ((ClientKochbuch) client);
		KochbuchSearchManager eM = (KochbuchSearchManager) manager;
		
	    Integer r_id = Util.getIntegerFromStr(request.getParameter("r_id"));
	    Integer menId = Util.getIntegerFromStr(request.getParameter("m_id"));
	    Integer lastMenId = Util.getIntegerFromStr(request.getParameter("lastMenId"));
	    String rezeptName = request.getParameter("rezeptname");
	    String kommentar = request.getParameter("kommentar");
	    String zubereitung = request.getParameter("zubereitung");
	    
	    String command = null;
	    KochbuchManager manager = null;
	    if (menId.intValue() == KochbuchBean.MENUE_VORSPEISEN) {
	        manager = cl.getKochbuchVorspeisenManager();
	        command = Kochbuch.CMD_VORSPEISEN;
	    }
	    else if (menId.intValue() == KochbuchBean.MENUE_HAUPTSPEISEN) {
	        manager = cl.getKochbuchHauptspeisenManager();
	        command = Kochbuch.CMD_HAUPTSPEISEN;
	    }
	    else if (menId.intValue() == KochbuchBean.MENUE_DESERTS) {
	        manager = cl.getKochbuchDesertManager();
	        command = Kochbuch.CMD_DESERTS;
	    }
	    else if (menId.intValue() == KochbuchBean.MENUE_SALATE) {
	        manager = cl.getKochbuchSalateManager();
	        command = Kochbuch.CMD_SALATE;
	    }
	    else if (menId.intValue() == KochbuchBean.MENUE_BACKWAREN) {
	        manager = cl.getKochbuchBackwarenManager();
	        command = Kochbuch.CMD_BACKWAREN;
	    }
	    else if (menId.intValue() == KochbuchBean.MENUE_KEKSE) {
	        manager = cl.getKochbuchKekseManager();
	        command = Kochbuch.CMD_KEKSE;
	    }
	    else {
	        throw new NullPointerException("manager == null");
	    }
        manager.setCmd(command);
        manager.init();
        manager.readRezeptList(lastMenId.intValue());
        int row = manager.findRow(r_id);
        if (row < 0) {
        	//Neuer Datensatz
        	AliceSortMap asm = manager.getAsmRezeptListe();
        	AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
        	asm.add(asmc);
        	row = asm.getSize() - 1;
        	manager.setAsmRezeptListe(asm);
        }
        manager.setAsmRow(row);
	    manager.setRezId(r_id);
	    manager.setMenId(menId);
	    manager.setRezeptName(rezeptName);
	    manager.setKommentar(kommentar);
	    manager.setZubereitung(zubereitung);
	    AliceSortMap asm = KochbuchBean.AsmZutaten.getEmptyASM();
	    int zz = 0;
	    for (int index=0;index<100;index++) {
	        String indStr = new Integer(index).toString();
	        String feldAnzahl = "anzahl_" + indStr;  
	        String feldEinheit = "einheit_" + indStr;
	        String feldZutaten = "zutaten_" + indStr;
	        
	        String anz = (String) Util.nvl(request.getParameter(feldAnzahl),"");
	        String einheit = (String) Util.nvl(request.getParameter(feldEinheit),"");
	        String zutat = (String) Util.nvl(request.getParameter(feldZutaten),"");
	        
	        if (!anz.equals("") || !einheit.equals("") || !zutat.equals("")) {
	            AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
	            zz++;
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_ID,r_id);
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_POS,new Integer(zz));
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_SORT,new Integer(zz));
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_ANZAHL,anz);
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_EINHEIT,einheit);
	            asmc.setKey(KochbuchBean.AsmZutaten.KEY_BEZ,zutat);
	            asm.add(asmc);
	        }
	    }
	    manager.setZutaten(asm);
	    try {
	    	String errStr = "";
	    	ArrayList ret = manager.writeRezept();
	    	if (ret.size() > 0) {
	    		errStr = (String) ret.get(1);
	    		rezeptName = (String) ret.get(0); 
	    	}
	    	cl.setMessage(errStr);
	    	manager.readRezeptList(menId.intValue());
	    	row = manager.findRow(menId,rezeptName);
	    
	    	eM.readAsmSuchListe();
	    	
	    	if (row > -1) {
	    		manager.setAsmRow(row);

	    		r_id = (Integer) manager.getAsmRezeptListe().getKeys(KochbuchBean.AsmRezept.KEY_ID).get(row);
	    		menId = (Integer) manager.getAsmRezeptListe().getKeys(KochbuchBean.AsmRezept.KEY_MEN_ID).get(row);

	    		cl.setLoadCommand(TheApp.CMD_SEARCH);
	    		cl.setLoadSubCommand(Kochbuch.SUB_CMD_EDIT);
	    		cl.setLoadRezId(r_id);
	    		cl.setLoadMenId(menId);
	   		    
	    		String jsp = cl.getUriJSPKochbuch("load.jsp");
	    		super.setJspNext(jsp);
	    	}
	    	else {
	    		String jsp = cl.getUriJSPKochbuch("search.jsp");
	    		super.setJspNext(jsp);
	    	}
	    }
        catch (SQLException e) {
        	//throw new InformationOnlyException("Fehler beim Speichern","errorpage.jsp");
    		e.printStackTrace();
    		cl.setSqlErr(e);
    		cl.setMessage(e.getSQLState() + "<br>" + e.getMessage());
    		String jsp = "message.jsp";
    		super.setJspNext(jsp);
		} 
		
	}

	private void viewOrEdit(HttpServletRequest request,HttpServletResponse response,String subcmd) 
	throws SQLException,Exception {

		ClientKochbuch cl = ((ClientKochbuch) client);
		int m_id = (Util.getIntegerFromStr(request.getParameter("m_id"))).intValue();
	    Integer r_id = Util.getIntegerFromStr(request.getParameter("r_id"));
	    if (m_id == 0 && cl.isAngemeldet()) {
            String jsp = cl.getUriJSPKochbuch("insert.jsp");
            super.setJspNext(jsp);
	    }
	    else {
	        boolean found = 	setRezeptManager(	cl.getKochbuchVorspeisenManager(), subcmd, Kochbuch.CMD_VORSPEISEN, 
	                			"vorspeisen.jsp", KochbuchBean.MENUE_VORSPEISEN, m_id, r_id );
	    
	        if (!found) found = setRezeptManager(	cl.getKochbuchHauptspeisenManager(), subcmd, Kochbuch.CMD_HAUPTSPEISEN, 
	                			"hauptspeisen.jsp", KochbuchBean.MENUE_HAUPTSPEISEN, m_id, r_id );

	        if (!found) found = setRezeptManager(	cl.getKochbuchDesertManager(), subcmd, Kochbuch.CMD_DESERTS, 
								"desert.jsp", KochbuchBean.MENUE_DESERTS, m_id, r_id );
	    
	        if (!found) found = setRezeptManager(	cl.getKochbuchSalateManager(), subcmd, Kochbuch.CMD_SALATE, 
								"salate.jsp", KochbuchBean.MENUE_SALATE, m_id, r_id );

	        if (!found) found = setRezeptManager(	cl.getKochbuchBackwarenManager(), subcmd, Kochbuch.CMD_BACKWAREN, 
	            				"backwaren.jsp", KochbuchBean.MENUE_BACKWAREN, m_id, r_id );
	    
	        if (!found) found = setRezeptManager(	cl.getKochbuchKekseManager(), subcmd, Kochbuch.CMD_KEKSE, 
    							"kekse.jsp", KochbuchBean.MENUE_KEKSE, m_id, r_id );
	 
	        if (!found) {
	            String jsp = cl.getUriJSPKochbuch("search.jsp");
	            super.setJspNext(jsp);
	        }
	    }
	
	}
	
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws SQLException,Exception { 
	    super.specialCommand(request,response);
	    KochbuchSearchManager eM = (KochbuchSearchManager) manager;
		String subcmd = request.getParameter("subcmd");
		ClientKochbuch cl = ((ClientKochbuch) client);
		if (subcmd.equals(Kochbuch.SUB_CMD_SUCHEN)) {
		    setManagerValues(request);
		    eM.readAsmSuchListe();
		    String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		}
		else if (	subcmd.equals(Kochbuch.SUB_CMD_AUSWAHL) || subcmd.equals(Kochbuch.SUB_CMD_EDIT) || 
		        	subcmd.equals(Kochbuch.SUB_CMD_INSERT)) {
		    this.viewOrEdit(request,response,subcmd);
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_DELETE)) {
		    Integer r_id = Util.getIntegerFromStr(request.getParameter("r_id"));
		    eM.deleteRezept(r_id);
		    
			String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		    eM.readAsmSuchListe();
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_DELETE_PIC)) {
			Integer r_id = Util.getIntegerFromStr(request.getParameter("r_id"));
    		Integer menId = Util.getIntegerFromStr(request.getParameter("m_id"));

			String tmpFile = "pic_" + r_id.toString() + ".jpg";
			String abstrPath = cl.getAppRootDir() + "images/data/" + tmpFile;
			File f = new File(abstrPath);
			if (f.isFile()) {
				boolean deleteOk = f.delete();
				if (!deleteOk) {
					throw new SQLException("Fehler beim Löschen von " + tmpFile);
				}
			}
    		cl.setLoadCommand(TheApp.CMD_SEARCH);
    		cl.setLoadSubCommand(Kochbuch.SUB_CMD_EDIT);
    		cl.setLoadRezId(r_id);
    		cl.setLoadMenId(menId);
   		    
    		String jsp = cl.getUriJSPKochbuch("load.jsp");
    		super.setJspNext(jsp);
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_LOGINUSER)) {
		    String user = (String) Util.nvl(request.getParameter("user"),"");
		    String pw = (String) Util.nvl(request.getParameter("pw"),"");
		    eM.checkLogin(user,pw);
			String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_LOGOUTUSER)) {
		    cl.setAngemeldet(false);
		    cl.setUserName("");
		    cl.setLogonError(false);
			String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_SAVE)) {
			this.save(request,response);
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_UPLOAD)) {
		    String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		}
		else {
			String jsp = cl.getUriJSPKochbuch("search.jsp");
			super.setJspNext(jsp);
		}
	}

}
