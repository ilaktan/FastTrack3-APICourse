package day2;

import POJO.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

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

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/jobs");

        JsonPath jsonPath = response.jsonPath();

        Jobs jobs1 = jsonPath.getObject("items[0]", Jobs.class);

        System.out.println(jobs1);
    }
}
