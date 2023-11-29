package com.hbedv.kochbuch;


/**
 *  <Description of the Class>
 *
 */
public class Kochbuch {
	//Cmds im KochbuchBean und allen anderen Webapps die davon aufgerufen werden
	
    public final static String CMD_REPORT = "cmd_report";
    public final static String CMD_VORSPEISEN = "cmd_vorspeisen";
    public final static String CMD_HAUPTSPEISEN = "cmd_hauptspeisen";
    public final static String CMD_DESERTS = "cmd_deserts";
    public final static String CMD_SALATE = "cmd_salate";
    public final static String CMD_BACKWAREN = "cmd_backwaren";
    public final static String CMD_KEKSE = "cmd_kekse";
        
    public final static String SUB_CMD_BACK = "sub_cmd_back";
    public final static String SUB_CMD_NEXT = "sub_cmd_next";
    public final static String SUB_CMD_FIRST = "sub_cmd_first";
    public final static String SUB_CMD_LAST = "sub_cmd_last";
    public final static String SUB_CMD_SUCHEN = "sub_cmd_suchen";
    public final static String SUB_CMD_AUSWAHL = "sub_cmd_auswahl";
    public final static String SUB_CMD_EDIT = "sub_cmd_edit";
    public final static String SUB_CMD_DELETE = "sub_cmd_delete";
    public final static String SUB_CMD_DELETE_PIC = "sub_cmd_delete_pic";
    public final static String SUB_CMD_SAVE = "sub_cmd_save";
    public final static String SUB_CMD_INSERT = "sub_cmd_insert";
    public final static String SUB_CMD_UPLOAD = "sub_cmd_upload";
    public final static String SUB_CMD_PRINT_REZEPT = "sub_cmd_print_rezept";
    public final static String SUB_CMD_LOGINUSER = "sub_cmd_loginuser";
    public final static String SUB_CMD_LOGOUTUSER = "sub_cmd_logoutuser";
	
    public final static String PORTAL_LANGBUNDLE = "com.poi.fux.portal.LabelsBundle";

	/**  Constructor for the KochbuchBean object */
	private Kochbuch() { }
}
