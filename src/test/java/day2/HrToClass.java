package day2;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

import javax.swing.plaf.synth.*;

public class HrToClass extends HrTestBase {

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/regions");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Region region1 = jsonPath.getObject("items[0]",Region.class);

        System.out.println(region1);

    }
}
