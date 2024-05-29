package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BaseClass1 {
	public static WebDriver driver;
	Select select;
	Actions actions;
	Navigation navigate;  
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}



	public String getCellData(String sheetName,int rownum,int colnum) throws IOException{
		String res="";
		File file=new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\ExcelSheet\\LoginPOM.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(colnum);

		CellType cellType = cell.getCellType();

		switch(cellType) {
		case STRING:
			res=cell.getStringCellValue();
			break;

		case NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yy");
				res=dateFormat.format(dateCellValue);
			}else {
				long round = Math.round(numericCellValue);
				if(round==numericCellValue) {
					res=String.valueOf(round);
				}else {
					res=String.valueOf(numericCellValue);
				}
			}
			break;

		default :
			break;

		}
		return res;

	}

	public void updateCellData(String sheetname,int rownum,int colnum,String oldData,String newData) throws IOException {
		File file=new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\ExcelSheet\\Login.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(colnum);
		String value = cell.getStringCellValue();
		if(value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);

	}

	public void createCellAndSetData(String sheetName,int rownum,int colnum,String data) throws IOException {
		File file=new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\ExcelSheet\\LoginPOM.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(colnum);
		cell.setCellValue(data);
		FileOutputStream outPutStream=new FileOutputStream(file);
		workbook.write(outPutStream);
	} 

	public void elementMosuseOverActions(WebElement element) {
		actions = new Actions(driver);
		visibilityOfElement(element);
		if (elementIsDisplayed(element)) {
			actions.moveToElement(element).perform();
		}
	}

	public void elementDragAndDrop(WebElement sourceElement, WebElement destElement) {
		visibilityOfElement(destElement);
		visibilityOfElement(sourceElement);
		if (elementIsDisplayed(destElement) && elementIsDisplayed(sourceElement)) {

			actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, destElement).perform();
		}
	}

	public void elementContextClick(WebElement element) {
		actions=new Actions(driver);
		visibilityOfElement(element);
		if(elementIsDisplayed(element)) {
			actions.contextClick(element).perform();
		}

	}

	public void elementDoubleClick(WebElement element) {
		actions=new Actions(driver);
		visibilityOfElement(element);
		if(elementIsDisplayed(element)) {
			actions.doubleClick().perform();
		}
	}

	public void elementClear(WebElement element) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element)) {
			element.clear();
		}
	}

	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AM\\screenshots\\" + sName + ".png"));
	}

	public void screenshot(WebElement element, String sName) throws IOException {
		File f = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AM\\screenshots\\" + sName + ".png"));
	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void implictWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implictWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void selectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByValue(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

	public List<String> dropdownGetAllOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		List<String> allOPtionsText = new ArrayList<>();
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			allOPtionsText.add(text);

		}
		return allOPtionsText;
	}

	public String dropDownFirstSelectedOption(WebElement element) {
		visibilityOfElement(element);
		select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	public boolean dropDownIsMultiSelect(WebElement element) {
		visibilityOfElement(element);
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

	public boolean elementIsDisplayed(WebElement element) {
		visibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsEnabled(WebElement element) {
		visibilityOfElement(element);
		boolean displayed = element.isEnabled();
		return displayed;
	}

	public boolean elementIsSelected(WebElement element) {
		visibilityOfElement(element);
		boolean selected = element.isSelected();
		return selected;
	}

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void enterApplnUrl(String url) {
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	public void elementSendKeysEnter(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			element.sendKeys(data,Keys.ENTER);
		}
	}

	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			element.click();
		}
	}



	public void elementJavaScriptClick(WebElement element) {
		visibilityOfElement(element);
		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
		}
	}

	public void elementJavaScriptScrolIntoView(WebElement element) { 
		visibilityOfElement(element);
		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(false)",element);}
	}

//	public String getApplnTitle() {
//		String title = driver.getTitle();
//		return title;
//	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement element=driver.findElement(By.xpath(attributeValue));
		return element;
	}

	public WebElement findLocatorBycssSelector(String attributeValue) {
		WebElement element=driver.findElement(By.cssSelector(attributeValue));
		return element;
	}


	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = "";

		if (elementIsDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	// 99% value is fixed
	public String elementGetAttribute(WebElement element) {
		visibilityOfElement(element);
		String attribute = "";
		if (elementIsDisplayed(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;
	}

	// 1% value is NOT fixed
	public String elementGetAttribute(WebElement element, String attributename) {
		visibilityOfElement(element);
		String attribute = element.getAttribute(attributename);
		return attribute;
	}

	public void natigateRefresh() {
		navigate.refresh();	
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public static void closeAllWindow() {
		driver.quit();
	}
	public List<WebElement> findelements(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;

	}

}

