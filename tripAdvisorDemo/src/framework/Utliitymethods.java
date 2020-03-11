package framework;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utliitymethods {

	private static Object screenshotname;
	public static void create_folder(String folder) {
		File file=new File(folder);
		if(!file.exists()) {
			file.mkdir();
		}	
	}
	public static String gettimestamp(){
		String Timestamp=" ";
		Date dr=new Date();
		Calendar c=Calendar.getInstance();
		Timestamp=Timestamp+c.get(Calendar.MONTH)+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE)+c.get(Calendar.SECOND); 
		return Timestamp;	
	}
	public static String take_screen_shorts() throws IOException {
		create_folder(System.getProperty("user.dir")+"\\screenshort\\");
		TakesScreenshot ts=(TakesScreenshot)Data.driver;
		screenshotname = screenshotname+gettimestamp()+".png";
		File img=ts.getScreenshotAs(OutputType.FILE);
		String destpath=System.getProperty("user.dir")+"\\screenshort\\"+screenshotname;
		File destfile=new File(destpath);
			FileUtils.moveFile(img, destfile);
		return destpath;
		
		

}
	
}