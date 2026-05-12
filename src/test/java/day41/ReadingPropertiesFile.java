package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//create object of Properties class
		Properties propertiesObj = new Properties();
		
		//location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		//Loading properties file
		propertiesObj.load(file);
		
		//Reading data from properties file
		String url = propertiesObj.getProperty("appurl");
		String email = propertiesObj.getProperty("email");
		String password = propertiesObj.getProperty("password");
		String orid = propertiesObj.getProperty("orderid");
		String cusid = propertiesObj.getProperty("customerid");
		
		System.out.println(url +" "+ email +" "+ password +" "+ orid +" "+ cusid);
		
		//Reading all the keys from properties file
		Set<String> keysString = propertiesObj.stringPropertyNames();
		System.out.println(keysString);
		
		Set<Object> keys = propertiesObj.keySet();
		System.out.println(keys.toString());
		
		//Reading all the value from properties file
		Collection<Object> values = propertiesObj.values();
		System.out.println(values.toString());
		
		file.close();
	}

}
