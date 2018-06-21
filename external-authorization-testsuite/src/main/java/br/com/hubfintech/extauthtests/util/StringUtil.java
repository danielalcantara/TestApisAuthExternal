package br.com.hubfintech.extauthtests.util;

import java.util.Calendar;
import java.util.Random;

public abstract class StringUtil {
	
	static public String generateId() {
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		Calendar.getInstance().getTime();
		String id = "idTest" + random.nextInt()
				+ Long.toHexString(Double.doubleToLongBits(Math.random()));
		
		return id;
	}

}
