package com.mingyisoft.javademo.method;

/**
 * 值传递
 * @author lenovo
 *
 */
public class MethodDemo2 {
  public static void main(String[] args) {
    People p = new People();
    p.age = 1;
    int x = 2;
    a(p);
    System.out.println(p.age);
    b(x);
    System.out.println(x);
    c(p);
    System.out.println(p);
  }

  static void a(People p) {
    p.age = 3;
  }

  static void b(int a) {
    a = 4;
  }

  static void c(People p) {
    p = null;
  }
}

class People {
  int age;
}