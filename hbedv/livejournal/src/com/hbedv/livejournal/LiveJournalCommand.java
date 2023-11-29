/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.livejournal;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbedv.db.livejournal.LiveJournalBean;
import com.hbedv.db.livejournal.LiveJournalBean.AsmSaveResult;
import com.hbedv.db.livejournal.LiveJournalBean.AsmSurvey;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortMapContainer;
import com.hbedv.frame.BodyCommand;
import com.hbedv.frame.Util;



/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LiveJournalCommand extends BodyCommand {
	
	public LiveJournalCommand(String newNext) {
		super(newNext);
	}

	protected void setManager() {
		super.manager = ((ClientLiveJournal) client).getLiveJournalManager();
		((ClientLiveJournal) client).setLiveJournalManagerAsManagerNeu();
	}
	
	
	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		String subcmd = request.getParameter("subcmd");
		if (subcmd == null) subcmd = "";
		super.init(request);
		LiveJournalManager pM = (LiveJournalManager) manager;
		pM.setCmd(LiveJournal.CMD_PAGE);
		String jsp = "";
		if (subcmd.equals(LiveJournal.SUB_CMD_COUNT_RESULTS)) {
			jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("count_results.jsp");
		}
		else {
			jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("page1.jsp");
			pM.setPage(1);
		}
		super.setJspNext(jsp);
		
	}

	@SuppressWarnings("unchecked")
	protected void readJspPage(HttpServletRequest request) {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		LiveJournalManager eM = (LiveJournalManager) manager;
		int pg = eM.getPage();
		AliceSortMap asm = eM.getAsmSurvey();
		int size = asm.getSize();
		
		for (int index=1;index<=size;index++) {
			Integer section = (Integer) asm.getKeys(AsmSurvey.KEY_SECTION).get(index-1);
			if (section == pg) {
				String fieldName = (String) asm.getKeys(AsmSurvey.KEY_QUEST_TYP).get(index-1) + index;
				String[] wert = request.getParameterValues(fieldName);
				ArrayList<Integer> numberList = (ArrayList<Integer>) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_INT).get(index-1);
				ArrayList<String> strList = (ArrayList<String>) asm.getValues(AsmSurvey.VALUE_ANSWER_LIST_TXT).get(index-1);
				String isNumber = (String) asm.getKeys(AsmSurvey.KEY_IS_NUMBER).get(index-1);
				for (int i=0;i<numberList.size();i++) {
					numberList.set(i, zero);
					strList.set(i, "");
				}
				int lg = 0;
				if (wert != null) lg = wert.length;
				for (int i=0;i<lg;i++) {
					if (isNumber.equals("J")) {
						String inputTyp = (String) asm.getKeys(AsmSurvey.KEY_QUEST_TYP).get(index-1);
						if (inputTyp.equals("R")||inputTyp.equals("C")) {
							String tmp = ((String) Util.nvl(wert[i],"0")).trim();
							tmp = tmp.trim();
							if (tmp.equals("")) tmp = "0";
							Integer ind = Util.getIntegerFromStr(tmp); 
							numberList.set(ind-1, one);
						}
						else {
							String tmp = ((String) Util.nvl(wert[i],"0")).trim();
							tmp = tmp.trim();
							if (tmp.equals("")) tmp = "0";
							Integer zahl = Util.getIntegerFromStr(tmp);
							numberList.set(i,zahl);
						}
					}
					else {
						strList.set(i,wert[i]);
					}
				}
			}
		}
		eM.setAsmSurvey(asm);
	}
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		super.specialCommand(request,response);
	    LiveJournalManager eM = (LiveJournalManager) manager;
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(LiveJournal.SUB_CMD_BACK)) {
			readJspPage(request);
			int pg = eM.getPage();
			if (pg > 1) {
				eM.setPage(pg-1);
				String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("page" + eM.getPage() + ".jsp");
				super.setJspNext(jsp);
			}
		}
		else if (subcmd.equals(LiveJournal.SUB_CMD_NEXT)) {
			readJspPage(request);
			int pg = eM.getPage();
			if (pg < 3) {
				eM.setPage(pg+1);
				String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("page" + eM.getPage() + ".jsp");
				super.setJspNext(jsp);
			}
		}
		else if (subcmd.equals(LiveJournal.SUB_CMD_COUNT_RESULTS)) {
			String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("count_results.jsp");
			super.setJspNext(jsp);
		}
		else if (subcmd.equals(LiveJournal.SUB_CMD_SAVE)) {
			readJspPage(request);
			//Prüfen
			boolean ok = true;
			if (ok) {
				int question = eM.checkData();
				ok = (question == 0);
				if (! ok) {
					String txt = "Please answer question " + question + " before saving the questionnaire! ";
					eM.setErrorText(txt);
					eM.setErrorQuestion(question);
					
					AliceSortMap asm = eM.getAsmSurvey();
					Integer section = (Integer) asm.getKeys(AsmSurvey.KEY_SECTION).get(question-1);
					
					eM.setPage(section);
					String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("page" + section + ".jsp");
					super.setJspNext(jsp);
				}
			}
			
			//Speichern
			if (ok) {
				String localUrl = (String) Util.nvl(request.getLocalAddr(),"NULL");
				Integer localPort = new Integer(request.getLocalPort());
				String remoteAddr = (String) Util.nvl(request.getRemoteAddr(),"NULL");
				String remoteHost = (String) Util.nvl(request.getRemoteHost(),"NULL");
				Integer remotePort = new Integer(request.getRemotePort());
				String sessionId = (String) Util.nvl(request.getRequestedSessionId(),"NULL");
				String requestURI = (String) Util.nvl(request.getRequestURI(),"NULL");
				String requestUrl = (String) Util.nvl(request.getRequestURL().toString(),"NULL");
				String servername = (String) Util.nvl(request.getServerName(),"NULL");

				AliceSortMap asmResult = AsmSaveResult.getEmptyASM();
				AliceSortMapContainer asmc = asmResult.getEmptyAliceSortMapContainer(); 
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_LOCAL_URL,localUrl);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_LOCAL_PORT,localPort);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_REMOTE_ADDR,remoteAddr);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_REMOTE_HOST,remoteHost);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_REMOTE_PORT,remotePort);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_SESSION_ID,sessionId);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_REQUEST_URI,requestURI);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_REQUEST_URL,requestUrl);
				asmc.setKey(LiveJournalBean.AsmSaveResult.KEY_SERVERNAME,servername);
				asmResult.add(asmc);

				AliceSortMap asm = eM.getAsmSurvey();
				String fehler = eM.saveData(asmResult, asm);
				ok = (fehler.equals(""));
				if (!ok) {
					eM.setErrorText(fehler);
					eM.setErrorQuestion(24);
					eM.setPage(3);
					String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("page3.jsp");
					super.setJspNext(jsp);
				}
			}
			
			//Weiterleiten
			if (ok) {
				String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("load_fertig.jsp");
				super.setJspNext(jsp);
			}

		}

	}
	
	protected void navigate(HttpServletRequest request, String jsp) {
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(LiveJournal.SUB_CMD_NEXT) || subcmd.equals(LiveJournal.SUB_CMD_BACK) || 
			subcmd.equals(LiveJournal.SUB_CMD_FIRST) || subcmd.equals(LiveJournal.SUB_CMD_LAST)) {
			
	    	jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal(jsp);
	        super.setJspNext(jsp);

		}
	}

}
