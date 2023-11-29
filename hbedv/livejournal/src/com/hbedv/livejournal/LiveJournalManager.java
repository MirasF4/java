/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.livejournal;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.DB;
import com.hbedv.db.livejournal.DBLiveJournal;
import com.hbedv.db.livejournal.LiveJournalBean;
import com.hbedv.db.livejournal.LiveJournalBean.AsmSurvey;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.BodyManager;
import com.hbedv.frame.Util;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LiveJournalManager extends BodyManager {

	private int page = 1;
	private AliceSortMap asmSurvey = null;
	private AliceSortMap asmLaenderCode = null;
	private String errorText = null;
	private int errorQuestion = 0;
	

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
	public LiveJournalManager(ClientLiveJournal newClient) {
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
	
    public Integer readCountResults()
    throws SQLException {
    	Integer result = 0;
        ConnectionWrapper connection = getDB().getConnection();
        LiveJournalBean lJ = new LiveJournalBean();
        try {
        	result = lJ.readCountResults(connection);
        }
        finally {
        	connection.close();
        }
    	return result;
    }

	public AliceSortMap readNewSurvey()
	throws SQLException {
		AliceSortMap asm = null;
        ConnectionWrapper connection = getDB().getConnection();
        LiveJournalBean lJ = new LiveJournalBean();
        try {
        	asm = lJ.readNewSurvey(connection);
        }
        finally {
        	connection.close();
        }
		return asm;
	}
	
	public String saveData(AliceSortMap asmResult, AliceSortMap asmQuestions) 
	throws SQLException {
        ConnectionWrapper connection = getDB().getConnection();
        LiveJournalBean lJ = new LiveJournalBean();
        String result = "";
        try {
        	result = lJ.saveData(connection,asmResult,asmQuestions);
        }
        finally {
        	connection.close();
        }
        
        return result;
	}

	public AliceSortMap readLaenderCode()
	throws SQLException {
		AliceSortMap asm = null;
        ConnectionWrapper connection = getDB().getConnection();
        LiveJournalBean lJ = new LiveJournalBean();
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
	public Integer getOptionKeyAge(int question) {
		AliceSortMap asm = getAsmSurvey();
		ArrayList list = (ArrayList) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_INT).get(question-1);
		Integer zahl = (Integer) list.get(0);
		if (zahl == null) zahl = new Integer(0);
		return zahl;
	}

	@SuppressWarnings("unchecked")
	public String getOptionKeyCountry(int question) {
		AliceSortMap asm = getAsmSurvey();
		ArrayList list = (ArrayList) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_TXT).get(question-1);
		String wert = (String) list.get(0);
		if (wert == null) wert = "";
		return wert;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPossibilitisList(int question) {
		AliceSortMap asm = getAsmSurvey();
		return (ArrayList<String>) asm.getValues(AsmSurvey.VALUE_POSSIBILITIS).get(question-1);
	}
	
	
	public String getAsmChecked (int question, int number) {
		String result = "";
		if (getAsmValueChecked (question, number)) {
			result = "checked=\"checked\"";
		}
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean getAsmValueChecked (int question, int number) {
		boolean checked = false;
		AliceSortMap asm = getAsmSurvey();
		ArrayList<Integer> numberList = (ArrayList<Integer>) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_INT).get(question-1);
		if (number <= numberList.size()) {
			Integer wert = numberList.get(number-1);
			checked = (wert != null && wert != 0); 
		}
		return checked;
	}

	public AliceSortMap getAsmLaenderCode() {
		return asmLaenderCode;
	}

	public void setAsmLaenderCode(AliceSortMap asmLaenderCode) {
		this.asmLaenderCode = asmLaenderCode;
	}

	@SuppressWarnings("unchecked")
	public Integer checkData() {
		Integer result = 0;
		AliceSortMap asm = getAsmSurvey();
		int anz = asm.getSize();
		int question = 0;
		boolean error = false;
		while (question<anz && !error) {
			ArrayList<Integer> numberList = (ArrayList<Integer>) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_INT).get(question);
			ArrayList<String> strList = (ArrayList<String>) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_TXT).get(question);
			String isNumber = ((String) Util.nvl((String) asm.getKeys(AsmSurvey.KEY_IS_NUMBER).get(question),"J")).trim();
			
			int size = numberList.size();
			int pos=0;
			boolean found = false;
			while (pos<size && !found) {
				if (!isNumber.equalsIgnoreCase("J")) {
					String wert = ((String) Util.nvl((String) strList.get(pos),"")).trim();
					found = (!wert.equals(""));
				}
				else {
					Integer wert = ((Integer) Util.nvl((Integer) numberList.get(pos),0));
					found = (wert.intValue() != 0);
				}
				pos++;
			}
			error = !found;
			question++;
			if (error) result = question; //das +1 ist richtig!!
		}
		return result;
	}
	
}
