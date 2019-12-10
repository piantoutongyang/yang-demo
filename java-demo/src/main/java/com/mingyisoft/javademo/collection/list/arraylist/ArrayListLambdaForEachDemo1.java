package com.mingyisoft.javademo.collection.list.arraylist;

import java.util.*;

/**
 * 集合遍历
 *
 * @author alexyang
 *
 */
public class ArrayListLambdaForEachDemo1 {
    public static void main(String[] argus) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // Old way:
        for (Integer n : list) {
            System.out.println(n);
        }

        System.out.println("-----------------------");

        // New way:
        list.forEach(n -> System.out.println(n));
        System.out.println("-----------------------");
        // or we can use :: double colon operator in Java 8
        list.forEach(System.out::println);

        System.out.println("-----------------------");

        list.forEach(n->{
            if(n==3){
                System.out.println("HELLO 3");
            }
        });
    }
}
