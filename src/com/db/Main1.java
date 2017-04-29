/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.db;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main1 {
	private String name;

	/**
	 * @param a name
	 *            
	 * @see #getName() get
	 */
	public void setName(String a) {
		this.name = a;
	}

	/**
	 *
	 * @return  name
	 */

	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		System.out.println(new Time(new Date().getTime()).toString());
		System.out.println(new Date().toString());
		System.out.println(new Timestamp(new Date().getTime()));
		SimpleDateFormat df=new SimpleDateFormat("MM-dd_hh-mm-ss");
		SimpleDateFormat df1=new SimpleDateFormat("[ hh:mm:ss ] ");
		System.out.println(df.format(new Date()));
		System.out.println(df1.format(new Date()));
	}
}
