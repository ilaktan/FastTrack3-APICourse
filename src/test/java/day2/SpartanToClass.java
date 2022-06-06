package day2;

import POJO.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

public class SpartanToClass extends SpartanTestBase {

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/api/spartans/160");

        response.prettyPrint();

        Spartan spartan160 = response.as(Spartan.class);

        System.out.println(spartan160.toString());
    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/api/spartans");

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getList(""));

        Spartan spartan1 = jsonPath.getObject("[1]",Spartan.class);
        Spartan spartan2 = jsonPath.getObject("[2]",Spartan.class);

        System.out.println(spartan1.toString());
        System.out.println(spartan2.toString());

        // ctrl + d

    }

    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender","Female")
                .when().get("/api/spartans/search");

        response.prettyPrint();

        Search female = response.as(Search.class);
        System.out.println(female);
    }




}
