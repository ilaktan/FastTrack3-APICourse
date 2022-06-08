package day3;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utility.*;
import static org.hamcrest.Matchers.is;


import static io.restassured.RestAssured.given;

public class XmlTest extends SpartanTestBase {

    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

//        response.prettyPrint();

        XmlPath xmlPath = response.xmlPath();

        String name1 = xmlPath.getString("List.item[0].name");
        System.out.println(name1);

        String gender = xmlPath.getString("List.item[5].gender");
        System.out.println(gender);
    }

    @Test
    public void test2(){
        given().accept(ContentType.XML)
                .when().get("/api/spartans")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/xml")
                .body("List.item[0].name",is("Mustafa"))
                .body("List.item[5].gender",is("Male"))
                .log().all();
    }
}
