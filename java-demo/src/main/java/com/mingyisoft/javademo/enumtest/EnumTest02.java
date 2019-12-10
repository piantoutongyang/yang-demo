package com.mingyisoft.javademo.enumtest;

public class EnumTest02 {
  public static void main(String[] args) {
    Car c = Car.BMW;

    switch(c) {
      case AUDI:
        System.out.println("你选择了 AUDI!");
        break;
      case BMW:
        System.out.println("你选择了 BMW!");
        break;
      default:
        System.out.println("我不知道你的车型。");
        break;
    }
  }
}
enum Car {
  AUDI,BMW,BENZ
}