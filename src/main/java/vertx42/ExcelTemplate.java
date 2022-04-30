package vertx42;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcelTemplate {


    private WebDriver driver;
    public ExcelTemplate(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[@class='dl']/a)[1]")
    WebElement XLSXDownloadButton;

    public DownloadPage clickOnDownloadXLSX(){

        driver.switchTo().parentFrame();
        XLSXDownloadButton.click();
        return new DownloadPage(driver);

    }
}
