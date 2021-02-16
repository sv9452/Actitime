package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author svsun
 *
 * created on 19 April 2018
 * reviewed by svsun
 */
public class ExcelUtilities 
{
   static String filepath="./testdata/testdata.xlsx";
   
   /**
    * description read data from testdata.xlsx
    * @param sheet
    * @param row
    * @param cell
    * @return String
    */
	
   public static String readData(String sheet, int row, int cell)
   {
	  String value=null;
	  try
	     {
	      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filepath)));
          value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	     }
	  catch(EncryptedDocumentException e) 
	  {
		 e.printStackTrace();
	  }
	  
	  catch(InvalidFormatException e)
	  {
		 e.printStackTrace();
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
	   

