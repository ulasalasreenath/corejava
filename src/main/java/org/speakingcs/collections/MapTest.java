package org.speakingcs.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {


    public static void main(String[] args) {
        Map<String, Object> aMap = new HashMap<>();
        Long a = 100L;
        aMap.put("long", a);
        Long b = (Long) aMap.get("long");
        System.out.println(b);

    }
}
