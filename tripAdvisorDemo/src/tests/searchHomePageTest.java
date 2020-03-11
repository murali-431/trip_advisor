package tests;

import org.testng.annotations.Test;

import businessFlow.BusinessMethods;
import framework.CommonMethod;

public class searchHomePageTest {
	@Test
	public void launchingApplication() {
		CommonMethod.launchApplication("chrome", "https://tripadvisor.in/");
	}
	@Test(priority = 1)
	public void searchPage() throws InterruptedException {
		BusinessMethods.Search.searchHomePage();
		BusinessMethods.newwindow.new_page();
		BusinessMethods.review.reviews();
	}

}
