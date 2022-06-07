package utility;

import io.restassured.*;
import org.junit.jupiter.api.*;

public class HrTestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="http://44.201.135.133:1000/ords/hr";
    }

}
