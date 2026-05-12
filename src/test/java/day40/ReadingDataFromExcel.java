package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel -> Workbook -> Sheets -> Rows -> Cells

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\testdata\\Snowpak migration sheets - To send client .xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// XSSFSheet sheet = workbook.getSheetAt(0); - get sheet by index
		XSSFSheet sheet = workbook.getSheet("General page");

		int totalRows = sheet.getLastRowNum();

		int totalCells = sheet.getRow(1).getLastCellNum();

		System.out.println("number of rows: " + totalRows); //counting from 0
		System.out.println("number of cells: " + totalCells); //counting from 1 
		
		for(int r=0; r <=totalRows; r++) 
		{
			XSSFRow currRow = sheet.getRow(r);
			for(int c=0; c<totalCells; c++) 
			{
				XSSFCell currCell = currRow.getCell(c);
				System.out.print("\t" + currCell.toString());
					
			}
			
			System.out.println();
		}
		
		workbook.close();
		file.close();

	}

}