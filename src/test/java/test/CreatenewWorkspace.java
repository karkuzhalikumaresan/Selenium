package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatenewWorkspace {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\ExcelSheet\\Login.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("sample");
		Row row = sheet.getRow(10);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		if(value.equals("Prem")) {
			cell.setCellValue("Priya");
		}
		FileOutputStream fileOutputstream=new FileOutputStream(file);
		workbook.write(fileOutputstream);
	}

}
