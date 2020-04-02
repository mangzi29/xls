package com.xls.xc.xpy.common;


import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.common
 * @ClassName: BaseObject
 * @Description: 对象的基础父类 用于对对象的统一方便快捷方法的调用
 * @Author: SkyChen
 * @Create: 2020-04-01 20:35
 * @Version: v1.0
 **/
public class BaseObject<T> {

    /**
     * 对象的所有属性和值转换为json字符串
     * @param object 对象
     * @return
     */
    @Transient
    public String  goString(T object) {

        StringBuilder sb =new StringBuilder("========== this is UserLog Object ========= \n");
                      sb.append("{\""+object.getClass().getSimpleName()+"\":{");
        try {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {

                //获得属性名称
                String name = declaredField.getName();

                //属性名首字母转大写
                name = name.substring(0,1).toUpperCase() + name.substring(1);

                //获取属性类型
                String type = declaredField.getGenericType().toString();

                //调用getter方法获取属性值
                Method getMethod = object.getClass().getMethod("get" + name);

                //获取属性值
                Object invoke = getMethod.invoke(object);

                if(type.equals("int")) {
                    sb.append("\""+name+"\":"+invoke);
                }else if(type.equals("class java.lang.Integer")||type.equals("class java.lang.Double")||type.equals("class java.lang.Float")) {
                    sb.append(",\""+name+"\":"+invoke);
                }else {
                    sb.append(",\""+name+"\":\""+invoke+"\"");
                }
            }
           sb.append("}}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
