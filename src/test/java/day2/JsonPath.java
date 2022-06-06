package day2;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

import java.awt.desktop.*;

public class JsonPath extends SpartanTestBase {


    @DisplayName("Using JsonPath")
    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/110");

        response.prettyPrint();

        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("name");
        Long phone = jsonPath.getLong("phone");
        String gender = jsonPath.getString("gender");

        System.out.println(name);
        System.out.println(phone);
        System.out.println(gender);
    }
}
