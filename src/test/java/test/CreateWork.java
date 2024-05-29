package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWork {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\\\Users\\\\karku\\\\eclipse-workspace\\\\FrameworkClass\\\\ExcelSheet\\\\Login.xlsx");
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("kk");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(2);
		cell.setCellValue("Karkuzhali");
		FileOutputStream fileOutputstream=new FileOutputStream(file);
		workbook.write(fileOutputstream);
	}

}
