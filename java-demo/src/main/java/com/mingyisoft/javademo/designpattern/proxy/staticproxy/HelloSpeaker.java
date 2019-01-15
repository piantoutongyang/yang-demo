/** 
 * File: HelloSpeaker.java<br> 
 * Project: demoyang<br> 
 * Package: com.mingyisoft.demoyang.designpattern.proxy.staticproxy<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2016年10月7日 下午9:06:21
 * @author yangmh
 */
package com.mingyisoft.javademo.designpattern.proxy.staticproxy;

/**
 * Title: HelloSpeaker<br>
 * Description: HelloSpeaker<br>
 * Company: 韦博英语在线教育部<br>
 * CreateDate:2016年10月7日 下午9:06:21
 * 
 * @author yangmh
 */
public class HelloSpeaker implements IHello {

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.mingyisoft.demoyang.designpattern.proxy.staticproxy.IHello#hello(java.
   * lang.String)
   */
  @Override
  public void hello(String name) {
    System.out.println("hello," + name);
  }

}
