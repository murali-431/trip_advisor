package businessFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.Data;
import framework.EventMethods;

public class BusinessMethods {
	public static class Search {
		public static void searchHomePage() throws InterruptedException {

			EventMethods.clickElement(Data.driver.findElement(By.xpath("//div[@title='Search']")));
			WebElement searchbox = Data.driver.findElement(By.id("mainSearch"));
			EventMethods.enter_the_value(searchbox, "clubmahindra");
			EventMethods.clickElement(Data.driver.findElement(By.xpath("//div[text()='Search']")));
			Thread.sleep(3000);
			EventMethods
					.clickElement(Data.driver.findElement(By.xpath("//span[text()='Club Mahindra Emerald Palms']")));
		}
	}

	public static class newwindow {
		public static void new_page() {
			EventMethods.switch_to_newwindow();
			EventMethods.scrolling_window(Data.driver.findElement(
					By.xpath("//span[@class='hotels-community-content-common-TabAboveHeader__tabCount--26Tct'][1]")));
			EventMethods.clickElement(Data.driver.findElement(By.xpath("//a[@class='ui_button primary']")));
			EventMethods.switch_to_newwindow();
		}
	}

	public static class review {
		public static void reviews() throws InterruptedException {
			EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("bubble_rating")), 75, 0);
			EventMethods.enter_the_value(Data.driver.findElement(By.id("ReviewTitle")), "nice");
			EventMethods.enter_the_value(Data.driver.findElement(By.id("ReviewText")), "verynice");
			EventMethods.scrolling_window(Data.driver.findElement(By.xpath("//div[text()='Hotel Ratings']")));
			EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid12_bubbles")), 40, 0);
			Thread.sleep(3000);
			try {
				EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid190_bubbles")), 40, 0);
			} catch (Exception e) {
				try {
					EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid14_bubbles")), 40, 0);
				} catch (Exception e2) {
					try {
						EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid11_bubbles")), 40,
								0);
					} catch (Exception e3) {
						try {
							EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid13_bubbles")),
									40, 0);
						} catch (Exception e4) {
							EventMethods.move_to_element_with_offset(Data.driver.findElement(By.id("qid47_bubbles")),
									40, 0);
						}

					}

				}
			}
		}
	}

}
