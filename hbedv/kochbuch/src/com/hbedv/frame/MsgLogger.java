package com.hbedv.frame;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.oreilly.servlet.MultipartRequest;



/**
 *  The MsgLogger class is programmed like the Singelton pattern. Messages can be
 *  logged conditionally or fix.
 *
 *      $
 */
@SuppressWarnings("unchecked")
public class MsgLogger {
	
  protected static MsgLogger sInstance = null;
//  private HttpServlet fHttpservlet = null;
  private boolean fDoLoging = false;


  /**  The Constructor is private because of the Singelton pattern. */
  private MsgLogger() { }


  /**
   *  Description of the Method
   *
   *@param  session  Description of Parameter
   *@return          Description of the Returned Value
   */
  public static String formatUserInfo(HttpSession session) {
    String sid = "sid: ";
    if (session != null) {
      sid = sid + (session.getId() == null ? "-" : session.getId());
    }

    return sid;
  }


  /**
   *  The instance method of the Singelton pattern.
   *
   *@return    Description of the Returned Value
   */
  public static synchronized MsgLogger instance() {
    if (sInstance == null) {
      sInstance = new MsgLogger();
    }
    return sInstance;
  }


  /**
   *  Gets the logging attribute of the MsgLogger object
   *
   *@return    The logging value
   */
  public boolean isLogging() {
    return this.fDoLoging;
  }


  /**
   *  Gets the parameterForLog attribute of the MsgLogger object
   *
   *@param  request  Description of Parameter
   *@return          The parameterForLog value
   */
  public String getParameterForLog(HttpServletRequest request) {
    return getParameterAs(Util.CRLF, request);
  }


  /**
   *  Gets the parameterAsHTML attribute of the MsgLogger object
   *
   *@param  request  Description of Parameter
   *@return          The parameterAsHTML value
   */
  public String getParameterAsHTML(HttpServletRequest request) {
    return getParameterAs("<BR>", request);
  }


  /**
   *  Gets the parameterForLog attribute of the MsgLogger object
   *
   *@param  request  Description of Parameter
   *@return          The parameterForLog value
   */
  /*
  public String getParameterForLog(MultipartRequest request) {
    return getParameterAs(Util.CRLF, request);
  }
  */


  /**
   *  Gets the parameterAsHTML attribute of the MsgLogger object
   *
   *@param  request  Description of Parameter
   *@return          The parameterAsHTML value
   */
  /*
  public String getParameterAsHTML(MultipartRequest request) {
    return getParameterAs("<BR>", request);
  }
  */


  /**
   *  Sets the doLoging attribute of the MsgLogger object
   *
   *@param  dl  The new doLoging value
   */
  public void setDoLoging(boolean dl) {
    this.fDoLoging = dl;
  }


  /**
   *  Sets the HttpServlet to get the event.log file.
   *
   *@param  hs  The new httpServlet value
   */
//  public void setHttpServlet(HttpServlet hs) {
//    this.fHttpservlet = hs;
//  }


  /**
   *  Maybe useless, wait until the design-review; 08.03.00 ORN
   *
   *@exception  Throwable  Description of Exception
   */
  public void finalize()
    throws Throwable {
    super.finalize();

//    fHttpservlet = null;
    fDoLoging = false;
    //MsgLogger sInstance = null;
  }


  /**
   *  Log the error message fix in JRuns event.log file.
   *
   *@param  e  Description of Parameter
   */
  public void printlnExceptionLog(Exception e) {
    printlnErrorLog("**X msg: " + e.getMessage());
  }


  /**
   *  Description of the Method
   *
   *@param  s  Description of Parameter
   */
  public void printlnExceptionLog(String s) {
    printlnErrorLog("**X: " + s);
  }


  /**
   *  Log the error message fix in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
  public void printlnErrorLog(String message) {
    printlnExceptionLog("**E: " + message);
  }


  /**
   *  Log the warning message fix in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
  public void printlnWarningLog(String message) {
    printlnWarningLog("**W: " + message);
  }


  /**
   *  Log the hint message fix in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
  public void printlnHintLog(String message) {
    printlnHintLog("**H: " + message);
  }


  /**
   *  Log the time message fix in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
  public void printlnTimeLog(String message) {
    printlnTimeLog("**T: " + message);
  }


  /**
   *  If isLogging then Log the message in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
//  public void printlnLogCon(String message) {
//    if (fHttpservlet != null) {
//      if (isLogging()) {
//        fHttpservlet.log("c> " + message);
//      }
//    }
//  }


  /**
   *  Gets the parameterAs attribute of the MsgLogger object
   *
   *@param  cRLF     Description of Parameter
   *@param  request  Description of Parameter
   *@return          The parameterAs value
   */
 
  @SuppressWarnings("unchecked")
private String getParameterAs(String cRLF, HttpServletRequest request) {
    String param = "No parameters!";
    Enumeration e = request.getParameterNames();
    if (e.hasMoreElements()) {
      int num = 0;
      param = "";
      while (e.hasMoreElements()) {
        String p = (String) e.nextElement();
        param += "name (" + num + ") : " + p;
        String[] values = request.getParameterValues(p);
        int l = 0;
        while (l < values.length) {
          param += "; value (" + l + ") : " + values[l] + cRLF;
          l++;
        }
        num++;
      }
    }
    return param;
  }


  /**
   *  Gets the parameterAs attribute of the MsgLogger object
   *
   *@param  cRLF     Description of Parameter
   *@param  request  Description of Parameter
   *@return          The parameterAs value
   */
  /*
  private String getParameterAs(String cRLF, MultipartRequest request) {
    String param = "No parameters!";
    Enumeration e = request.getParameterNames();
    if (e.hasMoreElements()) {
      int num = 0;
      param = "";
      while (e.hasMoreElements()) {
        String p = (String) e.nextElement();
        param += "name (" + num + ") : " + p;
        String[] values = request.getParameterValues(p);
        int l = 0;
        while (l < values.length) {
          param += "; value (" + l + ") : " + values[l] + cRLF;
          l++;
        }
        num++;
      }
    }
    return param;
  }
  */

  /**
   *  Log the message fix in JRuns event.log file.
   *
   *@param  message  Description of Parameter
   */
//  private synchronized void printlnLog(String message) {
//    if (fHttpservlet != null) {
//      fHttpservlet.log(
//        Thread.currentThread().getName() + ": "
//        + ">" + message + "<");
//    }
//  }
}
