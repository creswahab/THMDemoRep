package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeoplePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
    @FindBy(css = ".profilepeople__collection")
    private List<WebElement> profileDetails;

    @FindBy(xpath ="//div[@class='profilepeople__pagination']//div[@class='pagination__controls']//button[@class='pagination__stepper pagination__stepper--next']")
    private WebElement nextPage;
    
    public PeoplePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, PeoplePage.class);
    }

    public boolean NextPageAvailable() {
        return nextPage.isEnabled();
    }
    
    public void navigateToNext() {
        WebElement nextpa= wait.until(ExpectedConditions.elementToBeClickable(nextPage));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", nextpa);
     }
    
    public List<WebElement> getprofileDetails() {
    	System.out.println(profileDetails);
        return profileDetails;
    }
    
    public void GetAllProfilesDetails() {
        while (NextPageAvailable()) {
        	navigateToNext();
            wait.until(ExpectedConditions.stalenessOf(profileDetails.get(0)));
            
        }
    }
}
