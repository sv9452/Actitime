package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author svsun
 *
 */
public class GenericLib {
	
	static String filepath="./config.properties"; 
	/**
	 * @description read value from properties file
	 * @param key
	 * @return String
	 */
	public static String getValue(String key) 
	{
		String value = null;
		try {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream(new File(filepath)));
	  
	  value=prop.getProperty(key);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	return value;		
	}

}
