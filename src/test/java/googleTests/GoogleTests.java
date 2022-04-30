package googleTests;

import google.GoogleHomePage;
import google.GoogleResultPage;
import listners.TestngListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testSet.TestBase;


@Listeners(TestngListeners.class)
public class GoogleTests extends TestBase {

    private GoogleHomePage googleHomePage;
    GoogleResultPage resultPage;

    @BeforeClass
    public void launchWebsite(){
        driver.get("https://www.google.com");
        googleHomePage = new GoogleHomePage(driver);
        resultPage = googleHomePage.search("Selenium Tutorial");
    }


    @DataProvider(name = "task1-data")
    public Object[][] provide(){
        return new Object[][]{
                {"2","https://www.javatpoint.com/selenium-tutorial"},
                {"3","https://www.tutorialspoint.com/selenium/index.htm"}
        };
    }
    @Test(dataProvider = "task1-data")
    public void task1(String pageNumber,String expectedResult){

        String actualResult = resultPage.goToResultPage(pageNumber);
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
