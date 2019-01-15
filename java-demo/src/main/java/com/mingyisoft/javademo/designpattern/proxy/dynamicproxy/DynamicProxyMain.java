/** 
 * File: StaticProxyMain.java<br> 
 * Project: demoyang<br> 
 * Package: com.mingyisoft.demoyang.designpattern.proxy.staticproxy<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2016年10月7日 下午9:10:04
 * @author yangmh
 */
package com.mingyisoft.javademo.designpattern.proxy.dynamicproxy;

import com.mingyisoft.javademo.designpattern.proxy.staticproxy.HelloSpeaker;
import com.mingyisoft.javademo.designpattern.proxy.staticproxy.IHello;

/**
 * Title: StaticProxyMain<br>
 * Description: StaticProxyMain<br>
 * Company: 韦博英语在线教育部<br>
 * CreateDate:2016年10月7日 下午9:10:04
 * 
 * @author yangmh
 */
public class DynamicProxyMain {
  public static void main(String[] args) {
    LogHandler logHandler = new LogHandler();
    IHello helloProxy = logHandler.getProxy(new HelloSpeaker());
    helloProxy.hello("张三");
  }
}
