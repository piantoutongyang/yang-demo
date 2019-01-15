package com.mingyisoft.javademo.xxx;

 class Son extends Father{
    String name = "tom";
    public void eat(){
         System.out.print("soneat,");
    }
   
    public static void main(String[] args) {
         Son s = new Son();
         Father f = new Son();
         s.eat();
         System.out.print(s.name+".");
         f.eat();
         System.out.print(f.name+".");
         
         Thread zz = null;
    }
}

class Father{
    String name = "jack";
    public void eat(){
         System.out.print("fathereat,");
    }
}
