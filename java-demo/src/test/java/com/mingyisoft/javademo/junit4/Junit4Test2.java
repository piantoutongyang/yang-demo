package com.mingyisoft.javademo.junit4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;

import com.mingyisoft.javademo.junit.JunitDemo;

@RunWith(Parameterized.class)
public class Junit4Test2 {
	private int param;
	private int result;

	public Junit4Test2(int param, int result) {
	    this.param = param;
	    this.result = result;
	}

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, });

	}

	@Test()
	public void	 test1() {
		//使用参数化测试
		Assert.assertEquals(result, JunitDemo.demo(param));
	}

	@Test()
	public void test2() {
		//未使用参数化测试
		Assert.assertEquals(2, JunitDemo.demo(1));
	}
}
