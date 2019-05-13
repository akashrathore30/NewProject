package commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;



import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRead {
	static Workbook wb;
	static FileInputStream fi;
	static Sheet sh;
	static Row headerrow;
	static Row currentrow;
	Cell c;
	static int i;
	static int j;
	String actualcolumnname;
	int expectedcolumnindex;
	static int numberofcolumns;
	static Set<String> s;
	static ArrayList <HashMap<String,String>> Data;
	static String value;
	static Properties pobj;
	static String filepath;
	static String sheetname;
	@SuppressWarnings("deprecation")
	public static String ReadExcelData(String Expectedcolumnvalue, String ExpectedTestCaseName){
	   
	   try{
	   	pobj=PropertyFile.PropertFileObject();
	   	System.out.println("propert object");
	   	filepath=pobj.getProperty("FilePath");
	   	System.out.println(filepath);
	   	
	   	sheetname=pobj.getProperty("SheetName");
	   	System.out.println("method called");
	//fi= new FileInputStream("E://Automation/Workspace/ApplicationAutomation/src/main/java/resources/TestData.xlsx"); 
	   	fi= new FileInputStream(filepath); 
	System.out.println("inside stream");
	wb = new XSSFWorkbook(fi);
	System.out.println("inside workbook");
	// sh=wb.getSheet("Sheet1");
	sh=wb.getSheet(sheetname);
	headerrow=sh.getRow(0);
	System.out.println(headerrow.getLastCellNum());
	System.out.println(sh.getPhysicalNumberOfRows());
	numberofcolumns=headerrow.getLastCellNum();
	   Data=new ArrayList <HashMap<String,String>>();
	   for(i=1; i<sh.getPhysicalNumberOfRows();i++){
	       currentrow=sh.getRow(i);
	       HashMap<String, String> currenthash=new HashMap<String,String>();
	       for(j=0; j<currentrow.getPhysicalNumberOfCells(); j++){
	       Cell currentcell=currentrow.getCell(j);
	       
	       switch (currentcell.getCellType()){
	       
	       case Cell.CELL_TYPE_STRING:
	       	
	       	System.out.println("inside first case");
	           currenthash.put(headerrow.getCell(j).getStringCellValue(), currentcell.getStringCellValue());
	           System.out.println(currenthash.size());
	           break;
	       case Cell.CELL_TYPE_NUMERIC:
	       	System.out.println("inside second case");
	           currenthash.put(headerrow.getCell(j).getStringCellValue(), String.valueOf(currentcell.getNumericCellValue()));
	           System.out.println(currenthash.size());
	       break;
	       }
	       
	           }
	       System.out.println(currenthash.size());
	       Data.add(currenthash);    
	       
	       }
	   
	   for(HashMap<String, String> Newmap:Data){
	        s= Newmap.keySet();
	        System.out.println("size of data" +Data.size());
	        System.out.println("oee inside hash for");
	        System.out.println(s.size());
	        Iterator<String> itr= s.iterator();
	        while(itr.hasNext()){
	       	System.out.println("inside while");
	           String testcasename= itr.next();
	           System.out.println("value of map is"+ Newmap.get(testcasename));
	           System.out.println(testcasename);
	           if(ExpectedTestCaseName.equalsIgnoreCase(Newmap.get(testcasename))){
	           	System.out.println("inside if condition matched");
	               value=Newmap.get(Expectedcolumnvalue);
	               System.out.println(value);
	           }
	        }
	   }
	   
	   
	   }
	   catch(IOException e){
	   	System.out.println("inside catch");
	       e.printStackTrace();
	       System.out.println("inside catch");
	   }
	   return value;
	}
	
	
}