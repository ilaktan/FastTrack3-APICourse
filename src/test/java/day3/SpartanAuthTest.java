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

    // http basic
    // api key (for request)    --- token (for user)
    // oAuth
       // 2 is more secure
        // 1 is using digital signature, 2 is using bearer token( easy to share and use, not good for secure)
        // 2 is more flexible ( 1 is only for web, but 2 is also for non-web, like mobile)
    // no auth
}
