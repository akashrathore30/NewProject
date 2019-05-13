package commonmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
public static Properties p;
public static String propertyfilepath="C://Users/Sony/workspace/ApplicationTesting/src/main/java/resources/Env_Var.properties";

private PropertyFile(){
	
}

public static Properties PropertFileObject(){
	
	
	
	try {
		p=new Properties();
		FileInputStream propfile= new FileInputStream(propertyfilepath);
		
		p.load(propfile);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return p;
}
}
