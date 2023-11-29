/*
 * Created on 05.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.db.livejournal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.Repository;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortMapContainer;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.Util;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class LiveJournalBean extends Repository {
    
    
    public LiveJournalBean () {};
   
    /* (non-Javadoc)
     * @see com.hbedv.db.Repository#read(com.hbedv.db.ConnectionWrapper, com.hbedv.frame.Aspect)
     */
    public void read(ConnectionWrapper connection, Aspect aspects) 
    throws SQLException {
        // TODO Auto-generated method stub
        
    }

    
    public Integer readCountResults(ConnectionWrapper connection)
    throws SQLException {
    	Integer anz = 0;
    	String select = 
	    	"select count(*) as anz " + 
		    "from results  " +
		    "where remotehost not like '%192.168.%' " +
		    "and remotehost <> '0.0.0.0' " +
		    "and remotehost <> '193.109.74.31' " + 
		    "and remotehost <> '193.109.74.32' ";
        PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                if (rs.next()) {
                	anz = super.getInteger(rs,"anz");
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
    	return anz;
    }
    

    public AliceSortMap readLaenderCode(ConnectionWrapper connection)
    throws SQLException {
    	AliceSortMap asm = AsmLaenderCode.getEmptyASM();
    	String select = 
    		"SELECT	code, bez " +
    		"FROM laendercodes " +
    		"ORDER BY bez ASC ";

        PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                while (rs.next()) {
                	String code = super.getString(rs,"code");
                	String bez = super.getString(rs,"bez");

                	AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmLaenderCode.KEY_CODE,code);
                    asmc.setKey(AsmLaenderCode.KEY_BEZ,bez);
                    
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

    public ArrayList<String> readPossibilitis(ConnectionWrapper connection, Integer question)
    throws SQLException {
    	ArrayList<String> liste = new ArrayList<String>(); 
    	String select = 
    		"select name " + 
    		"from possibilitis " +
    		"where question_id = " + question + ' ' +
    		"order by number asc ";
        PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                while (rs.next()) {
                	String name = (String) super.getString(rs,"name");
                    liste.add(name);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
    	return liste;
    }
    
    public String getMaxId (ConnectionWrapper connection)
    throws SQLException {
    	String result = "";
    	String select = "SELECT IsNull(max(id),0,max(id)) + 1 as maxid FROM results";
        PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                if (rs.next()) {
                	Integer maxId = super.getInteger(rs,"maxid");
                	result = maxId.toString();
                }
            }
            catch (SQLException e) {
            	result = e.getLocalizedMessage();
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
    
    @SuppressWarnings("unchecked")
	public String saveData(ConnectionWrapper connection, AliceSortMap asmResult, AliceSortMap asmQuestions)
    throws SQLException {
    	String errStr = ""; 
    	String tmp = getMaxId (connection);
    	Integer maxId = Util.getIntegerFromStr(tmp);
    	boolean ok = (maxId.intValue() > 0);
    	if (!ok) {
    		errStr = tmp;
    	}
    	else {
        	String sqlInsert = 	
        		"INSERT " +
        		"INTO		results ( " +
        		"			id,localUrl,localport,remoteaddr,remoteHost,remoteport," +
        		"			sessionid,requesturi,requesturl,servername,zeitstempel ) " +
        		"VALUES  ( 	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    		
    		String localUrl		= (String) asmResult.getKeys(AsmSaveResult.KEY_LOCAL_URL).get(0);
    		Integer localPort	= (Integer) asmResult.getKeys(AsmSaveResult.KEY_LOCAL_PORT).get(0);
    		String remoteAddr	= (String) asmResult.getKeys(AsmSaveResult.KEY_REMOTE_ADDR).get(0);
    		String remoteHost	= (String) asmResult.getKeys(AsmSaveResult.KEY_REMOTE_HOST).get(0);
    		Integer remotePort	= (Integer) asmResult.getKeys(AsmSaveResult.KEY_REMOTE_PORT).get(0);
    		String sessionId	= (String) asmResult.getKeys(AsmSaveResult.KEY_SESSION_ID).get(0);
    		String requestURI	= (String) asmResult.getKeys(AsmSaveResult.KEY_REQUEST_URI).get(0);
    		String requestUrl	= (String) asmResult.getKeys(AsmSaveResult.KEY_REQUEST_URL).get(0);
    		String servername	= (String) asmResult.getKeys(AsmSaveResult.KEY_SERVERNAME).get(0);
        	Timestamp jetzt = new Timestamp(System.currentTimeMillis());
        	String zeitstempel = jetzt.toString();
    		
        	ArrayList values = new ArrayList();
    		values.add(maxId);
    		values.add(localUrl);
    		values.add(localPort);
    		values.add(remoteAddr);
    		values.add(remoteHost);
    		values.add(remotePort);
    		values.add(sessionId);
    		values.add(requestURI);
    		values.add(requestUrl);
    		values.add(servername);
    		values.add(zeitstempel);
    		try {
        		super.insert(connection, sqlInsert, values);	
        	}
        	catch (SQLException e) {
        		ok = false;
        		errStr = e.getLocalizedMessage();
        		connection.rollback();
    		}
        	if (ok) {
        		//Detail !!!
        		sqlInsert = 
        			"INSERT INTO " +
        			"result_details (result_id,question_id,possibilities_number,answer_txt,answer_int) " +
        			"values (?,?,?,?,?) ";
        		Integer count = asmQuestions.getSize();
        		int questions=0;
        		while (questions<count && ok) {
        			ArrayList numberList = (ArrayList) asmQuestions.getValues(AsmSurvey.VALUE_ANSWER_LIST_INT).get(questions); 
        			ArrayList strList = (ArrayList) asmQuestions.getValues(AsmSurvey.VALUE_ANSWER_LIST_TXT).get(questions);
        			Integer anz = (Integer) asmQuestions.getKeys(AsmSurvey.KEY_POSSIBILITIS_COUNT).get(questions);
        			Integer questionId = (Integer) asmQuestions.getKeys(AsmSurvey.KEY_ID).get(questions);
        			int possibilities=0;
        			while (possibilities<anz && ok) {
        				Integer wert = (Integer) numberList.get(possibilities);
        				String str = ((String) Util.nvl((String) strList.get(possibilities),"")).trim();
        				ArrayList values2 = new ArrayList();
        				values2.add(maxId);
        				values2.add(questionId);
        				values2.add(possibilities+1);
        				values2.add(str);
        				values2.add(wert);
        	    		try {
        	        		super.insert(connection, sqlInsert, values2);	
        	        	}
        	        	catch (SQLException e) {
        	        		ok = false;
        	        		errStr = e.getLocalizedMessage();
        	        		connection.rollback();
        	    		}
        				possibilities++;
        			}
        			questions++;
        		}
        	}
    	}
    	return errStr;
    }
    
    public AliceSortMap readNewSurvey(ConnectionWrapper connection)
    throws SQLException {
    
    	AliceSortMap asm = AsmSurvey.getEmptyASM();
    	
    	String select = "SELECT	id,is_number,section,possibilitis_count,quest_typ,name " +
    					"FROM	questions " +
    					"ORDER BY id ASC ";
        PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                while (rs.next()) {
                	Integer id = super.getInteger(rs,"id");
                	String is_number = ((String) Util.nvl(super.getString(rs,"is_number"),"J")).trim();
                	String quest_typ = ((String) Util.nvl(super.getString(rs,"quest_typ"),"R")).trim();
                	String name = (String) super.getString(rs,"name");
                    Integer section = super.getInteger(rs,"section");
                    Integer possibilitis_count = super.getInteger(rs,"possibilitis_count");
                                        
                    AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
                    asmc.setKey(AsmSurvey.KEY_ID,id);
                    asmc.setKey(AsmSurvey.KEY_IS_NUMBER,is_number);
                    asmc.setKey(AsmSurvey.KEY_POSSIBILITIS_COUNT,possibilitis_count);
                    asmc.setKey(AsmSurvey.KEY_SECTION,section);
                    asmc.setKey(AsmSurvey.KEY_QUEST_TYP,quest_typ);
                    ArrayList<Integer> numberList = new ArrayList<Integer>();
                    ArrayList<String> txtList = new ArrayList<String>();
                    for (int i=0;i < possibilitis_count.intValue();i++) {
                    	numberList.add(null);
                    	txtList.add(null);
                    }
                    asmc.setValue(AsmSurvey.VALUE_ANSWER_LIST_INT, numberList);
                    asmc.setValue(AsmSurvey.VALUE_ANSWER_LIST_TXT, txtList);
                    asmc.setValue(AsmSurvey.VALUE_NAME, name);
                    ArrayList<String> possibilitisList = readPossibilitis(connection,id);
                    asmc.setValue(AsmSurvey.VALUE_POSSIBILITIS,possibilitisList);
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
    
    
    /* (non-Javadoc)
     * @see com.hbedv.db.Repository#fillMe(java.sql.ResultSet, com.hbedv.frame.Aspect)
     */
    protected void fillMe(ResultSet rs, Aspect aspects) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    public static class AsmLaenderCode {
    	public final static int KEY_CODE				= 0;
        public final static int KEY_BEZ					= 1;
    	
    	public AsmLaenderCode() { }
    	
        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(2, 0);
        }

    }
    
    public static class AsmSaveResult {
    	
    	public final static int KEY_SESSION_ID		= 0;
    	public final static int KEY_LOCAL_URL		= 1;
    	public final static int KEY_LOCAL_PORT		= 2;
    	public final static int KEY_REMOTE_ADDR		= 3;
    	public final static int KEY_REMOTE_HOST		= 4;
    	public final static int KEY_REMOTE_PORT		= 5;
    	public final static int KEY_REQUEST_URI		= 6;
    	public final static int KEY_REQUEST_URL		= 7;
    	public final static int KEY_SERVERNAME		= 8;
    	
    	public AsmSaveResult() { }
    	
        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(9, 0);
        }
    }
    
    public static class AsmSurvey {

    	public final static int KEY_ID 					= 0;
        public final static int KEY_IS_NUMBER			= 1;
        public final static int KEY_SECTION				= 2;
        public final static int KEY_POSSIBILITIS_COUNT	= 3;
        public final static int KEY_QUEST_TYP			= 4;

        public final static int VALUE_ANSWER_LIST_INT	= 0;
        public final static int VALUE_ANSWER_LIST_TXT	= 1;
        public final static int VALUE_NAME				= 2;
        public final static int VALUE_POSSIBILITIS		= 3;
        
        public AsmSurvey() { }

        public static AliceSortMap getEmptyASM() {
            return new AliceSortMap(5, 4);
        }
    }

        
}

