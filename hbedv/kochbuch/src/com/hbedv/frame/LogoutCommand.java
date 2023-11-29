package com.hbedv.frame;


import javax.servlet.http.*;

/**
 *  Description of the Class
 *
 *      $
 */
public class LogoutCommand extends Command {

  /**
   *  Constructor for the LogoutCommand object
   *
   *@param  newNext  Description of Parameter
   */
  public LogoutCommand(String newNext) {
    super(newNext);
  }


  /**
   *  Sets the manager attribute of the LogoutCommand object
   *
   *@exception  java.lang.Exception  Description of Exception
   */
  protected void setManager() {

  	/*
    client.setCurManager(new NullManager(client));
    super.manager = (NullManager) (client.getManager());
    */
  }


  /**
   *  Description of the Method
   *
   *@param  request                  Description of Parameter
   *@exception  java.lang.Exception  Description of Exception
   */
  protected void init(HttpServletRequest request)
    throws java.lang.Exception {

    // 12.9.02; orn brauch ma nicht mehr; führt zu Absturz
    // super.init(request); 12.9.02; orn brauch ma nicht mehr führt

    //meine workingseite
    //Manager uiFrameManager = (Manager) manager;
    jspNext = "logout.jsp";
  }


  /**
   *  Description of the Method
   *
   *@param  request                  Description of Parameter
   *@exception  java.lang.Exception  Description of Exception
   */
  protected void speichere(HttpServletRequest request)
    throws java.lang.Exception {
    jspNext = "logout.jsp";
  }

}
