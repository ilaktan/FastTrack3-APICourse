package day2;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

public class HrToClass extends HrTestBase {

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/regions");

        response.prettyPrint();
    }
}
