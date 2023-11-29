/*
 * Created on 13.12.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hbedv.frame.bean;

import org.w3c.dom.Document;


import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author krt
 *
 * Aktuelles Userobjekt.
 * Beinhaltet seine Funktionen und Rollen
 */
@SuppressWarnings("unchecked")
public class CurrentUserBean {
	
	private Integer idPerson;
	private String userName;
	private String passwort;
	
	private Document menue;
	
	private HashMap rechte;
	
	private Timestamp lastlogin;
	private int anmeldeversuch; 
	private int loginStatus;
	
	/**
	 * Initializes the currentUserBean
	 */
	public CurrentUserBean() {
		super();
	}
	
	/**
	 * Resets the currentUserBean
	 */
	public void reset() {
		idPerson = null;
		userName = null;
		passwort = null;
		
		menue = null;
		
		rechte = null;
		
		lastlogin = null;
		anmeldeversuch = -1;
		//loginStatus = ILogin.NONE;
	}
	
	/**
	 * Liefert die aktuelle Personen ID
	 */
	public Integer getIdPerson() {
		return idPerson;
	}
	
	/**
	 * @param personId The personId to set.
	 */
	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	
	/**
	 * Liefert den aktuellen User Namen
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return Returns the passwort.
	 */
	public String getPasswort() {
		return passwort;
	}
	
	/**
	 * @param passwort The passwort to set.
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	/**
	 * Gibt das aktuelle Menue zurück
	 * @return Returns the menue.
	 */
	public Document getMenue() {
		return menue;
	}
	
	/**
	 * @param menue The menue to set.
	 */
	public void setMenue(Document menue) {
		this.menue = menue;
	}
	
	/**
	 * @return Returns the rechte.
	 */
	public HashMap getRechte() {
		return rechte;
	}
	
	/**
	 * @param rechte Setzt die Rechte zu dem User
	 */
	public void setRechte(HashMap rechte) {
		this.rechte = rechte;
	}
	
	/**
	 * Prüft ob das Recht bei dem User gesetzt ist
	 * @param matchcode
	 * @return
	 */
	public boolean hasRecht(String matchcode) {
		boolean hasRecht = false;
		
		if (getRechte() != null) {
			hasRecht = getRechte().containsKey(matchcode);
		}
		
		return hasRecht;
	}
	
	/**
	 * @return Returns the anmeldeversuch.
	 */
	public int getAnmeldeversuch() {
		return anmeldeversuch;
	}
	/**
	 * @param anmeldeversuch The anmeldeversuch to set.
	 */
	public void setAnmeldeversuch(int anmeldeversuch) {
		this.anmeldeversuch = anmeldeversuch;
	}
	/**
	 * @return Returns the lastlogin.
	 */
	public Timestamp getLastlogin() {
		return lastlogin;
	}
	
	/**
	 * @param lastlogin The lastlogin to set.
	 */
	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	/**
	 * @return Returns the loginStatus.
	 */
	public int getLoginStatus() {
		return loginStatus;
	}
	
	/**
	 * @param loginStatus The loginStatus to set.
	 */
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
}
