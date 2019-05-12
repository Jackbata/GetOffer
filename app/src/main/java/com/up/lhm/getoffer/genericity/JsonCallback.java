package com.up.lhm.getoffer.genericity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lianghaimiao
 * @date 2019/4/19
 * @function
 */

public class JsonCallback<T> implements Convert<T> {
    @Override
    public T back() {
        T t = null;
        try {
            Type genType = getClass().getGenericSuperclass();
            //从上述的类中取出真实的泛型参数
            if (genType == null && !(genType instanceof ParameterizedType)) {
                return null;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Type type = params[0];
System.out.print(type.toString());
        } catch (Exception e) {

        }
        return t;
    }
}
