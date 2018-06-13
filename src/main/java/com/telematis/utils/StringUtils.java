package com.telematis.utils;

import java.lang.reflect.Field;
/**
 * 工具类
 * 判断对象中属性值是否为空
 * @author 念阿郎
 *
 */
public class StringUtils {

	public static boolean checkObjFieldIsNull(Object obj){
	    boolean flag = false;
	    for(Field f : obj.getClass().getDeclaredFields()){
	        f.setAccessible(true);
	        try {
				if(f.get(obj) == null){
				    flag = true;
				    return flag;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	    }
	    return flag;
	}
}
