package com.mingyisoft.javademo.warptype;
/**
 * Integer的值过大后会导致==失去效果，建议使用equals()来做判断。
 * @author lenovo
 *
 */
public class IntegerDemo1 {
  public static void main(String[] args) {
    Integer a = 10000;
    Integer b = 10000;

    System.out.println(b == a);
    System.out.println(b.equals(a));
    
    Integer c = 100;
    Integer d = 100;

    System.out.println(c == d);
    System.out.println(c.equals(d));
  }
}
