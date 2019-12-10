package junit;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mingyisoft.javademo.junit.JunitDemo;

public class Junit4Test1 {
	@AfterClass
	public static void xxaa(){
		System.out.println("超级after");
	}
	
	@BeforeClass
	public static void xxaa1(){
		System.out.println("超级before");
	}
	
	@Test
	public void ac(){
		System.out.println("111");
		Assert.assertEquals(5, JunitDemo.demo(4));
		System.out.println("222");
		Assert.assertEquals(5, JunitDemo.demo(5));
		System.out.println("333");
	}
	
	@Test
	public void acxxx(){
		Assert.assertNotEquals(6, JunitDemo.demo(4));
	}
	
	@Test
	public void b(){
		System.out.println("b");
	}
	
	@Test
	public void a(){
		System.out.println("a");
	}
	
	
	
	/**
	 * 出指定异常才会通过
	 */
//	@Test(expected=IOException.class)
	public void xx(){ 
		String aa = null;
		System.out.println(aa.toLowerCase());
		System.out.println("111");
	}
	
	/**
	 * 执行超出时间,单位毫秒
	 * @throws Exception
	 */
//	@Test(timeout=5000)
	public void xx1() throws Exception{ 
		System.out.println(1);
//		Thread.sleep(500000);
		System.out.println(2);
	}
	
	@Ignore("暂不执行,因为xxxx,skipped")
	@Test
	public void xx2() throws Exception{ 
		System.out.println(1);
		System.out.println(2);
	}
	
	/**
	 * 放一些初始化的代码,每一个用例都会跑
	 */
//	@Before
	public void xa(){
		System.out.println("before...");
	}
	
	/**
	 * 无论成功or失败都会run这个,每一个用例都会跑
	 */
//	@After
	public void xa1(){
		System.out.println("after...");
	}
}
