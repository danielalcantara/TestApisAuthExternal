package br.com.cea.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date converterStringToDate(final String date) throws ParseException {
		String dt = date;
		Date data = null;
		Date dataSql = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = dateFormat.parse(dt);
			dataSql = new Date(data.getTime());
		} catch (ParseException e) {
			throw new ParseException("Falha ao tentar converter a data [" + date + "] " + e.getMessage(), 0);
		}

		return dataSql;
	}

	public static Date addMonthsOnDate(Date dateBase, Integer amountOfMonths) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateBase);
		cal.add(Calendar.MONTH, amountOfMonths);

		return cal.getTime();
	}

	public static Date addDaysOnDate(Date dateBase, Integer amountOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateBase);
		cal.add(Calendar.DATE, amountOfDays);

		return cal.getTime();
	}

	public static Timestamp getCurrentDate() throws IOException, ParseException {
		Timestamp tmp = new Timestamp(System.currentTimeMillis());
		String dateString = PropertyUtil.getConfigParamByKey("current.date");

		if (dateString != null && !dateString.trim().isEmpty()) {

			if (dateString != null && !dateString.trim().isEmpty()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date parsedDate = formatter.parse(dateString.trim());
				tmp.setTime(parsedDate.getTime());
			}
		}

		return tmp;
	}

	/**
	 * Compares two Dates without time for ordering.
	 * 
	 * @param date1Param
	 * @param date2Param
	 * @return the value 0 if the date1Param is equal to date2Param; a value less
	 *         than 0 if date1Param is before the date2Param; and a value greater
	 *         than 0 if date1Param is after the date2Param.
	 */
	public static int compareDateWithoutTime(Date date1Param, Date date2Param) throws NullPointerException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1Param);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date1 = cal.getTime();
		cal.setTime(date2Param);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date2 = cal.getTime();

		return date1.compareTo(date2);
	}

}
