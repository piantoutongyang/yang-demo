package com.mingyisoft.javademo.loop;

public class OutterDemo1 {
	public static void main(String[] args) {
		int i = 0;
		//outer，inner叫标签，
		outer:while(true){
			i++;
			inner:for(int j = 0 ; j < 10 ; j++){
				i += j;
				if(j == 3)
					continue inner;
					break outer;
			}
			continue outer;
		}
		System.out.println("i="+i);
		block:{break block;}
	}
}
