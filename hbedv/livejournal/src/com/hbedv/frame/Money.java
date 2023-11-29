package com.hbedv.frame;


import java.text.*;
import java.util.*;

/**
 *@version     1.0
 */

public class Money {
  private Number money;
  public static final String EURO = "\u20ac";  //!!euro
  public static final char EURO_AS_CHAR = '\u20ac';  //!!euro


  /**
   *  Constructor for the Money object
   *
   *@param  money          Description of Parameter
   *@exception  Exception  Description of Exception
   */
  public Money(Number money) {
    if (money == null) {
      throw new NullPointerException("money == null");
    }
    this.money = money;
  }


  /**  Constructor for the Money object */
  public Money() {
    this.money = new Double(0);
  }


  /**
   *  Gets the currency attribute of the Money object
   *
   *@param  locale  Description of Parameter
   *@return         The currency value
   */
  public static String getCurrency(Locale locale) {
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    return ((DecimalFormat) fmt).getPositivePrefix();
  }


  /**
   *  Description of the Method
   *
   *@param  money          zB. 1,12 $
   *@param  locale         zB. "fr", "CA"
   *@return                1.12
   *@exception  Exception  Description of Exception
   */
  public static Money parse(String money, Locale locale) {

    //Fuers parsen muss vorn das Waehrungssymbol stehen!
    int negativ = (money.indexOf('-'));
    if (negativ > -1) {
      if (negativ == 0) {
        money = "-" + EURO + " " + money.substring(1, money.length());
      }
      else {
        throw new UnsupportedOperationException("ORN money: " + money);
      }
    }
    else {
      money = EURO + " " + money;
    }

    //Kommaautomat: *.->*1 *.2->*,2 *.23->*,23
    int len = money.length();
    if (len > 3) {
      //1234
      //euro 1.
      int replaceSpace = 2;
      String mR = money.substring(len - 1 - replaceSpace, len);
      if (mR.indexOf('.') > -1) {
        money = money.substring(0, len - replaceSpace - 1) + mR.replace('.', ',');
      }
    }

    NumberFormat fmt = DecimalFormat.getCurrencyInstance(locale);

    Number n = null;

    try {
      n = fmt.parse(money);
    }
    catch (ParseException pEx) {
      throw new NoSuchElementException("couldNotParse: "+pEx.getMessage());
    }

    return new Money(n);
  }


  /**
   *  Gets the money attribute of the Money object
   *
   *@return    The money value
   */
  public Number getMoney() {
    return money;
  }


  /**
   *  Gets the percentAsString attribute of the Money object
   *
   *@param  percent        Description of Parameter
   *@return                The percentAsString value
   *@exception  Exception  Description of Exception
   */
  public Money getPercentAsMoney(double percent)
    throws Exception {

    double percentMoney = this.money.doubleValue() * percent / 100;
    Money retPercentMoney = new Money(new Double(percentMoney));

    return retPercentMoney;
  }


  /**
   *  Gets the percentAsDouble attribute of the Money object
   *
   *@param  percent        Description of Parameter
   *@return                The percentAsDouble value
   *@exception  Exception  Description of Exception
   */
  public double getPercentAsDouble(double percent)
    throws Exception {

    double percentMoney = money.doubleValue() * percent / 100;
    return percentMoney;
  }


  /**
   *  Gets the example attribute of the Money object
   *
   *@param  locale         Description of Parameter
   *@return                The example value
   *@exception  Exception  Description of Exception
   */
  public String getExample(Locale locale)
    throws Exception {
    return new Money(new Float(1234.456)).format(locale);
  }


  /**
   *  Sets the money attribute of the Money object
   *
   *@param  money  The new money value
   */
  public void setMoney(Number money) {
    this.money = money;
  }


  /**
   *  Description of the Method
   *
   *@param  rs  Description of Parameter
   *@return     Description of the Returned Value
   */
  public Money set(Money rs) {

    money = rs.money;
    return this;
  }


  /**
   *  Description of the Method
   *
   *@param  moneyI  Description of Parameter
   */
  public void set(double moneyI) {
    money = new Double(moneyI);
  }


  /**
   *  Description of the Method
   *
   *@param  locale         Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public String formatWithLocale(Locale locale)
    throws Exception {
    //precondition
    if(locale == null)
      throw new NullPointerException("locale == null");

    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    String mF = fmt.format(this.getMoney().doubleValue());
    return mF;
  }


  /**
   *  Description of the Method
   *
   *@param  locale         Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public String format(Locale locale)
    throws Exception {
    //precondition
    if(locale == null)
      throw new NullPointerException("locale == null");

    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    String mF = fmt.format(money);
    return money.doubleValue() >= 0 ? mF.substring(2, mF.length())
      : "-" + mF.substring(3, mF.length());
  }


  /**
   *  Description of the Method
   *
   *@param  toAdd  Description of Parameter
   */
  public void add(double toAdd) {
    this.setMoney(new Double(money.doubleValue() + toAdd));
  }


  /**
   *  Description of the Method
   *
   *@param  toAdd  Description of Parameter
   */
  public void add(Double toAdd) {
    add(toAdd.doubleValue());
  }


  /**
   *  Description of the Method
   *
   *@param  multiplier  Description of Parameter
   */
  public void multiply(Double multiplier) {
    multiply(multiplier.doubleValue());
  }


  /**
   *  Description of the Method
   *
   *@param  multiplier  Description of Parameter
   */
  public void multiply(double multiplier) {
//    money.doubleValue() *= multiplier;
    this.setMoney(new Double(money.doubleValue() * multiplier));
  }
}
