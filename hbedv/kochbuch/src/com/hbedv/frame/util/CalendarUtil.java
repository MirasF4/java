/*
 * Created on 06.10.2004
 *
 * Contains often used methods for the Calendar/GregorianCalendar
 */
package com.hbedv.frame.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author krt
 *
 * Contains often used methods for the Calendar/GregorianCalendar
 */
public class CalendarUtil {
	
	
 /**
  * Returns a Gregorian Calendar reflection ISO 8601 and many national
  * standards
  * 
  * Example:
  * Values calculated for the WEEK_OF_YEAR field range from 1 to 53. Week 1
	*	for a year is the first week that contains at least
	*	getMinimalDaysInFirstWeek() days from that year. It thus depends on the
	*	values of getMinimalDaysInFirstWeek(), getFirstDayOfWeek(), and the day of
	*	the week of January 1. Weeks between week 1 of one year and week 1 of the
	*	following year are numbered sequentially from 2 to 52 or 53 (as needed).
	*
	*	For example, January 1, 1998 was a Thursday. If getFirstDayOfWeek() is
	*	MONDAY and getMinimalDaysInFirstWeek() is 4 (these are the values
	*	reflecting ISO 8601 and many national standards), then week 1 of 1998
	*	starts on December 29, 1997, and ends on January 4, 1998. If, however,
	*	getFirstDayOfWeek() is SUNDAY, then week 1 of 1998 starts on January 4,
	*	1998, and ends on January 10, 1998; the first three days of 1998 then are
	*	part of week 53 of 1997."
	*
  * 
  * @return Calendar
  */
  public static Calendar getGregorianCalender() {
		Calendar cal = new GregorianCalendar();
		//ISO 8601
		cal.setMinimalDaysInFirstWeek(4);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal;
	}
}
