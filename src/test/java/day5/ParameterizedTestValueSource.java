package day5;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

// value source
// csv source   ___>  comma seperated value
// csv file source
// method source

public class ParameterizedTestValueSource {

    @ParameterizedTest
    @ValueSource (ints = {1,2,3,4,5,6,7})
    public void printNums( int num){
        System.out.println("num = " + num);
    }

    @ParameterizedTest
    @ValueSource( strings = {"Mike","David","Muhtar"})
    public void printNames(String name){
        System.out.println("name = " + name);
    }

    @ParameterizedTest
    @ValueSource ( ints = {107, 108, 109})
    public void getSpartans( int id){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",id)
                .when().get("http://44.201.135.133:8000/api/spartans/{id}");
        System.out.println(response.statusCode());
        response.prettyPrint();
    }




}
