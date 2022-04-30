package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

    private WebDriver driver;
    public GoogleHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "q")
    WebElement googleSearchBar;

    @FindBy(name = "btnK")
    WebElement googleSearchButton;

    private void typeInSearchBar(String text){
        googleSearchBar.sendKeys(text);
    }

    private void clickOnSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
        googleSearchButton.click();
    }

    public GoogleResultPage search(String text){
        typeInSearchBar(text);
        clickOnSearchButton();
        return new GoogleResultPage(driver);
    }





}
