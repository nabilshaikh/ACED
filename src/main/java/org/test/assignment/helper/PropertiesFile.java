package org.test.assignment.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile
{
	
	static String propsPath = System.getProperty("user.dir")+"//Configuration//"+"config.properties";
	
	public static Properties getProperties() throws IOException
	{
        File propsFile = new File(propsPath);
        FileInputStream inputStream = new FileInputStream(propsFile);
        Properties props = new Properties();
        props.load(inputStream);
        inputStream.close();
        return props;
	}              
        
	public static String getProperty(String key) throws IOException 
	{
        return getProperties().getProperty(key);
	}
	
	public static String getReportConfigPath() throws IOException
	{
		String reportConfigPath = getProperties().getProperty("reportConfigPath");
		if(reportConfigPath!= null) 
			return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
}
