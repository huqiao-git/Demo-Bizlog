package com.demo.bizlog;

import com.demo.bizlog.core.Bizlog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BizlogApplicationTests {

    @Autowired
    Bizlog bizlog;
    @Test
    public void contextLoads() {
        Logger log = Bizlog.getLogger(BizlogApplicationTests.class);
        log.info("DEMO1");
        log.warn("DEMO2");
        log.error("DEMO3");
        bizlog.info("B-DEMO1");
        bizlog.warn("B-DEMO2");
        bizlog.error("B-DEMO3");
    }

}

