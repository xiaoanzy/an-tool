package com.an.tool.test;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 安
 * @Date: 2020/06/13/12:53
 * @Description:
 */
public class TestUser implements Serializable {

    int code;
    String message;
    Object data;

    Date date;
    int[] dwqdq;
    Map map;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int[] getDwqdq() {
        return dwqdq;
    }

    public void setDwqdq(int[] dwqdq) {
        this.dwqdq = dwqdq;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
