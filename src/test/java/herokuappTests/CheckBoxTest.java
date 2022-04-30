package herokuappTests;

import herokuapp.CheckBoxPage;
import listners.TestngListeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testSet.TestBase;


@Listeners(TestngListeners.class)
public class CheckBoxTest extends TestBase {

    private CheckBoxPage checkBoxPage;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void launchWebSite(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void task2(){
        checkBoxPage.checkCheckBox1();
        softAssert.assertTrue(checkBoxPage.isCheckBox1Selected());
        softAssert.assertTrue(checkBoxPage.isCheckBox2Selected());
        softAssert.assertAll();
    }
}
