package day3;

import POJO.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;




import java.io.*;
import java.util.*;

public class AdvancedPostPutPatchSpartan extends SpartanTestBase {


    // post with a map
    @Test
    public void test1(){

        Map<String, Object> newSpartan = new HashMap<>();
        newSpartan.put("name","Joe");
        newSpartan.put("gender","Male");
        newSpartan.put("phone",1234567898);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(newSpartan)
                .when().post("/api/spartans");

        response.prettyPrint();

    }

    // post with a class
    @Test
    public void test2(){

        Spartan newSpartan = new Spartan();
        newSpartan.setName("Muhtar");
        newSpartan.setGender("Male");
        newSpartan.setPhone(3216549875l);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(newSpartan)
                .when().post("/api/spartans");

        assertThat(response.statusCode(),is(201));

    }

    // post a sparan with a payload file
    @Test
    public void test3(){

        File file = new File("C:\\Users\\Zulpikar\\IdeaProjects\\FastTrack3-APICourse\\src\\test\\resources\\addNewSpartan.json");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(file)
                .when().post("/api/spartans");

        response.prettyPrint();
    }

    // partial update a spartan
    @Test
    public void test4(){
        Map<String, Object> patchASpartan = new HashMap<>();
        patchASpartan.put("name","Murat");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(patchASpartan)
                .and().pathParam("id",107)
                .when().patch("/api/spartans/{id}");

        response.prettyPrint();
    }

    // response time test
    @Test
    public void test5(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .and()
                .time(lessThan(1000l)).extract().response();

        response.prettyPrint();
    }

    // schema validation for a single spartan
    @Test
    public void test6(){

        given().accept(ContentType.JSON)
                .pathParams("id",107)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }

    // schema validation for all spartans
    @Test
    public void test7(){
        File file = new File("C:\\Users\\Zulpikar\\IdeaProjects\\FastTrack3-APICourse\\src\\test\\java\\day3\\allSpartansSchema.json");

        given().accept(ContentType.JSON)
                .when().get("/api/spartans/")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(file));


    }





}
