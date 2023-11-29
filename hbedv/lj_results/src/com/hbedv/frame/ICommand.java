package com.hbedv.frame;


import javax.servlet.http.*;

/**
 *  Implementiert das Commandpattern.
 *
 */
public interface ICommand {

  /**
   *  siehe Commandpattern.
   *
   *@param  req
   *@param  resp
   *@return
   *@exception  Exception
   */
  public String execute(HttpServletRequest req, HttpServletResponse resp)
    throws Exception;
}
