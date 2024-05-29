package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWorksheet {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\ExcelSheet\\Login.xlsx");
		FileInputStream stream=new FileInputStream(file);
		
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("Login");
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row = sheet.getRow(i);
			
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				
				CellType cellType = cell.getCellType();
				
				switch(cellType){
				
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
				
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
						String format = dateFormat.format(dateCellValue);
						System.out.println(format);
					}else {
						double numericCellValue = cell.getNumericCellValue();
						long round = Math.round(numericCellValue);
						if(numericCellValue==round) {
							String valueOf = String.valueOf(round);
							System.out.println(valueOf);
						}else {
							String valueOf = String.valueOf(numericCellValue);
							System.out.println(valueOf);
						}
					}
					break;
					
				}
				
				
			}
		}
		
	
	
	}

}
