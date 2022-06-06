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
}
