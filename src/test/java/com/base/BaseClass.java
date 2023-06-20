package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author rajpr
 * @see Used to maintain all reusable methods
 * @Date 07/Jan/2023
 */
public class BaseClass {
	public static WebDriver driver;
	
	
public void anyDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
//			ChromeOptions co = new ChromeOptions ();
//			co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
}
		else if(browserName.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver(); }
		
        else if(browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			
		}
		}
	
	
	
	
	
	
	/**
	 * @see used to get driver
	 * @param browserType
	 */
//	public void getDriver(String browserName) {
//		
//		switch(browserName) {
//		case "chrome":
//			driver=new ChromeDriver();
//			break;
//		case "firefox":
//			driver=new FirefoxDriver();
//			break;
//		case "ie":
//			driver=new InternetExplorerDriver();
//			break;
//		case "edge":
//			driver=new EdgeDriver();
//			break;
//			default:
//			break;
//			
//		}
//		}
	/**
	 * @see used to get Project Path 
	 * @return String
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
		}
	
/**
 * @see used to get Property File Value
 * @param key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
		Object object = properties.get(key);
		String value=(String)object;
		return value;

	}
	
	

	//launch browser
	/**
	 * @see used to get Chrome Driver
	 */
	public static void getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	/**
	 * @see used to clear Text Box1
	 * @param element
	 */
	public void clearTextBox1(WebElement element) {
		element.clear();

	}
	
	//Launch URL
	/**
	 * @see used to enter ApplUrl
	 * @param url
	 */
	public static void enterApplUrl(String url) {
		driver.get(url);
		}
	/**
	 * @see used to maximize window
	 */
	public static  void maximizewindow() {
		driver.manage().window().maximize();
		}
	/**
	 * @see element Insert Value
	 * @param element
	 * @param data
	 */
	public static void elementInsertValue(WebElement element, String data) {
		element.sendKeys(data);
		}
	/**
	 * @see used to element Click
	 * @param element
	 */
	public static void elementClick(WebElement element) {
		element.click();
		}
	/**
	 * @see used to click Alert Ok
	 */
	public static void clickAlertOk() {
		 Alert alert = driver.switchTo().alert();
		 alert.accept();

	}
	/**
	 * @see used to click Alert Cancel
	 */
	public  void clickAlertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	/**
	 * @see used to element Get Text
	 * @param element
	 * @return String
	 */
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;

	}
	/**
	 * @see used to element Get Attribute
	 * @param element
	 * @param value
	 * @return String
	 */
	public static String elementGetAttribute(WebElement element, String value) {
		String attribute = element.getAttribute("value");
		return attribute;
		}
	/**
	 * @see used to close All Window
	 */
	public  void quitWindow() {
		driver.quit();

	}
	/**
	 * @see used to close Current Win
	 */
	public  void closeCurrentWin() {
		driver.close();

	}
	/**
	 * @see used to get Title
	 * @return String
	 */
	public  String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	/**
	 * @see used to Get Enter Url
	 * @return String
	 */
	public  String GetEnterUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	/**
	 * @see used to dropDown By Text
	 * @param element
	 * @param data
	 */
	
	public  void dropDownByText(WebElement element, String data) {
		Select s=new Select(element);
		s.selectByVisibleText(data);

	}
	/**
	 * @see used to dropDown By Attribute
	 * @param element
	 * @param data
	 */
	public  void dropDownByAttribute(WebElement element, String data) {
		Select s=new Select(element);
		s.selectByValue(data);
		}
	/**
	 * @see used to dropDown Index
	 * @param element
	 * @param index
	 */
	public  void dropDownIndex(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
		}
	/**
	 * @see used to insert Value By JavaScript
	 * @param element
	 * @param data
	 */
	public  void insertValueByJs(WebElement element, String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].setAttribute('value"+data+"')", element);

	}
	/**
	 * @see used to click button By javascript
	 */
	public void clickBtnByJs(WebElement element , String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
		}
	/**
	 * @see used to switch child Window
	 * @param childwin
	 */
	public void childWindow(String childwin) {
		driver.switchTo().window(childwin);

	}
	/**
	 * @see used to switch to particular Frame Index
	 * @param index
	 */
	public void switchtoFrameIndex(int index) {
		driver.switchTo().frame(index);
		}
	/**
	 * @see used to switch To particular Frame Id
	 * @param id
	 */
	public  void switchToFrameId(String id) {
		driver.switchTo().frame(id);

	}
	/**
	 * @see used to locator By Id
	 * @param attributeValue
	 * @return WebElement
	 */
	public static  WebElement locatorById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
		}
	/**
	 * @see used to locator By Name
	 * @param attributeValue
	 * @return WebElement
	 */
	public  WebElement locatorByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
		
		}
	/**
	 * @see used to locator By Xpath
	 * @param xpathExp
	 * @return WebElement
	 */
	public  WebElement locatorByXpath(String xpathExp) {
		WebElement findElement = driver.findElement(By.xpath(xpathExp));
		return findElement;
		
	}
	/**
	 * @see used to get all options from dropdown as text
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> ddalloptiontext(WebElement element) {
		Select s = new Select(element);
		// String text1 = element.getText();
		// s.selectByVisibleText(text1);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
		return options;
	}

	/**
	 * @see used to get all options from dropdown as attribute
	 * @param element
	 * @param value
	 * @return List<WebElement>
	 */
	public List<WebElement> ddalloptioninattribute(WebElement element, String value) {
		Select s = new Select(element);
		// String attribute = element.getAttribute(value);
		// s.selectByValue(attribute);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getAttribute(value);
			System.out.println(text);
		}
		return options;

	}

	/**
	 * @see used to	get first selected option text in dropdown
	 * @param element
	 * @return String
	 */
	public  String dropDownFirstSelectedTxt(WebElement element) {
		Select s=new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
		}
	/**
	 * @see used to dropDown Multi Selected
	 * @param element
	 * @return boolean
	 */
	public  boolean dropDownMultiSelected(WebElement element) {
	 Select s=new Select(element);
	 boolean multiple = s.isMultiple();
	return multiple;
	 }
	
	/**
	 * @see used to implicit Wait
	 * @param sec
	 */
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}
	/**
	 * @see used to explicit Wait
	 * @param seconds
	 * @param idvalue
	 * @return boolean
	 */
	public boolean explicitWait(long seconds,String idvalue) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		boolean until = w.until(ExpectedConditions.invisibilityOfElementLocated(By.id(idvalue)));
		return until;
	}
	/**
	 * @see used to fluent wait
	 * @param sec
	 * @param sec1
	 */
	public  void fluentwait(long sec , long sec1) {
		Wait wait  = new FluentWait(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(sec1)).ignoring(Throwable.class);
	}
	/**
	 * @see used to check element is Displayed
	 * @param element
	 * @return boolean
	 */
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
		}
	/**
	 * @see used to check element is Enabled
	 * @param element
	 * @return boolean
	 */
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;

	}
	/**
	 * @see used to check element is Selected
	 * @param element
	 * @return boolean
	 */
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
		}
	/**
	 * @see used to deselect By Index
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element, int index) {
		Select s=new Select(element);
		s.deselectByIndex(index);

	}
	/**
	 * @see used to deselect By Attribute
	 * @param element
	 * @param value
	 */
	public void deselectByAttribute(WebElement element, String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
				
	}
	/**
	 * @see used to deselect By Text
	 * @param element
	 * @param text
	 */
	public void deselectByText(WebElement element,String  text) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);

	}
	/**
	 * @see used to deselect All
	 * @param element
	 */
	public void deselectAll(WebElement element) {
		Select s=new Select(element);
		s.deselectAll();

	}
	/**
	 * @see used to get parent window
	 * @return String
	 */
	public String parWindowGent() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
	/**
	 * @see used to get all Window
	 * @param element
	 * @return Set<String>
	 */
	public Set<String> allWindow(WebElement element) {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
		

	}
	/**
	 * @see used to clear Text Box
	 * @param element
	 */
	public void clearTextBox(WebElement element) {
		element.clear();

	}
	/**
	 * @see used to Take Screenshot
	 */
	public void TakesScreenshot() {
		TakesScreenshot screenshot=(TakesScreenshot)driver;

	}
	/**
	 * @see used to take screeshot on particular Element
	 * @param element
	 */
	public void takescreeshotElement(WebElement element ) {
		element.getScreenshotAs(OutputType.FILE);

	}
	/**
	 * @see used to mouseover on single Option
	 * @param driver
	 * @param element
	 */
	public void singleOptionMouseover(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
		}
	/**
	 * @see used to drag And Drop
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebElement source,WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}
	/**
	 * @see used to rightClick
	 */
	public void rightClick() {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();

	}
	/**
	 * @see used to doubleClick
	 */
	public void doubleClick() {
		Actions actions=new Actions(driver);
		actions.doubleClick().perform();
		
	}
	/**
	 * @see used to insert Value And Enter
	 * @param element
	 * @param value
	 */
	public void insertValueAndEnter(WebElement element,String value ) {
		element.sendKeys("Value",Keys.ENTER);

	}
	/**
	 * @see used to refresh Page
	 */
	public void refreshPage() {
		driver.navigate().refresh();

	}
	/**
	 * @see used to forward Page
	 */
	public void forwardPage() {
		driver.navigate().forward();

	}
	/**
	 * @see used to back Page
	 */
	public void backPage() {
		driver.navigate().back();

	}
	/**
	 * @see used to navigate To url
	 * @param url
	 */
	public void navigatTo(String url) {
		Navigation navigate = driver.navigate();
		navigate.to(url);
	}
	/**
	 * @see used to key Press
	 * @param keycode
	 * @throws AWTException
	 */
	public void keyPress(int keycode) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(keycode);
		
	}
	/**
	 * @see used to key Release
	 * @param keycode
	 * @throws AWTException
	 */
	public void keyRelease(int keycode) throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(keycode);

	}
	/**
	 * @see used to key Up
	 * @param target
	 * @param key
	 */
	public void keysUp(WebElement target,CharSequence key) {
		Actions actions=new Actions(driver);
		actions.keyUp(target, key);

	}
	/**
	 * @see used to key Down
	 * @param target
	 * @param key
	 */
	public void keyDown(WebElement target,CharSequence key) {
		Actions actions=new Actions(driver);
		actions.keyDown(target, key).perform();
		

	}
	/**
	 * @see used to dropDown All Selected Option
	 * @param element
	 * @return String
	 */
	public String dropDownAllSelectedOption(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			return text;
			
		}
		return null;

	}
	
	
}
