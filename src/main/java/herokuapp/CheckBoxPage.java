package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {

    private WebDriver driver;
    public CheckBoxPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//form//input)[1]")
    WebElement checkBox1;

    @FindBy(xpath = "(//form//input)[2]")
    WebElement checkBox2;

    public void checkCheckBox1(){
        checkBox1.click();
    }

    public Boolean isCheckBox1Selected(){
        return checkBox1.isSelected();
    }
    public Boolean isCheckBox2Selected(){
        return checkBox2.isSelected();
    }


}
