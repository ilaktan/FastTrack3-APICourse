package day5;

import org.junit.jupiter.api.*;

public class Annotations {

    @BeforeAll
    public static void init(){
        System.out.println("Before all is running");
    }
}
