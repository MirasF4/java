/*
 * Created on 05.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
	Last change: PIG 27.11.2007 16:33:56
 */
package com.hbedv.db.lj_results;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class LjResultsBean extends Repository {
    
    
    public LjResultsBean () {};
   
    /* (non-Javadoc)
     * @see com.hbedv.db.Repository#read(com.hbedv.db.ConnectionWrapper, com.hbedv.frame.Aspect)
     */
    public void read(ConnectionWrapper connection, Aspect aspects) 
    throws SQLException {
        // TODO Auto-generated method stub
        
    }


    @SuppressWarnings("unchecked")
	public ArrayList<Double> readCountryResult(ConnectionWrapper connection, ArrayList<String> laender)
    throws SQLException {
    	
    	Double dZero = new Double(0);
    	ArrayList<Double> liste = new ArrayList<Double>();
    	String select =
    	    "select lc.bez as Land, count(rd.answer_txt ) as Anzahl " + 
    	    "from results r, result_details rd, laendercodes lc " +
    	    "where r.id = rd.result_id " +
    	    "and rd.answer_txt = lc.code " +
    	    "and rd.question_id = 26 " +
    	    "and r.remotehost not like '%192.168.%' " +
    	    "and r.remotehost <> '0.0.0.0' " +
    	    "and r.remotehost <> '193.109.74.31' " + 
    	    "and r.remotehost <> '193.109.74.32' " +
    	    "group by lc.bez " +
    	    "order by lc.bez ";
    	
    	double summe = 0;
    	PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                while (rs.next()) {
                	double zahl = (Double) Util.nvl(super.getDouble(rs, "Anzahl"), dZero);
                	String land = super.getString(rs,"Land");
                	summe = summe + zahl;
                	liste.add(zahl);
                	laender.add(land);
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
    	 
    	double divSumme = 100.0f/summe;
        int size = liste.size();
        for (int index=0;index<size;index++) {
        	double wert = liste.get(index);
        	wert = wert * divSumme;
        	liste.set(index, wert);
        }
    	return liste;
    }
    
    
    /* Altersstatistik*/
    @SuppressWarnings("unchecked")
	public ArrayList<Double> readAgeResult(ConnectionWrapper connection)
    throws SQLException {
    	
    	Double dZero = new Double(0);
    	ArrayList<Double> liste = new ArrayList<Double>();
    	String select =
    	    "select	sum(Age_10_to_19) as Sum_Age_10_to_19, " +
    		"		sum(Age_20_to_29) as Sum_Age_20_to_29, " +
    		"		sum(Age_30_to_39) as Sum_Age_30_to_39, " +
    		"		sum(Age_40_to_49) as Sum_Age_40_to_49, " +
    		"		sum(Age_50_to_59) as Sum_Age_50_to_59, " +
    		"		sum(Age_60_to_69) as Sum_Age_60_to_69, " +
    		"		sum(Age_70_to_79) as Sum_Age_70_to_79, " +
    		"		sum(Age_80_to_89) as Sum_Age_80_to_89, " +
    		"		sum(Age_90_to_99) as Sum_Age_90_to_99 " +
    		"from view_age ";
    	PreparedStatement ps = connection.prepareStatement(select);
        try {
            ResultSet rs = this.read(ps, null);
            try {
                if (rs.next()) {
                	double a10 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_10_to_19"), dZero);
                	double a20 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_20_to_29"), dZero);
                	double a30 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_30_to_39"), dZero);
                	double a40 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_40_to_49"), dZero);
                	double a50 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_50_to_59"), dZero);
                	double a60 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_60_to_69"), dZero);
                	double a70 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_70_to_79"), dZero);
                	double a80 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_80_to_89"), dZero);
                	double a90 = (Double) Util.nvl(super.getDouble(rs, "Sum_Age_90_to_99"), dZero);
                	
                	double summe = a10 + a20 + a30 + a40 + a50 + a60 + a70 + a80 + a90; 
                	double divSumme = 100.0f/summe;
                	
                	a10 = divSumme * a10;
                	a20 = divSumme * a20;
                	a30 = divSumme * a30;
                	a40 = divSumme * a40;
                	a50 = divSumme * a50;
                	a60 = divSumme * a60;
                	a70 = divSumme * a70;
                	a80 = divSumme * a80;
                	a90 = divSumme * a90;
                	
                	liste.add(a10);
                	liste.add(a20);
                	liste.add(a30);
                	liste.add(a40);
                	liste.add(a50);
                	liste.add(a60);
                	liste.add(a70);
                	liste.add(a80);
                	liste.add(a90);
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
    
    
    @SuppressWarnings("unchecked")
	public ArrayList<Double> readProzResult(ConnectionWrapper connection, Integer questId)
    throws SQLException {
    
    	Double dZero = new Double(0);
    	ArrayList<Double> liste = new ArrayList<Double>();
    	String select =
    		"select  rd.answer_int as f1,0 as f2,0 as f3,0 as f4,0 as f5,0 as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 1 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,rd.answer_int as f2,0 as f3,0 as f4,0 as f5,0 as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 2 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,rd.answer_int as f3,0 as f4,0 as f5,0 as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 3 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,0 as f3,rd.answer_int as f4,0 as f5,0 as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 4 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,0 as f3,0 as f4,rd.answer_int as f5,0 as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 5 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,0 as f3,0 as f4,0 as f5,rd.answer_int as f6,0 as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 6 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,0 as f3,0 as f4,0 as f5,0 as f6,rd.answer_int as f7,0 as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 7 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' " +
    		"union all " +
    		"select  0 as f1,0 as f2,0 as f3,0 as f4,0 as f5,0 as f6,0 as f7,rd.answer_int as f8 " +
    		"from    results r, result_details rd " +
    		"where   r.id = rd.result_id " +
    		"and     rd.possibilities_number = 8 " +
    		"and     rd.question_id = ? " +
    		"and     r.remotehost not like '%192.168.%' " +
    		"and     r.remotehost <> '0.0.0.0' " +
    		"and     r.remotehost <> '193.109.74.31' " +
    		"and     r.remotehost <> '193.109.74.32' ";

    	ArrayList values = new ArrayList();
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	values.add(questId);
    	PreparedStatement ps = connection.prepareStatement(select);

    	double f1_summe = 0;
    	double f2_summe = 0;
    	double f3_summe = 0;
    	double f4_summe = 0;
    	double f5_summe = 0;
    	double f6_summe = 0;
    	double f7_summe = 0;
    	double f8_summe = 0;

    	try {
            ResultSet rs = this.read(ps, values);
            try {
                while (rs.next()) {
                	double f1 = (Double) Util.nvl(super.getDouble(rs, "f1"), dZero);
                	double f2 = (Double) Util.nvl(super.getDouble(rs, "f2"), dZero);
                	double f3 = (Double) Util.nvl(super.getDouble(rs, "f3"), dZero);
                	double f4 = (Double) Util.nvl(super.getDouble(rs, "f4"), dZero);
                	double f5 = (Double) Util.nvl(super.getDouble(rs, "f5"), dZero);
                	double f6 = (Double) Util.nvl(super.getDouble(rs, "f6"), dZero);
                	double f7 = (Double) Util.nvl(super.getDouble(rs, "f7"), dZero);
                	double f8 = (Double) Util.nvl(super.getDouble(rs, "f8"), dZero);
                	
                	f1_summe = f1_summe + f1;
                	f2_summe = f2_summe + f2;
                	f3_summe = f3_summe + f3;
                	f4_summe = f4_summe + f4;
                	f5_summe = f5_summe + f5;
                	f6_summe = f6_summe + f6;
                	f7_summe = f7_summe + f7;
                	f8_summe = f8_summe + f8;
                }
            }
            finally {
                rs.close();
            }
        }
        finally {
            ps.close();
        }
        double summe = f1_summe + f2_summe + f3_summe + f4_summe + f5_summe + f6_summe + f7_summe + f8_summe; 
        double divSumme = 100.0f/summe;

        f1_summe = divSumme * f1_summe;
    	f2_summe = divSumme * f2_summe;
    	f3_summe = divSumme * f3_summe;
    	f4_summe = divSumme * f4_summe;
    	f5_summe = divSumme * f5_summe;
    	f6_summe = divSumme * f6_summe;
    	f7_summe = divSumme * f7_summe;
    	f8_summe = divSumme * f8_summe;
    	
    	liste.add(f1_summe);
    	liste.add(f2_summe);
    	liste.add(f3_summe);
    	liste.add(f4_summe);
    	liste.add(f5_summe);
    	liste.add(f6_summe);
    	liste.add(f7_summe);
    	liste.add(f8_summe);
        
    	return liste;
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

