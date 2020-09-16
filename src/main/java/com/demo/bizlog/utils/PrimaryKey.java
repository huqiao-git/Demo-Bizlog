package com.demo.bizlog.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimaryKey {

    private static AtomicInteger ai = new AtomicInteger();

    public static long generatePk() {
        if (ai.get() <= 0) {
            ai.set(1);
        }
        return System.currentTimeMillis() + ai.getAndIncrement();
    }

}
