package vertx42;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage {

    private WebDriver driver;
    public DownloadPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[@class='p402_premium']//a)[2]")
    WebElement downloadButton;

    public void clickOnDownload(){


        downloadButton.click();
    }
}
