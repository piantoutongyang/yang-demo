package com.mingyisoft.javademo.exceptiondemo;


public class ExceptionDemo1 {

	public ExceptionDemo1(){
		
	}
	
	boolean testEx() throws Exception {
		boolean ret = true;
		try{
			ret = testEx1();
		}catch(Exception e){
			System.out.println("testEx,catch exception ");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx finally;return value = "+ret);
		}
		return ret;
	} 
	
	boolean testEx1() throws Exception {
		boolean ret = true;
		try{
			ret = testEx2();
			System.out.println("testEx1,at the end of try");
			return ret;
		}catch(Exception e){
			System.out.println("testEx1,catch exception ");
			ret = false;
			throw e;
		}finally{
			System.out.println("testEx1,finally,return value="+ret);
			return true;
		}
	}
	
	boolean testEx2() throws Exception{
		boolean ret = true;
		
		try{
			int b = 12;
			int c;
			for(int i = 2 ; i >= -2 ;i--){
				c = b / i ;
				System.out.println("i="+i);
			}
			return true;
		}catch(Exception e){
			System.out.println("testEx2,catch exception ");
			ret = false;
			return true;
		}finally{
			System.out.println("testEx2,finally ;return value = "+ret);
			return false;
		} 
	}
	
	public static void main(String[] args) {
		ExceptionDemo1 t = new ExceptionDemo1();
		try{
			t.testEx();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
