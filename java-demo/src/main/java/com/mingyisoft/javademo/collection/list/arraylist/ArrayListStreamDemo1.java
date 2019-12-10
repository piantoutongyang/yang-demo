package com.mingyisoft.javademo.collection.list.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 交集、并集、差集、去重并集
 */
public class ArrayListStreamDemo1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");

        List<String> list2 = new ArrayList<String>();
        list2.add("b");
        list2.add("c");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        //不用合成再分解，如果别的地方想用parallel，在前面写就好
        list1.stream().filter(item -> !list2.contains(item)).forEach(n -> {
            System.out.println(n);
        });

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
        System.out.println("---差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEachOrdered(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEachOrdered(System.out :: println);

        //试一下List里面嵌套Map，Map里的元素必须全部一致才是相等，才会被选中交集。
        System.out.println("--------------------------------------------");

        List<Map<String,Object>> list3 = new ArrayList<>();

        Map map1 = new HashMap();
        map1.put("userId","666");
        map1.put("userName","777");
        Map map2 = new HashMap();
        map2.put("userId","111");

        list3.add(map1);
        list3.add(map2);

        List<Map<String,Object>> list4 = new ArrayList<>();
        Map map3 = new HashMap();
        map3.put("userId","666");
//        map3.put("userName","777");

        Map map4 = new HashMap();
        map4.put("userId","444");

        list4.add(map3);
        list4.add(map4);

        // 交集
        List<Map<String,Object>> intersection2 = list3.stream().filter(item -> list4.contains(item)).collect(toList());
        System.out.println("---交集 intersection2---");
        intersection2.parallelStream().forEach(System.out :: println);
    }
}
