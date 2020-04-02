package com.xls.xc.xpy.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.common
 * @ClassName: ObjectChangeValue
 * @Description: 对原始对象的值的替换工具类
 * @Author: SkyChen
 * @Create: 2020-04-01 14:43
 * @Version: v1.0
 **/
public class ObjectChangeValueTool {

    /**
     * 转换对象的所有值
     * @param entityClass
     * @param oldEntity 原始已经持久化的对象的值
     * @param newEntity 要修改的对象值
     * @param <T>       类的泛型
     * @return
     */
    public static<T>  T  changeAllValue(Class<T> entityClass,T oldEntity,T newEntity) {

        //获取实体的所有属性
        Field[] declaredFields = entityClass.getDeclaredFields();
        try {
                for (Field declaredField : declaredFields) {
                    //获取属性名
                    String name = declaredField.getName();

                    //属性名首字母转大写
                    name = name.substring(0,1).toUpperCase() + name.substring(1);

                    //获取属性类型
                    String type = declaredField.getGenericType().toString();
                    //如果类型为int  则是主键id不用转换
                    if (type.endsWith("int")) {
                        continue;
                    }
                    //调用getter方法获取属性值
                    Method getMethod = newEntity.getClass().getMethod("get" + name);
                    if(type.equals("class java.lang.String")) {
                        String invoke =(String) getMethod.invoke(newEntity);
                        if(invoke !=null) {
                            Method setMethod = oldEntity.getClass().getMethod("set" + name, String.class);
                            setMethod.invoke(oldEntity,invoke);
                        }
                    }

                    if(type.equals("class java.lang.Integer")) {
                        Integer invoke =(Integer) getMethod.invoke(newEntity);
                        if(invoke !=null) {
                            Method setMethod = oldEntity.getClass().getMethod("set" + name, Integer.class);
                            setMethod.invoke(oldEntity,invoke);
                        }
                    }

                    if(type.equals("class java.lang.Boolean")) {
                        Boolean invoke =(Boolean) getMethod.invoke(newEntity);
                        if(invoke !=null) {
                            Method setMethod = oldEntity.getClass().getMethod("set" + name, Boolean.class);
                            setMethod.invoke(oldEntity,invoke);
                        }
                    }

                    if(type.equals("class java.sql.Timestamp")) {
                        Timestamp invoke =(Timestamp) getMethod.invoke(newEntity);
                        if(invoke !=null) {
                            Method setMethod = oldEntity.getClass().getMethod("set" + name, Timestamp.class);
                            setMethod.invoke(oldEntity,invoke);
                        }
                    }

                }
                return oldEntity;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
        }
        return (T) oldEntity;
    }

}
