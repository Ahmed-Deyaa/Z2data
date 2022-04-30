package herokuappTests;

import herokuapp.UploadPage;
import listners.TestngListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testSet.TestBase;

@Listeners(TestngListeners.class)
public class UploadTest extends TestBase {

    private UploadPage uploadPage;
    private String path = System.getProperty("user.dir")+ "/src/excel/upload.txt";
    private String name = "upload.txt";


    @BeforeClass
    public void launchWebSite(){
        driver.get("http://the-internet.herokuapp.com/upload");
        uploadPage = new UploadPage(driver);
    }

    @Test
    public void task4(){
        uploadPage.uploadFile(path);
        Assert.assertEquals(uploadPage.getUploadedFileName(),name);

    }

}
