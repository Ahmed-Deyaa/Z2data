package testSet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    protected ChromeOptions controlDownloadDirectory(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("load-extension="
                +System.getProperty("user.dir")+
                "/src/excel/cfhdojbkjhnklbpkdaibdccddilifddb/3.12_0");
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("download.default_directory",
                System.getProperty("user.dir")+"\\src\\excel");
        map.put("download.prompt_for_download",false);
        options.setExperimentalOption("prefs",map);
        return options;
    }


}
