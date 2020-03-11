package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethod {
	
	public static void launchApplication(String browser,String url) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Data.driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			Data.driver=new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			Data.driver=new InternetExplorerDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Data.driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Browser is invalid");
			break;
		}
		Data.driver.get(url);
		Data.driver.manage().window().maximize();
	}
}
