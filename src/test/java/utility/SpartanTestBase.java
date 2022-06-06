package utility;

import io.restassured.*;
import org.junit.jupiter.api.*;

public class SpartanTestBase {

    @BeforeEach
    public void init(){ RestAssured.baseURI = "http://44.201.135.133:8000";};
}
