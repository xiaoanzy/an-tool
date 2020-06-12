package com.an.tool.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 安
 * @Date: 2020/06/12/16:23
 * @Description:
 */
public class ArrayUtil {


    public static <A> boolean isNull(A... arr) {
        if (null == arr) {
            return true;
        }
        return false;
    }


    public static <A> boolean isNotNull(A... arr) {
        return !isNull(arr);
    }
}
