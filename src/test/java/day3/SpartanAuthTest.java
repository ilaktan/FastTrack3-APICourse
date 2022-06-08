package day3;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SpartanAuthTest {

    @BeforeEach
    public void init(){ RestAssured.baseURI = "http://44.201.135.133:8000";};

    @Test
    public void test1(){
        given().auth().basic("admin","admin")
                .and().accept(ContentType.JSON)
                .log().all()
                .when().get("/api/spartans")
                .then().statusCode(200).log().all();
    }
}
