/**********************************************************************
*
* $Id: StandardGrafik.java,v 1.5 2007/09/27 06:27:49 krb Exp $
*
* Copyright (c) 2004 Porsche Informatik, GmbH. All Rights Reserved.
*
**********************************************************************/
package com.hbedv.lj_results;

import java.util.TimerTask;


public class LjTask extends TimerTask {

	
	public void run() { 
		// nix mehr tun !!
		/*
		LjResultsManager manager = new LjResultsManager();
		try {
			AliceSortMap asmS = manager.readNewSurvey();
			manager.setAsmSurvey(asmS);

			AliceSortMap asmL = manager.readLaenderCode();
			manager.setAsmLaenderCode(asmL);
		}
		catch (Exception e) {
			// nix tun!!!
		}
		for(int index=1;index<27;index++) {
			try {
				if (index < 25) {
					manager.generateFile(index, "STANDARD",true);
				}
				else if (index==25) {
					manager.generateFile(index, "AGE",true);
				}
				else if (index==26) {
					manager.generateFile(index, "COUNTRY",true);
				}
			}
			catch (SQLException e) {
				// nix tun
			}
			catch (IOException e) {
				// nix tun
			}
		}
		*/
	}
	
	
}
