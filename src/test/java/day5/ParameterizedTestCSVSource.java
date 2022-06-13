package day5;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTestCSVSource {


    @ParameterizedTest
    @CsvSource({"1,2,3",
            "3,4,7",
            "2,4,6"})
    public void sum(int a, int b, int sum) {

        Assertions.assertEquals(a + b, sum);
    }

    @ParameterizedTest
    @CsvSource({"117,Jessica",
            "131, Armen",
            "152, Dashawn"})
    public void nameId(String id, String name){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",id)
                .when().get("http://44.201.135.133:8000/api/spartans/{id}");

        Assertions.assertEquals(name, response.path("name"));
    }
}
