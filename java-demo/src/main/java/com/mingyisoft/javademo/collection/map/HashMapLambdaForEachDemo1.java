package com.mingyisoft.javademo.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapLambdaForEachDemo1 {
    public static void main(String[] argus) {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        //old
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("------");

        //new
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
            if("c".equals(v)){
                System.out.println("Hello c");
            }
        });

    }
}
