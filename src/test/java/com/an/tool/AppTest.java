package com.an.tool;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void dwqn() {
        System.out.println(JSON.toJSONString(new User()));
    }
}
