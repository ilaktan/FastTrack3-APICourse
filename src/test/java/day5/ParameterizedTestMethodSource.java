package day5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;

public class ParameterizedTestMethodSource {

    @ParameterizedTest
    @MethodSource("getNames")
    public void carBarands(String brands){
        System.out.println("My car is " + brands);
    }

    public static List<String> getNames(){
        List<String> names = Arrays.asList("Honda", "Toyota", "Ford", "Tesla");

        return names;
    }




}
