/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
	Last change: PIG 27.11.2007 16:33:56
 */
package com.hbedv.lj_results;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.DB;
import com.hbedv.db.lj_results.DBLiveJournal;
import com.hbedv.db.lj_results.LjResultsBean;
import com.hbedv.db.lj_results.LjResultsBean.AsmSurvey;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.BodyManager;
import com.hbedv.frame.util.DateAndTime;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LjResultsManager extends BodyManager {
	
	private int page = 1;
	private AliceSortMap asmSurvey = null;
	private AliceSortMap asmLaenderCode = null;
	private String errorText = null;
	private int errorQuestion = 0;
	
	public LjResultsManager() {

	}


	@SuppressWarnings("unchecked")
	public String getIdObject(Integer errorQuestion) {
		String result = "";
		if (errorQuestion > 0) { 
			AliceSortMap asm = getAsmSurvey();
			String questTyp = (String) asm.getKeys(AsmSurvey.KEY_QUEST_TYP).get(errorQuestion-1);
			Integer size = (Integer) asm.getKeys(AsmSurvey.KEY_POSSIBILITIS_COUNT).get(errorQuestion-1);
			result = questTyp + errorQuestion.toString() + size.toString(); 
		}
		return result;
	}
	
    public String getErrorText() {
    	if (errorText == null) errorText = "";
    	String ret = errorText;
    	errorText = "";
		return ret;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public int getErrorQuestion() {
		int ret = errorQuestion;
		errorQuestion = 0;
		return ret;
	}

	public void setErrorQuestion(int errorQuestion) {
		this.errorQuestion = errorQuestion;
	}

	/**
	 * @param newClient
	 */
	public LjResultsManager(ClientLjResults newClient) {
		super(newClient);
	}
	
	public void init() 
	throws Exception {
		super.init();
		AliceSortMap asmS = readNewSurvey();
		setAsmSurvey(asmS);

		AliceSortMap asmL = readLaenderCode();
		setAsmLaenderCode(asmL);
	}


	public String getPicFile (Integer question, boolean appRoot) {
		String result = "";
		try {
		    DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		    String datum =  f.format(DateAndTime.now());
			
			String tmp = question.toString();
			if (tmp.length() == 1) tmp = "0" + tmp;

			String datei = 	"D:" + java.io.File.separator + "projects" + 
							java.io.File.separator + "java" + java.io.File.separator + "hbedv" + 
							java.io.File.separator + "lj_results" +  
							java.io.File.separator + "results" +
							java.io.File.separator + "gr_" + datum + "_" + tmp + ".jpg";

			if (appRoot) {
				result = datei; 
			}
			else {
				File file = new File(datei);
				if (!file.exists()) {
					java.sql.Date jetzt = DateAndTime.now();
					java.sql.Date gestern = DateAndTime.addDays(jetzt, -1);
					datum =  f.format(gestern);
				}
				//result = client.getAppRootUrl() + "/images/results/" + "gr_" + datum + "_" + tmp + ".jpg";
				result = "/lj_results/results/gr_" + datum + "_" + tmp + ".jpg";
			}
		}
		catch (Exception e) {
			result = "";
		}
		return result;
	}
	
	public synchronized void generateFile(Integer question) 
	throws IOException,SQLException {
		generateFile(question, "STANDARD");
	}

	public synchronized void generateFile(Integer question, String bildArt) 
	throws IOException,SQLException {
		generateFile(question, bildArt, false);
	}

	
	public synchronized void generateFile(Integer question, String bildArt, boolean generateNow) 
	throws IOException,SQLException {
		String fileName = getPicFile(question,true);
		File file = new File(fileName);
		if (!file.exists() || generateNow) {
			if (file.exists()) file.delete();
			if (bildArt.equals("STANDARD")) {
				StandardGrafik gr = new StandardGrafik();
				gr.process(question, this);
				//Thread thr = new Thread();
				
			}
			else if (bildArt.equals("AGE")) {
				AgeGrafik gr = new AgeGrafik();
				gr.process(question, this);
			}
			else if (bildArt.equals("COUNTRY")) {
				CountryGrafik gr = new CountryGrafik();
				gr.process(question, this);
			}
		}
	}

	
	public ArrayList<Double> readCountry(ArrayList<String> laender)
	throws SQLException {
		ArrayList<Double> liste = new ArrayList<Double>();
		ConnectionWrapper connection = getDB().getConnection();
        LjResultsBean lJ = new LjResultsBean();
        try {
        	liste = lJ.readCountryResult(connection, laender);
        }
        finally {
        	connection.close();
        }
		return liste;
	}

	
	
	public ArrayList<Double> readAge()
	throws SQLException {
		ArrayList<Double> liste = new ArrayList<Double>();
		ConnectionWrapper connection = getDB().getConnection();
        LjResultsBean lJ = new LjResultsBean();
        try {
        	liste = lJ.readAgeResult(connection);
        }
        finally {
        	connection.close();
        }
		return liste;
	}
	
	public ArrayList<Double> readProzResult(Integer questId) 
	throws SQLException {
	
		ArrayList<Double> liste = new ArrayList<Double>();
		ConnectionWrapper connection = getDB().getConnection();
        LjResultsBean lJ = new LjResultsBean();
        try {
        	liste = lJ.readProzResult(connection,questId);
        }
        finally {
        	connection.close();
        }
		return liste;

	}
	
	public AliceSortMap readNewSurvey()
	throws SQLException {
		AliceSortMap asm = null;
        ConnectionWrapper connection = getDB().getConnection();
        LjResultsBean lJ = new LjResultsBean();
        try {
        	asm = lJ.readNewSurvey(connection);
        }
        finally {
        	connection.close();
        }
		return asm;
	}
	

	public AliceSortMap readLaenderCode()
	throws SQLException {
		AliceSortMap asm = null;
        ConnectionWrapper connection = getDB().getConnection();
        LjResultsBean lJ = new LjResultsBean();
        try {
        	asm = lJ.readLaenderCode(connection);
        }
        finally {
        	connection.close();
        }
		return asm;
	}

	
	/* (non-Javadoc)
	 * @see com.hbedv.frame.Manager#getDB()
	 */
	public DB getDB() throws SQLException {
		// TODO Auto-generated method stub
	    return new DBLiveJournal();
	}

	/* (non-Javadoc)
	 * @see com.hbedv.frame.Manager#existsValues(com.hbedv.db.ConnectionWrapper, java.lang.Object, com.hbedv.frame.Aspect)
	 */
	public boolean existsValues(ConnectionWrapper connection, Object bez,Aspect aspects) 
	throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public AliceSortMap getAsmSurvey() {
		return asmSurvey;
	}

	public void setAsmSurvey(AliceSortMap asmSurvey) {
		this.asmSurvey = asmSurvey;
	}

	public String getQuestionTyp(int question) {
		AliceSortMap asm = getAsmSurvey();
		return (String) asm.getKeys(AsmSurvey.KEY_QUEST_TYP).get(question-1);
	}

	public String getQuestionName(int question) {
		AliceSortMap asm = getAsmSurvey();
		return (String) asm.getValues(AsmSurvey.VALUE_NAME).get(question-1);
	}

			
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPossibilitisList(int question) {
		AliceSortMap asm = getAsmSurvey();
		return (ArrayList<String>) asm.getValues(AsmSurvey.VALUE_POSSIBILITIS).get(question-1);
	}

	public AliceSortMap getAsmLaenderCode() {
		return asmLaenderCode;
	}

	public void setAsmLaenderCode(AliceSortMap asmLaenderCode) {
		this.asmLaenderCode = asmLaenderCode;
	}

	
}
