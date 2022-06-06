package day2;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;

import java.util.*;

public class JsonToJava extends SpartanTestBase {

    // response body to map
    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans/110");

        response.prettyPrint();

        Map<String, Object> responseMap = response.as(Map.class);

        System.out.println(responseMap.toString());

        System.out.println(responseMap.get("id"));
        System.out.println(responseMap.get("name"));

    }

    // response to list
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans");

//        response.prettyPrint();

        List<Map<String, Object>> responseList = response.as(List.class);

        System.out.println(responseList);

        // I want no20 spartan from the list
        System.out.println(responseList.get(19).get("id"));
        System.out.println(responseList.get(19).get("name"));
        System.out.println(responseList.get(19).get("phone"));


    }
}
