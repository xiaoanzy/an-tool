package com.an.tool.string;

import com.an.tool.array.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 安
 * @Date: 2020/06/12/16:07
 * @Description:
 */
public class StringUtil {

    ///////////////////////////// start 判断字符串空//////////////////////////////////


    /**
     * 检查字符串不能为null，可有对象可没值
     *
     * @param s
     * @return
     */
    public static boolean isNull(String s) {
        if (null == s) {
            return true;
        }
        return false;
    }

    /**
     * 检查字符串，不能有null并且不能有空格
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (null == s || s.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean isEmpty(String... s) {
        if (ArrayUtil.isNull(s)) {
            return true;
        }
        for (int i = 0; i < s.length; i++) {
            if (isEmpty(s[i])) {
                throw new NullPointerException(String.format("index %s not empty.", i));
            }
        }
        return false;
    }
    ///////////////////////////// end 判断字符串空//////////////////////////////////


    ///////////////////////////// start connect//////////////////////////////////

    /**
     * 字符串连接
     *
     * @param s
     * @param e
     * @return
     */
    public static String connect(String s, String e) {
        if (isEmpty(s)) {
            s = "";
        }
        if (isEmpty(e)) {
            e = "";
        }
        return new StringBuilder(s).append(e).toString();
    }

    /**
     * 传入数组拼接字符串
     *
     * @param s
     * @return
     */
    public static String connect(String... s) {
        if (ArrayUtil.isNotNull(s)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if (isNull(s[i])) {
                    continue;
                }
                builder.append(s[i]);
            }
            return builder.toString();
        }
        return "";
    }

    /**
     * 字符串连接
     *
     * @param s 开始字符串
     * @param e 追加字符串数组
     * @return
     */
    public static String connect(String s, String[] e) {
        if (isNull(s)) {
            s = "";
        }
        return new StringBuilder(s).append(connect(e)).toString();
    }
    ///////////////////////////// end connect//////////////////////////////////


    ///////////////////////////// start 删除文字 //////////////////////////////////

    /**
     * 按条件字符串删除指指定文字
     *
     * @param s
     * @param d
     * @return
     */
    public static String deleteString(String s, String d) {
        if (isEmpty(s)) {
            throw new NullPointerException("be exec string not null.");
        }
        return s.replace(d, "");
    }

    /**
     * 按字符串数组删除指定文字
     *
     * @param s
     * @param d
     * @return
     */
    public static String deleteString(String s, String[] d) {
        if (ArrayUtil.isNull(d)) {
            throw new NullPointerException("filter string not null.");
        }
        for (int i = 0; i < d.length; i++) {
            s = deleteString(s, d[i]);
        }
        return s;
    }


    ///////////////////////////// end 删除文字//////////////////////////////////


    public static void main(String[] args) {

        System.out.println(deleteString("qwsdsafasfews", "q"));
        System.out.println(deleteString("qwsdsafasfews", new String[]{"w", "f", "q", "a", "s"}));
    }
}
