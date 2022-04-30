package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {

    private WebDriver driver;
    public UploadPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "file-upload")
    WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    WebElement submitButton;

    @FindBy(id = "uploaded-files")
    WebElement checkField;

    public void uploadFile(String path){
        chooseFileButton.sendKeys(path);
        submitButton.click();
    }

    public String getUploadedFileName(){
        return checkField.getText();
    }
}
