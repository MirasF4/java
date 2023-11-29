/*
 * Created on 05.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.db.kochbuch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.Repository;
import com.hbedv.db.RepositoryException;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortMapContainer;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.Util;
import com.hbedv.frame.util.DateAndTime;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class KochbuchBean extends Repository {
    
    public final static int MENUE_VORSPEISEN	= 1;
    public final static int MENUE_HAUPTSPEISEN	= 2;
    public final static int MENUE_DESERTS		= 3;
    public final static int MENUE_SALATE		= 4;
    public final static int MENUE_BACKWAREN		= 5;
    public final static int MENUE_KEKSE			= 6;
    
    public KochbuchBean () {};
   
    /* (non-Javadoc)
     * @see com.hbedv.db.Repository#read(com.hbedv.db.ConnectionWrapper, com.hbedv.frame.Aspect)
     */
    public void read(ConnectionWrapper connection, Aspect aspects) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.hbedv.db.Repository#fillMe(java.sql.ResultSet, com.hbedv.frame.Aspect)
     */
    protected void fillMe(ResultSet rs, Aspect aspects) throws SQLException {
        // TODO Auto-generated method stub
        
    }
    
    @SuppressWarnings("unchecked")
    public AliceSortMap readZutaten(ConnectionWrapper connection, Integer r_id)
    throws SQLException {
        
        if (connection == null) {
            throw new NullPointerException("connection==null");
        }
        
        final String sqlSelect =
            "SELECT r_id, pos, anzahl, einheit, bez, sort " + 
            "FROM	z_zutaten " +
            "WHERE	r_id = ? " +
			"ORDER BY sort ASC ";

        
        AliceSortMap asm = AsmZutaten.getEmptyASM();
        ArrayList values = new ArrayList();
        values.add(r_id);
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, values);
            try {
                while (rs.next()) {
                    Integer id = super.getInteger(rs,"r_id");
                    Integer pos = super.getInteger(rs,"pos");
                    String anzahl = ((String) Util.nvl(super.getString(rs,"anzahl"),"")).trim();
                    String einheit = ((String) Util.nvl(super.getString(rs,"einheit"),"")).trim();
                    String bez = ((String) Util.nvl(super.getString(rs,"bez"),"")).trim();
                    
                    Integer sort = super.getInteger(rs,"sort");
                                        
                    AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmZutaten.KEY_ID,id);
                    asmc.setKey(AsmZutaten.KEY_POS,pos);
                    asmc.setKey(AsmZutaten.KEY_ANZAHL,anzahl);
                    asmc.setKey(AsmZutaten.KEY_EINHEIT,einheit);
                    asmc.setKey(AsmZutaten.KEY_BEZ,bez);
                    asmc.setKey(AsmZutaten.KEY_SORT,sort);
                    asm.add(asmc);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        return asm;
    }

    public Integer maxRezeptId(ConnectionWrapper connection)
    throws SQLException {
        
        Integer maxId = null;
        
        if (connection == null) {
            throw new NullPointerException("connection==null");
        }
        
        final String sqlSelect =
            "SELECT max(id) as maxid " + 
            "FROM	r_rezepte ";

        
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                if (rs.next()) {
                    maxId = (Integer) Util.nvl(super.getInteger(rs,"maxid"),new Integer(0));
                    int tmp = maxId.intValue();
                    tmp++;
                    maxId = new Integer(tmp);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        return maxId;
    }
    
    @SuppressWarnings("unchecked")
    public void deleteRezept(ConnectionWrapper connection, Integer r_id)
    throws SQLException {

        if (connection == null) {
            throw new NullPointerException("connection==null");
        }

    	String sqlDeleteRezept = 
    		"DELETE FROM r_rezepte WHERE id = ? ";
    	
    	String sqlDeleteZutaten =
    		"DELETE FROM z_zutaten WHERE r_id = ? ";

        ArrayList values = new ArrayList();
        values.add(r_id);

        try {
        	super.delete(connection, sqlDeleteZutaten, values);
        }
        catch (SQLException e) {
        	throw e;
        }
        
        try {
        	super.delete(connection, sqlDeleteRezept, values);
        }
        catch (SQLException e) {
        	throw e;
        }
    }
    

    private String makeStrLg (String s, int strLg) {
    	if (s == null) s = "";
		s = s.trim();
		int lg = s.length();
		if (lg > 0) {
			if (lg > strLg) lg = strLg;
			s = s.substring(0,lg);
		}
		return s;
    }
    
    @SuppressWarnings("unchecked")
    public void writeLog(ConnectionWrapper connection, AliceSortMap asm)
    throws SQLException {

        if (connection == null) {
            throw new NullPointerException("connection==null");
        }
    	
    	String sqlInsert = 	"INSERT " +
    						"INTO		kl_kochbuchlog ( " +
							"			zeitstempel,localUrl,localport,remoteaddr,remoteHost,remoteport," +
							"			sessionid,requesturi,requesturl,servername,cmd,subcmd,username ) " +
							"VALUES  ( 	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
		
    	Timestamp jetzt = new Timestamp(System.currentTimeMillis());
    	ArrayList values = new ArrayList();
    	
    	values.add(jetzt.toString());
    	
    	
		String localUrl		= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_LOCAL_ADDR).get(0),20);
		Integer localPort	= (Integer) asm.getKeys(KochbuchBean.AsmLog.KEY_LOCAL_PORT).get(0);
		String remoteAddr	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_REMOTE_ADDR).get(0),20);
		String remoteHost	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_REMOTE_HOST).get(0),20);
		Integer remotePort	= (Integer) asm.getKeys(KochbuchBean.AsmLog.KEY_REMOTE_PORT).get(0);
		String sessionId	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_SESSION_ID).get(0),40);
		String requestURI	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_REQUEST_URI).get(0),60);
		String requestUrl	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_REQUEST_URL).get(0),60);
		String servername	= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_SERVERNAME).get(0),60);
		String cmd			= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_CMD).get(0),60);
		String subcmd		= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_SUBCMD).get(0),60);
		String user			= makeStrLg ((String) asm.getKeys(KochbuchBean.AsmLog.KEY_USER).get(0),20);
    	
		values.add(localUrl);
		values.add(localPort);
		values.add(remoteAddr);
		values.add(remoteHost);
		values.add(remotePort);
		values.add(sessionId);
		values.add(requestURI);
		values.add(requestUrl);
		values.add(servername);
		values.add(cmd);
		values.add(subcmd);
		values.add(user);

		try {
    		super.insert(connection, sqlInsert, values);	
    	}
    	catch (SQLException e) {
    		//Nix tun nur LOG
		}
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList writeRezept(ConnectionWrapper connection, AliceSortMapContainer asmc)
    throws SQLException {

    	ArrayList result = new ArrayList();
    	
        if (connection == null) {
            throw new NullPointerException("connection==null");
        }

        if (asmc == null) {
            throw new NullPointerException("asmc==null");
        }

        String sqlInsertRezept = 
            "INSERT INTO r_rezepte (id,men_id,zubereitung,kommentar,bez) VALUES  (?,?,?,?,?) ";

        String sqlUpdateRezept = 
            "UPDATE r_rezepte " +
            "SET	men_id		= ?, " +
            "		zubereitung = ?, " +
            "		kommentar	= ?, " +
            "		bez			= ? " +
            "WHERE	id			= ? ";
            
        
        String insertZutat =
            "INSERT INTO z_zutaten (r_id,pos,anzahl,einheit,bez,sort) VALUES (?,?,?,?,?,?) ";
        
        String deleteZutaten =
            "DELETE FROM z_zutaten WHERE r_id = ? ";
        
        Integer id = (Integer) Util.nvl(asmc.getKey(AsmRezept.KEY_ID),new Integer(0));
        Integer menId = (Integer) asmc.getKey(AsmRezept.KEY_MEN_ID);
        String  rezBez = (String) asmc.getKey(AsmRezept.KEY_BEZ);
        String  rezZub = (String) asmc.getValue(AsmRezept.VALUE_ZUBEREITUNG);
        int lg = rezZub.length();

				
        if (lg > 0) {
        	if (lg > 2048) {
        		lg = 2048;
        		String msg = "Im Feld Zubereitung sind maximal 2048 Zeichen erlaubt. Daten wurden nach 2048 Zeichen abgeschnitten.";
        		result.add(rezBez);
        		result.add(msg);
        	}
        	rezZub = rezZub.substring(0,lg);
        }
        String	rezKom = (String) asmc.getValue(AsmRezept.VALUE_KOMMENTAR);
        lg = rezKom.length();
        if (lg > 0) {
        	if (lg > 256) {
        		lg = 256;
        		String msg = "Im Feld Kommentar sind maximal 256 Zeichen erlaubt. Daten wurden nach 256 Zeichen abgeschnitten.";
        		result.add(rezBez);
        		result.add(msg);
        	}
        	rezKom = rezKom.substring(0,lg);
        }
        
        AliceSortMap zutaten = (AliceSortMap) asmc.getValue(AsmRezept.VALUE_ZUTATEN);
        
        boolean insert = false;
        ArrayList values = new ArrayList();
        try {
            if (id.intValue() == 0) {
                //Insert
            	insert = true;
                id = maxRezeptId(connection);
                asmc.setKey(AsmRezept.KEY_ID,id);
                
                values.add(id);
                values.add(menId);
                values.add(rezZub);
                values.add(rezKom);
                values.add(rezBez);
                super.insert(connection, sqlInsertRezept, values);
            }
            else {
                //Update
            	insert = false;
                values.add(menId);
                values.add(rezZub);
                values.add(rezKom);
                values.add(rezBez);
                values.add(id);
                super.update(connection, sqlUpdateRezept, values);
            }
        }
        catch (SQLException e) {
        	int errcode = e.getErrorCode();
            if (errcode == -196) {
            	try {
            		rezBez = rezBez + "_" + DateAndTime.formatTimeHHmmss(new Timestamp(System.currentTimeMillis()));
            		String msg = "Rezeptname muß eindeutig sein, daher wurde der Rezeptname automatisch verändert!";
            		result.add(rezBez);
            		result.add(msg);
            		lg = rezBez.length();
            		if (lg > 30) lg = 30;
            		rezBez = rezBez.substring(0,lg);
            		if (insert) {
            			values.set(4,rezBez);
                    	super.insert(connection, sqlInsertRezept, values);
                    }
                    else {
                    	values.set(3,rezBez);
                    	super.update(connection, sqlUpdateRezept, values);
                    }
            	}
            	catch (SQLException e3) {
            		throw e3;
            	}
            }
            else {
            	throw e;
            }
        }

        try {
            values.clear();
            values.add(id);
            super.delete(connection,deleteZutaten,values);
        }
        catch (SQLException e2) {
            int errcode = e2.getErrorCode(); 
            if ( errcode == RepositoryException.NO_RECORD_CHANGED ) {
                // Nix tun wenn nix gefunden
            }
            else {
                throw e2;
            }
        }

        for (int index = 0;index < zutaten.getSize();index++) {
            String anzahl = (String) Util.nvl(zutaten.getKeys(AsmZutaten.KEY_ANZAHL).get(index),"");
            String einheit = (String) Util.nvl(zutaten.getKeys(AsmZutaten.KEY_EINHEIT).get(index),"");
            String bez = (String) Util.nvl(zutaten.getKeys(AsmZutaten.KEY_BEZ).get(index),"");
            Integer pos = new Integer(index);
            Integer sort = new Integer(index);
            // "INSERT INTO z_zutaten (r_id,pos,anzahl,einheit,bez,sort) VALUES (?,?,?,?,?,?) ";
            values.clear();
            values.add(id);
            values.add(pos);
            values.add(anzahl);
            values.add(einheit);
            values.add(bez);
            values.add(sort);
            try {
            	super.insert(connection, insertZutat, values);
            }
            catch (SQLException e) {
            	throw e;
            }
        }

        return result;
    }
    
    @SuppressWarnings("unchecked")
    public void readRezept(ConnectionWrapper connection, int row, AliceSortMap asm)
    throws SQLException {

        if (connection == null) {
            throw new NullPointerException("connection==null");
        }

        if (asm == null) {
            throw new NullPointerException("asm==null");
        }

        if (row < 0 || row >= asm.getSize()) {
            throw new SQLException("row < 0 or row > asm.getsize()");
        }
        
        final String sqlSelect =
            "SELECT zubereitung, kommentar, m.bez as menuebez " + 
            "FROM	r_rezepte r, mn_menue m " +
            "WHERE	r.men_id = m.id " +
            "AND	r.id = ? ";
        
        Integer id = (Integer) asm.getKeys(AsmRezept.KEY_ID).get(row);
        ArrayList values = new ArrayList();
        values.add(id);
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, values);
            try {
                if (rs.next()) {
                    String zubereitung = ((String) Util.nvl(super.getString(rs,"zubereitung"),"")).trim();
                    String kommentar = ((String) Util.nvl(super.getString(rs,"kommentar"),"")).trim();
                    String menBez = ((String) Util.nvl(super.getString(rs,"menuebez"),"")).trim();
                    
                    asm.setKey(row,AsmRezept.KEY_MENUE_BEZ,menBez);
                    
                    asm.setValue(row,AsmRezept.VALUE_ZUBEREITUNG,zubereitung);
                    asm.setValue(row,AsmRezept.VALUE_KOMMENTAR,kommentar);
                    
                    String pictureName = "pic_" + id.toString() + ".jpg";
                    asm.setKey(row,AsmRezept.KEY_PICTURE_NAME,pictureName);
                    
                    AliceSortMap asmZutaten = readZutaten(connection, id);
                    asm.setValue(row,AsmRezept.VALUE_ZUTATEN,asmZutaten);
                    
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public AliceSortMap readRezeptList (ConnectionWrapper connection, Integer men_id) 
    throws SQLException {
        
        if (connection == null) {
            throw new NullPointerException("connection==null");
        }
        
        final String sqlSelect = 
            "SELECT id, bez " + 
            "FROM	r_rezepte " + 
            "WHERE	men_id = ? " +
            "ORDER BY bez ASC ";
        
        AliceSortMap asm = AsmRezept.getEmptyASM();
        ArrayList values = new ArrayList();
        values.add(men_id);
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, values);
            try {
                while (rs.next()) {
                    Integer id = super.getInteger(rs,"id");
                    String bez = ((String) Util.nvl(super.getString(rs,"bez"),"")).trim();
                    AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmRezept.KEY_MEN_ID,men_id);
                    asmc.setKey(AsmRezept.KEY_ID,id);
                    asmc.setKey(AsmRezept.KEY_BEZ,bez);
                    asm.add(asmc);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        return asm;
    }


    @SuppressWarnings("unchecked")
    public AliceSortMap readSuchListe (ConnectionWrapper connection, ArrayList values, boolean mitZutaten)
    throws SQLException {
        
        for (int index=0;index<values.size();index++) {
            if (values.get(index) instanceof String) {
                String tmp = (String) values.get(index);
                if (tmp == null) tmp = "";
                tmp = "%" + tmp.trim() + "%";
                values.set(index,tmp);
            }
        }
        
        AliceSortMap asm = AsmSuchListe.getEmptyASM();
        
        final String sqlSelect1 =
            "SELECT DISTINCT r.id as r_id, r.men_id as m_id, m.bez as m_bez, r.bez as r_bez, m.sort " +
            "FROM	mn_menue m, r_rezepte r " +
            "WHERE	r.men_id		= m.id " +
            "AND	r.men_id 		BETWEEN ? AND ? " +
            "AND	r.bez 			LIKE ? " +
            "AND	r.zubereitung	LIKE ? " +
            "AND	r.kommentar		LIKE ? " +
            "ORDER BY m.sort ASC, r.bez ASC ";

        final String sqlSelect2 =
            "SELECT DISTINCT r.id as r_id, r.men_id as m_id, m.bez as m_bez, r.bez as r_bez, m.sort " +
            "FROM	mn_menue m, r_rezepte r, z_zutaten z " +
            "WHERE	r.men_id		= m.id " +
            "AND	r.id 			= z.r_id " +
            "AND 	z.bez 			LIKE ? " +
            "AND	r.men_id 		BETWEEN ? AND ? " +
            "AND	r.bez 			LIKE ? " +
            "AND	r.zubereitung	LIKE ? " +
            "AND	r.kommentar		LIKE ? " +
            "ORDER BY m.sort ASC, r.bez ASC ";
        

        String sqlSelect = sqlSelect1;
        if (mitZutaten) {
            sqlSelect = sqlSelect2;
        }
        
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, values);
            try {
                while (rs.next()) {
                    Integer r_id = super.getInteger(rs,"r_id");
                    Integer m_id = super.getInteger(rs,"m_id");
                    String m_bez = super.getString(rs,"m_bez");
                    String r_bez = super.getString(rs,"r_bez");
                    
                    AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmSuchListe.KEY_REZ_ID,r_id);
                    asmc.setKey(AsmSuchListe.KEY_MEN_ID,m_id);
                    asmc.setKey(AsmSuchListe.KEY_MEN_BEZ,m_bez);
                    asmc.setKey(AsmSuchListe.KEY_REZ_BEZ,r_bez);
                    asm.add(asmc);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        return asm;
    }
    
    public AliceSortMap readMenues (ConnectionWrapper connection)
    throws SQLException {
        
        if (connection == null) {
            throw new NullPointerException("connection==null");
        }
        
        final String sqlSelect = 
            "SELECT	id, bez,command, sort, pic " +
            "FROM	mn_menue " +
            "WHERE	sort IS NOT NULL " +
            "AND	sort > 0 " +
            "ORDER BY sort ASC";
        
        AliceSortMap menue = AsmMenue.getEmptyASM();
        
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                while (rs.next()) {
                    Integer id = super.getInteger(rs,"id");
                    String bez = super.getString(rs,"bez");
                    String command = super.getString(rs,"command");
                    Integer sort = super.getInteger(rs,"sort");
                    String pic = super.getString(rs,"pic");
                    if (pic == null) pic = "";
                    AliceSortMapContainer asmc = menue.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmMenue.KEY_ID,id);
                    asmc.setKey(AsmMenue.KEY_BEZ,bez);
                    asmc.setKey(AsmMenue.KEY_COMMAND,command);
                    asmc.setKey(AsmMenue.KEY_SORT,sort);
                    asmc.setKey(AsmMenue.KEY_PIC,pic);
                    menue.add(asmc);
               }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        
        return menue;
    }
  
    @SuppressWarnings("unchecked")
    public boolean checkLogin(ConnectionWrapper connection, String user, String pw)
    throws SQLException {
        boolean result = false;
        final String sqlSelect =
            "SELECT	count(*) AS anz " +
            "FROM	u_user " +
            "WHERE	username = ? " +
            "AND	pw = ? ";
        ArrayList values = new ArrayList();
        values.add(user);
        values.add(pw);
        PreparedStatement ps = connection.prepareStatement(sqlSelect);
        try {
            ResultSet rs = this.read(ps, values);
            try {
                if (rs.next()) {
                    Integer anz = super.getInteger(rs,"anz");
                    result = (anz.intValue() == 1);
               }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        return result;
    }
    
    
    public static class AsmMenue {
        public final static int KEY_ID 			= 0;
        public final static int KEY_BEZ 		= 1;
        public final static int KEY_COMMAND 	= 2;
        public final static int KEY_SORT 		= 3;
        public final static int KEY_PIC 		= 4;
        
        public AsmMenue() { }
        
        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(5, 0);
        }
    }

    public static class AsmRezept {
        public final static int KEY_ID 				= 0;
        public final static int KEY_MEN_ID			= 1;
        public final static int KEY_BEZ				= 2;
        public final static int KEY_PICTURE_NAME	= 3;
        public final static int KEY_MENUE_BEZ		= 4;
        
        
        public final static int VALUE_ZUBEREITUNG	= 0;
        public final static int VALUE_KOMMENTAR		= 1;
        public final static int VALUE_ZUTATEN		= 2;
        
        public AsmRezept() { }

        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(5, 3);
        }
    }
        
    public static class AsmSuchListe {
        public final static int KEY_MEN_ID			= 0;
        public final static int KEY_MEN_BEZ 		= 1;
        public final static int KEY_REZ_ID			= 2;
        public final static int KEY_REZ_BEZ			= 3;
        
        public AsmSuchListe() { }

        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(4, 0);
        }
    }
    
    public static class AsmZutaten {
        public final static int KEY_ID 				= 0;
        public final static int KEY_POS 			= 1;
        public final static int KEY_ANZAHL 			= 2;
        public final static int KEY_EINHEIT			= 3;
        public final static int KEY_BEZ 			= 4;
        public final static int KEY_SORT 			= 5;
        
        public AsmZutaten() { }

        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(6, 0);
        }
    }

    public static class AsmLog {

        public final static int KEY_ID 				= 0;
        public final static int KEY_LOCAL_ADDR		= 1;
        public final static int KEY_LOCAL_PORT		= 2;
        public final static int KEY_REMOTE_ADDR		= 3;
        public final static int KEY_REMOTE_HOST		= 4;
        public final static int KEY_REMOTE_PORT		= 5;
        public final static int KEY_SESSION_ID		= 6;
        public final static int KEY_REQUEST_URI		= 7;
        public final static int KEY_REQUEST_URL		= 8;
        public final static int KEY_SERVERNAME		= 9;
        public final static int KEY_CMD				= 10;
        public final static int KEY_SUBCMD			= 11;
        public final static int KEY_USER			= 12;
        
    	public AsmLog() { }

        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(13, 0);
        }
    }
    
}

