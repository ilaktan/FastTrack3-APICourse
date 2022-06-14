package utility;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpartanSpecTestBase {

    public RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON)
            .pathParam("id",107);

    public ResponseSpecification resSpec = reqSpec.expect().statusCode(200);


}
