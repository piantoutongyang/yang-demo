package com.mingyisoft.javademo.hashcode;

public class HashCodeDemo1 {
	public static void main(String[] args) {
		int hash=0;  
        String s="ok";  
        StringBuilder sb =new StringBuilder(s);  
          
        System.out.println(s.hashCode()+"  "+sb.hashCode());  
          
        String t = new String("ok");  
        StringBuilder tb =new StringBuilder(s);  
        System.out.println(t.hashCode()+"  "+tb.hashCode());  
        
        System.out.println(s==t);
        System.out.println(s.equals(t));
	}
}

class HashDemo{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}