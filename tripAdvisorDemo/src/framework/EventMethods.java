package framework;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventMethods {
	
	public static void move_to_element_with_offset(WebElement element,int x ,int y) {
		Actions act=new Actions(Data.driver);
		act.moveToElement(element, x, y).click().build().perform();
	}
	
	public static void switch_to_newwindow() {
		Set<String>allvalus=Data.driver.getWindowHandles();
		for (String valus : allvalus) {
			Data.driver.switchTo().window(valus);	
		}
	}
	public static void scrolling_window(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) Data.driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void clickElement(WebElement element) {
		if(element!=null) {
			if(wait_until_element_is_displayed(element, 20)) {
				if(wait_until_element_is_enabled(element, 20)) {
					element.click();
				}else {
					Assert.assertTrue(false, "Element is not enabled");
				}
			}else {
				Assert.assertTrue(false, "Element is not displayed");
			}
		}else {
			Assert.assertTrue(false, "Element is not found");
		}
	}
	
	public static boolean wait_until_element_is_enabled(WebElement element,int timeout) {
		boolean elementFound=true;
		try {
		WebDriverWait wait= new WebDriverWait(Data.driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.pollingEvery(Duration.ofMillis(200));
		elementFound=true;
		}catch (Exception e) {
			elementFound=false;
			System.out.println("Element "+element+" is not enabled until "+timeout+" seconds");
		}
		return elementFound;
	}

	public static boolean wait_until_element_is_displayed(WebElement element,int timeout) {
		boolean elementFound=true;
		try {
		WebDriverWait wait= new WebDriverWait(Data.driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(Duration.ofMillis(200));
		elementFound=true;
		}catch (Exception e) {
			elementFound=false;
			System.out.println("Element "+element+" is not displayed until "+timeout+" seconds");
		}
		return elementFound;
	}
	public static void enter_the_value(WebElement element,String input) {
		if(element==null) {
			Assert.assertTrue(false,"element is not foundwith the locator");
		}if(wait_until_element_is_displayed(element, 200)) {
			if(wait_until_element_is_enabled(element, 200)) {
				element.clear();
				element.sendKeys(input);
			}else {
			Assert.assertTrue(false, "element is not enable with in 20 seconds");
		    }
		}else {
			Assert.assertTrue(false, "element is not dispaled with in 20 seconds");
		}
	}	
	
}
