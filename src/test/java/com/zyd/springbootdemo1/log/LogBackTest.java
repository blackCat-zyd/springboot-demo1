package com.zyd.springbootdemo1.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
    /**
     * 日志记录器对象
     */
    private static final Logger LOGGER= LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void testQuick() throws Exception{
        /*默认级别为info*/
        LOGGER.info("info");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
        //使用占位符输出日志信息
        String name="fei";
        Integer age=20;
        LOGGER.info("用户信息为--->姓名：{},年龄：{}",name,age);
    }
}
