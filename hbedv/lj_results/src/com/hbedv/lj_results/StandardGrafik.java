/**********************************************************************
*
* $Id: StandardGrafik.java,v 1.5 2007/09/27 06:27:49 krb Exp $
*
* Copyright (c) 2004 Porsche Informatik, GmbH. All Rights Reserved.
*
**********************************************************************/
package com.hbedv.lj_results;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.hbedv.db.lj_results.LjResultsBean;
import com.hbedv.frame.util.DateAndTime;


/**********************************************************************
*
* SF Startseite
*
* @version $Revision: 1.5 $
* @author  Bettina Kronreif
*
**********************************************************************/

public class StandardGrafik
{
	
	private static LjResultsManager manager = null;
	
	public synchronized void process(/*HttpServletResponse res,*/ Integer question, LjResultsManager man)
	throws IOException, SQLException
	{
		setManager(man);
		String fileName = man.getPicFile(question,true);
		File file = new File(fileName);
		if (!file.exists()) {

			ArrayList<Double> liste = man.readProzResult(question);
			
			CategoryDataset dataset = createDataset(liste,question);	
			JFreeChart chart = createChart(dataset,question);
			
			//OutputStream os = res.getOutputStream();
			try {	
				ChartRenderingInfo info = new ChartRenderingInfo (new StandardEntityCollection());
				//ChartUtilities.writeChartAsPNG (os, chart, 940, 500, info);
				ChartUtilities.saveChartAsJPEG(file, chart, 940, 500, info);
			
			}
			catch (IOException e) {	

			}
		}
	}


		
	public void init() 
	{
		
	}

	
	
	private static CategoryDataset createDataset(ArrayList<Double> liste, Integer question) 
	{         
		
		String[] series = new String[8];

		Integer count = (Integer) getManager().getAsmSurvey().getKeys(LjResultsBean.AsmSurvey.KEY_POSSIBILITIS_COUNT).get(question-1);
		
		ArrayList<String> possibilities = getManager().getPossibilitisList(question);
		
		for (int index=0;index<count;index++){
			series[index] = (String) possibilities.get(index);
		}
		
		String category = "";
		    		
   		//Dataset erzeugen
   		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   		for (int index=0;index<count;index++){
   			dataset.addValue(liste.get(index), series[index], category);
   		}
		
		return dataset;
   
	}


	private static JFreeChart createChart(CategoryDataset dataset, Integer question) 
	{
	
		String zeitStempel = DateAndTime.getZeitStempelSek();

		// create the chart...
		JFreeChart chart = ChartFactory.createBarChart(
			question + ". " + manager.getQuestionName(question),         //Überschrift
			"created at " + zeitStempel + " (GMT+01:00)",               //Beschriftung x-Achse
			"Percent",               //Beschriftung y-Achse
			dataset,                  // data
			PlotOrientation.VERTICAL, // orientation
			true,                     // include legend
			true,                     // tooltips?
			false                     // URLs?
		);
	
		
		//Hintergrundfarbe
		chart.setBackgroundPaint(Color.white);
	
		//Formatierung der Grafik
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.black);
		plot.setDomainGridlinesVisible(false);
		plot.setRangeGridlinePaint(Color.black);
		plot.setOutlinePaint(Color.black);

		
		// disable bar outlines...
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		
		GradientPaint gp0 = new GradientPaint(
			0.0f, 0.0f, new Color(98, 139, 196),
			0.0f, 0.0f, new Color(70, 94, 128)
		);
		renderer.setSeriesPaint(0, gp0);
		
		GradientPaint gp1 = new GradientPaint(
			0.0f, 0.0f, new Color(182, 185, 190), 
			0.0f, 0.0f, new Color(128, 133, 143)
		);
		renderer.setSeriesPaint(1, gp1);
		
		GradientPaint gp2 = new GradientPaint(
			0.0f, 0.0f, new Color(50, 195, 105), 
			0.0f, 0.0f, new Color(13, 146, 63)
		);
		renderer.setSeriesPaint(2, gp2);
		

		GradientPaint gp3 = new GradientPaint(
			0.0f, 0.0f, new Color(244, 88, 99), 
			0.0f, 0.0f, new Color(190, 36, 47)
		);
		renderer.setSeriesPaint(3, gp3);
		
		GradientPaint gp4 = new GradientPaint(
			0.0f, 0.0f, new Color(247, 245, 86), 
			0.0f, 0.0f, new Color(224, 222, 12)
		);
		renderer.setSeriesPaint(4, gp4);

		return chart;
	}

	public static LjResultsManager getManager() {
		return manager;
	}

	public static void setManager(LjResultsManager man) {
		manager = man;
	}



}
