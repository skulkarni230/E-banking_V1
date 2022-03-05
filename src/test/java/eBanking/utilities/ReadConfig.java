package eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	public String getURL() {
		String url =  prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String username =  prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String pwd =  prop.getProperty("password");
		return pwd;
	}
	public String getChromePath() {
		String chrome =  prop.getProperty("chromepath");
		return chrome;
	}
	public String getFireFoxPath() {
		String ff =  prop.getProperty("firefoxpath");
		return ff;
	}
	

}
