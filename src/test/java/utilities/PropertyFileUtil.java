package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getKeyValue(String key) throws Throwable {
		
		Properties conpro = new Properties();
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		
		return conpro.getProperty(key);
		
	}

}
