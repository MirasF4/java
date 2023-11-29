package com.hbedv.db;

import com.hbedv.frame.Util;
import java.sql.*;


@SuppressWarnings("serial")
public class RepositoryException extends SQLException {
  final static public int DUPLICATE_VALUE= 0;
  final static public int NO_RECORD_CHANGED= 1;
  final static public int KEY_VALUE_STILL_BEING_REFERENCED= 66;
  final static public int RECORD_IS_LOCKED= 1001;
  final static public int CONNECTION_REFUSED= 12519;
  final static public int DB2_LOCKED_OR_TIMEOUT= 57033;
  final static public int INVALID_STATEMENT = 900;
  final static public int SQLRESOURCE_NOT_FOUND = 100001;
  final static public int NO_DATA_FOUND = 4711;

  private int code= Util.UNDEFINED_INT;


  public RepositoryException(String msg, int code)
  {
    super(msg);
    this.code= code;
  }


  public RepositoryException(String msg)
  {
    super(msg);
    this.code= Util.UNDEFINED_INT;
  }


  public RepositoryException(int code)
  {
    super("");
    this.code= code;
  }


  public int getCode() {
    return code;
  }


  public void setCode(int newcode) {
    code = newcode;
  }
}
