package com.mingyisoft.javademo.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 集合排序
 *
 * @author alexyang
 *
 */
public class ArrayListLambdaSortDemo1 {
    public static void main(String[] argus) {
        List<String> names1 = new ArrayList<String>();
        names1.add("a");
        names1.add("c");
        names1.add("b");

        List<String> names2 = new ArrayList<String>();
        names2.add("a");
        names2.add("c");
        names2.add("b");

        // jdk7的写法
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        System.out.println(names1);

        System.out.println("----------------------");

        // jdk8的写法
        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));

        System.out.println(names2);

    }
}
