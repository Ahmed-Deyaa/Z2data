package w3cschoolsTests;

import listners.TestngListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testSet.TestBase;
import w3schools.TablesPage;

@Listeners(TestngListeners.class)
public class TestTable extends TestBase {

    private TablesPage tablesPage;

    @BeforeClass
    public void launch(){
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        tablesPage = new TablesPage(driver);
    }
    @Test
    public void task3(){

        String company = "Ernst Handel";
        String country = "Austria";
        var map = tablesPage.getCompanyData();
        Assert.assertEquals(map.get(company),country);



    }
}
