package com.hbedv.db;

import java.util.*;


/**
*  Diese Classe beinhaltet alle SQL-Statements von Alice
*/
public class SQLResource extends ListResourceBundle {


static final Object[][] contents = new String[][]{
        
        // Der ganze Schaas nur aus Kompatibilitätsgründen
        { 
            "SelectUrl",
            "SELECT url "+
            "FROM hl_hilfelink "+
            "WHERE hilfe_id = ? " 
        },
  };

  public Object[][] getContents() {
    return contents;
  }
}
