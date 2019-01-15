/** 
 * File: ReflectUtil.java<br> 
 * Project: javabase<br> 
 * Package: com.mingyisoft.javabase.util<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2016年4月4日 上午5:59:04
 * @author yangmh
 */
package com.mingyisoft.javawebdemo.util;

import java.lang.reflect.Field;

/**
 * Title: 反射工具类<br>
 * Description: ReflectUtil<br>
 * Company: mingyisoft<br>
 * CreateDate:2016年4月4日 上午5:59:04
 * 
 * @author yangmh
 */
public class ReflectUtil {
	/**
	 * Title: 反射toString方法<br>
	 * Description: 只显示不为空的参数<br>
	 * CreateDate: 2016年4月4日 上午6:00:56<br>
	 * 
	 * @category reflectToString
	 * @author yangmh
	 * @param clazz
	 * @param paramObj
	 * @return
	 */
	public static String reflectToString(Object paramObj) {
		StringBuffer strBuf = new StringBuffer();
		try {
			Field[] fields = paramObj.getClass().getDeclaredFields();

			strBuf.append(paramObj.getClass().getSimpleName());
			strBuf.append("(");
			for (Field field : fields) {
				String fieldName = field.getName();
				if (!"serialVersionUID".equals(fieldName)) {
					field.setAccessible(true);
					Object fieldValue = field.get(paramObj);
					if (fieldValue != null) {
						strBuf.append(field.getName() + ":");
						strBuf.append(fieldValue);
						strBuf.append("|");
					}
				}
			}
			strBuf.append(")");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
}
