package day1;


import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.apache.commons.lang3.builder.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class Day1 {

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://44.201.135.133:8000";
    }


    String url = "http://44.201.135.133:8000/api/spartans";
    String baseUrl = "http://44.201.135.133:8000";

    @Test
    public void test1() {


        Response response = RestAssured.given().accept(ContentType.JSON)
                .get(url);

//        response.prettyPrint();
        System.out.println(response.statusCode());
        Assertions.assertEquals(200, response.statusCode());

    }

    // get headers
    // get headers value
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get(url);

        System.out.println(response.getHeaders().toString());

        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertEquals("keep-alive", response.getHeader("Connection"));
        Assertions.assertEquals("timeout=60", response.getHeader("Keep-Alive"));
    }

    // get xml response
    @Test
    public void test3() {
        Response response = RestAssured.given().accept(ContentType.XML)
                .get(baseUrl + "/api/spartans");

        response.prettyPrint();
    }

    // get body information
    @Test
    public void test4() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("api/spartans/107");

        response.prettyPrint();
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        Assertions.assertEquals("Jessica", response.path("name"));
        Assertions.assertEquals("Female", response.path("gender"));


    }

    @Test
    public void test5(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().pathParam("id",107)
                .when().get("api/spartans/{id}");

        response.prettyPrint();
    }

    @Test
    public void test6(){
        Response responseGender = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender","Female")
                .when().get("api/spartans/search");

//        responseGender.prettyPrint();

        Response responseName = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("nameContains","ar")
                .when().get("api/spartans/search");

//        responseName.prettyPrint();

        Response responseMix = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender","Female")
                .when().queryParam("nameContains","j")
                .when().get("api/spartans/search");

        responseMix.prettyPrint();


    }


}
