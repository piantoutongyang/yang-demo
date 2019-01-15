/** 
 * File: WeekEnum.java<br> 
 * Project: deleteme<br> 
 * Package: com.xxx.enumaaa<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2017年2月22日 下午2:07:05
 * @author yangmh
 */
package com.mingyisoft.javademo.enumtest;

/**
 * Title: WeekEnum<br>
 * Description: WeekEnum<br>
 * Company: 韦博英语在线教育部<br>
 * CreateDate:2017年2月22日 下午2:07:05
 * 
 * @author yangmh
 */
public enum WeekEnum {
  MON, TUES, WED;

  private static String week = "星期八";

  public static String getWeek(WeekEnum weekEnum) {
    switch (weekEnum) {
    case MON:
      week = "星期一";
      break;
    case TUES:
      week = "星期二";
      break;
    case WED:
      week = "星期三";
      break;
    }
    return week;
  }
}
