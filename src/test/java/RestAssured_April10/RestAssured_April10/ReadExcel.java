package RestAssured_April10.RestAssured_April10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel{
	
	static int Rows;
	static int cols;
		
public  Object[][] Fetchdata(String Sheet) throws IOException{
		
	FileInputStream ip = new FileInputStream("E:\\Amruta\\UserData.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(ip);
	XSSFSheet sh = wb.getSheet(Sheet);
	Rows = sh.getPhysicalNumberOfRows();
	cols = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Rows are " +  Rows);
		System.out.println("Colums are  "+ cols);
	
		Object[][] arr = new Object[Rows-1][cols];
		
		for(int i =1; i<Rows ; i++)
		{	
			XSSFRow row = sh.getRow(i);
			
			for(int j=0; j<cols ; j++)
			{
				XSSFCell cell = row.getCell(j);
				 
				switch (cell.getCellType()) {
				case STRING:
					arr[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
					break;
				case NUMERIC:
					arr[i-1][j]= sh.getRow(i).getCell(j).getNumericCellValue();
					break;
				}
				
			}
		}
		
		return arr;
	}
	
	}
