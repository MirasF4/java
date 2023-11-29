/*
 * Created on 04.05.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.frame;

/**
 * @author woi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ILogin {
	public final static int NONE = -1;
	public final static int AUTHENTICATED = 0;
	public final static int USER_UNGUELTIG = 4;
	public final static int USER_LOGGED_OUT_BY_HIMSELF = 5;
	public final static int USER_LOGGED_OUT_BY_HBEDV= 6;
	public final static int USER_LOGGED_OUT_BY_CLOSING_WINDOW = 16;
	public final static int SESSION_TIMEOUT = 7;
	public final static int USER_DATEN_GESCHICKT = 11;
	public final static int USER_DATEN_EMAIL_UNGUELTIG = 12;
	public final static int USER_EMAIL_FEHLT = 13;
	public final static int USER_PASSWORT_UNGUELTIG = 14;
	public final static int USER_ZERTIFIKAT_UNGUELTIG = 15;
	public final static int KEINE_ZUGANGSDATEN = 16;
	public final static int USER_PASSWORT_LAENGE = 17; 
}
