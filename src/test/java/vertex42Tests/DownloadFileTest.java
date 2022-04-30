package vertex42Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import listners.TestngListeners;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testSet.TestBase;
import vertx42.ExcelTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Listeners(TestngListeners.class)
public class DownloadFileTest {

    private ExcelTemplate excelTemplate;
    WebDriver driver;
    @BeforeClass
    public void launchWebsite() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(controlDownloadDirectory());
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.get("https://www.vertex42.com/ExcelTemplates/excel-gantt-chart.html");
        excelTemplate = new ExcelTemplate(driver);
    }

    @Test
    public void task5()throws Exception{
        var downloadPage = excelTemplate.clickOnDownloadXLSX();
        downloadPage.clickOnDownload();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
        Thread.sleep(5000);
        int totalRowCount = countExcelRows();
        int skippedRows = 8;
        int expectedRowsCount = totalRowCount-skippedRows+1;
        int actualRowsCount = 36;
        Assert.assertEquals(expectedRowsCount,actualRowsCount);
        deleteFile();
    }

    @AfterClass
    public void tear(){
        driver.quit();
    }
    protected ChromeOptions controlDownloadDirectory(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
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

    protected int countExcelRows() throws Exception
    {
        File src = new File(System.getProperty("user.dir")+"/src/excel/gantt-chart_L.xlsx");
        FileInputStream in = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet sheet = wb.getSheetAt(0);
        return sheet.getLastRowNum();
    }
    protected void deleteFile() throws Exception{
        File src = new File(System.getProperty("user.dir")+"/src/excel/gantt-chart_L.xlsx");
        src.delete();
    }

}
