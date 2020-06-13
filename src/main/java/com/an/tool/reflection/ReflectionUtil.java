package com.an.tool.reflection;


import com.an.tool.object.ObjectUtil;
import com.an.tool.test.TestUser;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 安
 * @Date: 2020/06/13/11:20
 * @Description:
 */
public class ReflectionUtil {


    /**
     * 获取对象路径
     *
     * @param c
     * @return
     */
    public static String getName(Class<?> c) {
        if (ObjectUtil.isNull(c)) {
            throw new NullPointerException("object not null.");
        }
        return c.getName();
    }

    public static void ddwqdwq(Class<?> c) {
        String name = getName(c);
        //  Class.forName(name).newInstance();
    }

    public static <T> T newInstance(Class<T> c) {
        T t = null;
        try {
            t = (T) Class.forName(getName(c)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T toObject(Map<String, Object> m, Class<T> c) {
        T t = null;
        int i = 0;
        //      Field[] fields = c.getDeclaredFields();
        T t1 = null;
        try {
            t1 = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                Field field = c.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(t1, entry.getValue());
                i++;
            }
            t = (T) c.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static Map<String, Object> toMap(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(o));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static void main(String[] args) throws Exception {
        TestUser testUser = new TestUser();
        testUser.setCode(12);
        testUser.setMessage("dsadsad");
        testUser.setData(new HashMap<>());

        Map<String, Object> toMap = toMap(testUser);
        System.out.println(toMap);
        TestUser toObject = toObject(toMap, TestUser.class);
        System.out.println(toObject);
        System.out.println(toMap(toObject));
    }
}
