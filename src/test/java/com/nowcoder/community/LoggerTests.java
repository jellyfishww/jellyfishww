package com.nowcoder.community;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void test(){
        System.out.println(logger.getName());

        logger.debug("d");
        logger.info("i");
        logger.warn("w");
        logger.error("e");
    }
}
