package w3schools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TablesPage {

    public static WebDriver driver;
    public TablesPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




    public HashMap<String,String> getCompanyData(){
        HashMap<String,String> tableData = new HashMap<String,String>();

        int row = driver.findElements(By.xpath("//table[@id = 'customers' ]//tr")).size();

        for(int i =2 ; i<=row ; i++){
            String rowNumber = Integer.toString(i) ;
            String company = "(//table[@id = 'customers' ]//tr["+
                    rowNumber+"])//td[1]";
            String country = "(//table[@id = 'customers' ]//tr["+
                    rowNumber+"])//td[3]";


            tableData.put(driver.findElement(By.xpath(company)).getText(),
                    driver.findElement(By.xpath(country)).getText());
        }
        return tableData;
    }





}
