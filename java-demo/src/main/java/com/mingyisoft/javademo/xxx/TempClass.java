package com.mingyisoft.javademo.xxx;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TempClass {
    public static void main(String[] argus) throws Exception{
        FutureTask<Integer> a = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(1/0);
                return 999;
            }
        });

        try {
            Thread t1 = new Thread(a);
            t1.start();

            System.out.println(a.get());
        } catch(Exception ex) {
            System.out.println("aaa");
        }
    }
}