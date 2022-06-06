package day2;

import io.restassured.*;
import io.restassured.http.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Hamcrest {

    @BeforeEach
    public void init(){ RestAssured.baseURI = "http://44.201.135.133:8000";};

    @Test
    public void test1(){

        assertThat(5+5 , is(10));
        assertThat(5+5 , equalTo(10));
        assertThat(5+5 , not(11));
        assertThat(5+5 , is(not(11)));
        assertThat(5+5 , is(not(equalTo(12))));


    }

    @Test
    public void test2(){
        String text = "Api course";

        assertThat(text, is("Api course"));
        assertThat(text, startsWith("Ap"));
        assertThat(text, endsWith("se"));
        assertThat(text, containsString("course"));
//        assertThat(text, is("Api course"));
    }

    @Test
    public void test3(){
        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,43,12,312,35);

        assertThat(listOfNumbers, hasSize(11));
        assertThat(listOfNumbers, hasItem(32));
        assertThat(listOfNumbers, everyItem(greaterThan(0)));

    }

    @Test
    public void test4(){
        given().accept(ContentType.JSON)
                .and()
                .pathParams("id", 107)
                .when()
                .get("/api/spartans/{id}")
                .then().assertThat()
                .body("id",is(107),
                        "name",is("Jessica"));

    }
}
