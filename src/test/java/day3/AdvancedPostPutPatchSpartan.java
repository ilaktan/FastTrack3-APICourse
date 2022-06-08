package day3;

import POJO.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


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
}
