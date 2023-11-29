/*
 * Created on 27.10.2005
 * 
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.hbedv.kochbuch.ClientKochbuch;

/**
 * @author hubert
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class KbUpload {

	private String	sUploadDir	= "/images/data/";

	private String	sErrMsg	= "<h2>Fehler: Keine gültige Bilddatei (JPG)!</h2>";

	/**
	 *  
	 */
	public KbUpload() {
		super();
	}

	@SuppressWarnings("deprecation")
	public String readAndShowImage(HttpServletRequest request, ServletConfig servletConfig, ServletContext servletContext, ClientKochbuch client)
	throws FileNotFoundException, IOException {

		String sRet = "";
		// Check for valid parameter data:
		if (!request.getMethod().equals("POST")) return "";
		
		try {
			
		MultipartRequest parser = new ServletMultipartRequest(request, 1 * 1024 * 1024); // < 1
																																										 // MB

		if (null == parser) return "";

		// Check for valid image file:
		if (null == parser.getFileContents("myFile")) {
			return "";
		}

		String sFileName = parser.getFileSystemName("myFile");
		if (sFileName.trim().equals("")) {
			return "";
		}
		String picFileName = client.getUpLoadPic();
		if (picFileName == null) picFileName = "";
		if (!picFileName.equals("")) {
			sFileName = picFileName;
		}

		ImageInfo ii = new ImageInfo();
		if (null == ii) return "";
		ii.setInput(parser.getFileContents("myFile"));
		if (!ii.check()) return sErrMsg;

		// Note: Parameters are in the parser and not in request:

		String sImgFormat = ii.getFormatName().toLowerCase();
		// Show image data:
		if (null == sImgFormat) sImgFormat = "Unbekanntes Format";
		if (sImgFormat.equals("jpeg")) sImgFormat = "jpg";

		sRet = " " + ii.getWidth() + " x " + ii.getHeight() + " pixels, "
				+ ii.getBitsPerPixel() + " bpp, " + parser.getFileSize("myFile") + " Bytes<br>\n ";

		// Check if image format is suitable for inserting into HTML page:
		if (!sImgFormat.equals("jpg")) return sRet + sErrMsg;

		// Generate valid file name. Different operating systems or
		// browsers may return the file name with or without path
		// and the path may contain '/' (Unix) or '\' (Windows):
		if (null == sFileName || 0 >= sFileName.length()) sFileName = "MyFile";
		char c = sFileName.charAt(sFileName.length() - 1);
		if ('/' == c || '\\' == c) sFileName = sFileName.substring(0, sFileName.length() - 1);
		int i;
		if (0 <= (i = sFileName.lastIndexOf('/'))) sFileName = sFileName.substring(i + 1);
		if (0 <= (i = sFileName.lastIndexOf('\\'))) sFileName = sFileName.substring(i + 1);
		if (!sFileName.toLowerCase().endsWith("." + sImgFormat)) sFileName += "." + sImgFormat;

		// Different file pathes for HTML page and for storing:
		String sFilePathAndNameHtml = sUploadDir + sFileName;
		String sFilePathAndNameNoPic = sUploadDir + "nopic.jpg";
		String sFilePathAndNameStore = servletContext.getRealPath(sFilePathAndNameHtml);
		sFilePathAndNameHtml = client.getAppRootUrl() + sUploadDir + sFileName;
		// Store file:
		BufferedInputStream is = null;
		BufferedOutputStream os = null;
		long sum = 0;
		try {
			is = new BufferedInputStream(parser.getFileContents("myFile"));
			os = new BufferedOutputStream(new FileOutputStream(sFilePathAndNameStore));
			byte[] buff = new byte[8192];
			int len;
			while (0 < (len = is.read(buff))) {
				os.write(buff, 0, len);
				sum += len;
			}
		}
		finally {
			if (is != null) is.close();
			if (os != null) {
				os.flush();
				os.close();
			}
		}
		sRet += "Gespeichert: " + sum + " Bytes<br>\n";
		sRet += "<br><img id='bild' name='bild' src='" + sFilePathAndNameNoPic + "'" + " alt='" + sFileName + "'" + " height=188px width=210px><br>\n " +
				"<script> \n" +
				"	refreshPic(opener.document.BodyForm,'" + sFilePathAndNameNoPic + "'); \n" +
				"	document.getElementById('bild').src='" + sFilePathAndNameHtml + "'; \n" +
				"	refreshPic(opener.document.BodyForm,'" + sFilePathAndNameHtml + "'); \n" +
				"	window.close(); " +
				"</script> \n";
		}
		catch (Exception e) {
			//Nix ausser Fehler fangen
			sRet = "<br>Datei zu groß ( max. 1MB)";
		}
		
		return sRet;
	}

	/**
	 * @return
	 */

}
