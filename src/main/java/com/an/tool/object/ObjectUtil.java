package com.an.tool.object;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 安
 * @Date: 2020/05/09/17:13
 * @Description:
 */
public class ObjectUtil {


    /**
     * 校验对象参数为空
     *
     * @param obj
     * @return
     */
    public static boolean isObjectEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Integer) {
            return (Integer) obj == 0;
        }
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isObjectEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * 不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotObjectEmpty(Object obj) {
        return !isObjectEmpty(obj);
    }
}
