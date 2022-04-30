package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import listners.TestngListeners;
import net.bytebuddy.description.field.FieldList;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Listeners(TestngListeners.class)
public class APITests {

    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;

    @BeforeTest
    public void setUp(){

        requestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @DataProvider(name = "api-data")
    public Object[][] provide() throws Exception {
        File src = new File(System.getProperty("user.dir") + "/src/excel/api-data.xlsx");
        FileInputStream inputStream = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        Object[][] data = new Object[1][3];
        for (int i = 0; i < 3; i++) {
            var x = sheet.getRow(0).getCell(i).getCellType();
            if (x.equals(CellType.STRING)) {
                data[0][i] = sheet.getRow(0).getCell(i).getStringCellValue();
            } else if (x.equals(CellType.NUMERIC)) {
                data[0][i] = dataFormatter.formatCellValue(sheet.getRow(0).getCell(i));
            }
        }
        return data;
    }


    @Test(dataProvider = "api-data")
    public void validateApiBody(String name,String age, String count) {
        given().spec(requestSpecification)
                .when().get("https://api.agify.io/?name=Ahmed")
                .then().spec(responseSpecification)
                .assertThat().body("name",equalToIgnoringWhiteSpace(name))
                .assertThat().body("age",equalTo(Integer.parseInt(age)))
                .assertThat().body("count",equalTo(Integer.parseInt(count)));
    }

}
