package moe.pingu.iii.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Text {

	public static void main(String[] args) {
		try {
			long dtime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2016-12-25 13:00").getTime();
			System.out.println(new java.util.Date(dtime));
			System.out.println(new java.sql.Timestamp(dtime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
