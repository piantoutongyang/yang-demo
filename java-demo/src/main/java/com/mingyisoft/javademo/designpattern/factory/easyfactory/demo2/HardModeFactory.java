package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo2;

public class HardModeFactory {
	public static HardMode createOperate(String type) {
		HardMode returnObj = null;

		switch (type) {
		case "+":
			returnObj = new AddMode();
			break;
		case "-":
			returnObj = new AddMode();
			break;
		case "*":
			returnObj = new AddMode();
			break;
		case "/":
			returnObj = new AddMode();
			break;

		}
		return returnObj;
	}
}
