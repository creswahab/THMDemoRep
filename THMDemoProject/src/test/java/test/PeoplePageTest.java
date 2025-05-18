package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import pages.PeoplePage;
import utilities.PeopleProfile;





public class PeoplePageTest extends BaseClass{
	
	public void GroupingAndSortingTest() {
        driver.get("https://www.clearlyrated.com/staffing/md-usa/hanover-md/actalent-hanover-md");

        PeoplePage PeoplePage = new PeoplePage(driver);
        PeoplePage.GetAllProfilesDetails();           

}
    
    private List<PeopleProfile> GetTheProfiles(List<WebElement> getprofileDetails) {
        List<PeopleProfile> peopleProfile = new ArrayList<>();
        for (WebElement card : getprofileDetails) {
            String name = card.findElement(By.cssSelector(".profilepeople__name")).getText();
            String photo = card.findElement(By.cssSelector(".profilepeople__image")).getAttribute("src");
            String starRating = null;
          

            WebElement ratingElement = card.findElement(By.cssSelector(".profilepeople-stars__stars"));
            if (ratingElement != null) {
                starRating = card.findElement(By.cssSelector(".profilepeople-stars__text--bold")).getText();;    
            }

            peopleProfile.add(new PeopleProfile(name, photo, starRating));
        }
        return peopleProfile;
    }
}
