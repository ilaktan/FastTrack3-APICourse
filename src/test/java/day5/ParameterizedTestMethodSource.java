package day5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utility.*;

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


    @ParameterizedTest
    @MethodSource("getData")
    public void vyTrackTest(Map<String, String> mapData){
        System.out.println("mapData.get(\"username\") = " + mapData.get("username"));
        System.out.println("mapData.get(\"password\") = " + mapData.get("password"));
        System.out.println("mapData.get(\"firstname\") = " + mapData.get("firstname"));
        System.out.println("mapData.get(\"lastname\") = " + mapData.get("lastname"));

    }

    public static List<Map<String, String >> getData(){

        ExcelUtil trcukFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-all");

        List<Map<String, String>> dataList = trcukFile.getDataList();

        return dataList;
    }




}
