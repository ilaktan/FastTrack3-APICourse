package day5;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class F1XmlTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://ergast.com/api/f1";
    }

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.XML)
                .pathParam("driver","alonso")
                .when().get("/drivers/{driver}");

        response.prettyPrint();

        XmlPath xmlPath = response.xmlPath();

        String name = xmlPath.getString("MRData.DriverTable.Driver.GivenName");
        System.out.println("name = " + name);

        String driverId = xmlPath.getString("MRData.DriverTable.Driver.@driverId");
        System.out.println("driverId = " + driverId);

        String driverCode = xmlPath.getString("MRData.DriverTable.Driver.@code");
        System.out.println("driverCode = " + driverCode);


    }


}
