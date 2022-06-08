package day3;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.*;

public class SpartanApivsDB extends SpartanTestBase {

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",107)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).extract().response();

        Map<String,Object> apiMap = response.as(Map.class);
        System.out.println(apiMap);


        String query = "SELECT SPARTAN_ID, NAME, GENDER ,PHONE FROM SPARTANS WHERE SPARTAN_ID = 107";

        Map<String, Object> dbMap = DBUtilities.getRowMap(query);
        System.out.println(dbMap);


        assertThat(apiMap.get("name"), is(dbMap.get("NAME")));

    }
}
