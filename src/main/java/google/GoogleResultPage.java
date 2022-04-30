package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class GoogleResultPage {
    private WebDriver driver;
    public GoogleResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[@class='yuRUbf'])[2]//a")
    WebElement secondSearchResult;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    WebElement resultPage2Link;
    @FindBy(xpath = "//a[@aria-label='Page 3']")
    WebElement resultPage3Link;

    public String goToResultPage(String pageNumber){
        driver.findElement(By.xpath("//a[@aria-label='Page "+pageNumber+"']")).click();
        return secondSearchResult.getAttribute("href");
    }




}
