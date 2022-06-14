package day5;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utility.*;

public class SpartanSpecTest extends SpartanSpecTestBase {

    @Test
    public void test1(){

//        Response response = RestAssured.given().accept(ContentType.JSON)
//                .pathParam("id",107)
//                .when().get("http://44.201.135.133:8000/api/spartans/{id}")
//                .then().statusCode(200)
//                .extract().response();

//        RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON)
//                .pathParam("id",107);
//
//        ResponseSpecification resSpec = reqSpec.expect().statusCode(200);

        Response response = RestAssured.given()
                .spec(reqSpec)
                .when().get("http://44.201.135.133:8000/api/spartans/{id}")
                .then().spec(resSpec).extract().response();

        response.prettyPrint();


    }
}
