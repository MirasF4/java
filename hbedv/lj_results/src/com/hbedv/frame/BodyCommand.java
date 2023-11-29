package com.hbedv.frame;


/**
 *  <Description of the Class>
 *
 *      $
 */
public abstract class BodyCommand extends Command {
  
    //private String next;


  /**
   *  Constructor for the BodyCommand object
   *
   *@param  newNext  Description of Parameter
   */
  public BodyCommand(String newNext) {
      super(newNext);
  }


  protected abstract void setManager();

  /**
   *  Description of the Method
   *
   *@param  request               Description of Parameter
   *@param  response              Description of Parameter
   *@return                       Description of the Returned Value
   */
}
