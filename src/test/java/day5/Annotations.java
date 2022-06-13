package day5;

import org.junit.jupiter.api.*;

public class Annotations {



    @BeforeAll
    public static void init(){
        System.out.println("Before all is running");
    }

    @AfterAll
    public static void after(){
        System.out.println("After all is running");

    }

    @BeforeEach
    public void bEach(){
        System.out.println("Before each is running");

    }

    @AfterEach
    public void aEach(){
        System.out.println("AFter each is running");

    }

    @DisplayName("My first test")
    @Test
    public void test1()
    {
        System.out.println("test 1 is running");
    }

    @Disabled
    @Test
    public void test2()
    {
        System.out.println("test 2 is running");
    }

}
