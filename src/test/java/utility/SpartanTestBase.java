package utility;

import io.restassured.*;
import org.junit.jupiter.api.*;

public class SpartanTestBase {

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://44.201.135.133:8000";

        String dbUrl = "jdbc:oracle:thin:@44.201.135.133:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";

        DBUtilities.createConnection(dbUrl, dbUsername, dbPassword);

    }

    @AfterEach
    public void close(){
        DBUtilities.destroy();
    }
}
