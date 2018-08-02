package br.com.hubfintech.batch.liberarsaldo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
	
	static public String getCurrentDateAndHour() {
		Date processDate = new Date();
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
		
		return sfd.format(processDate);
	}
	
}
