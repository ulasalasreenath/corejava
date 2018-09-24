package org.speakingcs.strings;

import java.util.Arrays;
import java.util.List;

public class StringPoolTest {

    public static void main(String[] args) {

        List<String> aList = Arrays.asList("realdoc_5847fab3a6bd6134e03e68b5",
                                           "realdoc_58481292a6bd6134e03e68bd",
                                           "realdoc_58516460a6bd613f45d153d0",
                                           "realdoc_585a4a64a6bd613f45d153d6",
                                           "realdoc_5874c46fa6bd61116e474cb2",
                                           "realdoc_58776fa6a6bd615b40aa183b",
                                           "realdoc_587773a1a6bd616eb4d2f473",
                                           "realdoc_587f9756a6bd615346134108",
                                           "realdoc_5881d3e5a6bd61534613410b",
                                           "realdoc_5886047da6bd617ac046cf35",
                                           "realdoc_58874804a6bd6126ef10dfda",
                                           "realdoc_58874805a6bd6126ef10dfdd",
                                           "realdoc_5888a4dca6bd613c5cd400da",
                                           "realdoc_5888b49aa6bd613c5cd400ed",
                                           "realdoc_5888b4f3a6bd613c5cd400ef",
                                           "realdoc_588af6a9a6bd613c5cd400f1",
                                           "realdoc_5893465fa6bd6153d1fbfa7a",
                                           "realdoc_58a2f04fa6bd6153d1fbfa94",
                                           "realdoc_58a2ff3aa6bd6153d1fbfa96",
                                           "realdoc_58a56ea8a6bd6153d1fbfa9a",
                                           "realdoc_58a58c28a6bd6153d1fbfa9c",
                                           "realdoc_58a58e71a6bd6153d1fbfa9f");

        String s1 = getKey(aList.get(0), "PACKAGE");
        String s2 = getKey(aList.get(0), "PACKAGE");
        String s3 = getKey(aList.get(0), "PACKAGE");
        String s4 = getKey(aList.get(0), "PACKAGE");
        String s5 = getKey(aList.get(0), "PACKAGE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);


        String s6 = "PACKAGE"+"_"+"STACK";
        String s7 = "PACKAGE"+"_"+"STACK";

        String s10 = "realdoc_5847fab3a6bd6134e03e68b5";
        String s8 = s10 +"_"+ "PACKAGE";
        String s9 = s10 +"_"+ "PACKAGE";

        String s11 = "PACKAGE";
        final String s12 = s11 + "_" + "STACK";
        final String s13 = s11 + "_" + "STACK";

        System.out.println(s6 == s7);
        System.out.println(s8 == s9);
        System.out.println(s7 == s12);


        check(s8, s9);

        System.out.println(s12 == s13);


    }

    private static String getKey(String s, String aPackage) {
        return s+"_"+aPackage;
    }

    private static void check(String s1, String s2) {
        //return s+"_"+aPackage;
        System.out.println(s1 == s2);
    }

}
