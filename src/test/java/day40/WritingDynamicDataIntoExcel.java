package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		//FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Dynamic SnData");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many rows? ");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many columns? ");
		int noOfCols = sc.nextInt();
		
		for(int r =0; r<noOfRows; r++ ) 
		{
			XSSFRow currRow = sheet.createRow(r);
			
			for(int c = 0; c < noOfCols; c++)
			{
				XSSFCell currCell = currRow.createCell(c);
				System.out.println("Enter cell value r:"+ r +"|c: "+ c);
				currCell.setCellValue(sc.next());
			}
		}
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile_dynamic.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created...");
		
		
	}

}
