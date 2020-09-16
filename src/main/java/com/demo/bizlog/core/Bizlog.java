package com.demo.bizlog.core;

import com.demo.bizlog.bean.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Bizlog {

    public static Logger getLogger(Class<?> clazz) { return LoggerFactory.getLogger(clazz); }

    public static Logger getLogger(String logName) {
        return LoggerFactory.getLogger(logName);
    }

    public abstract void info(String msg);

    public abstract void warn(String msg);

    public abstract void error(String msg);

    public abstract void processLog(Log log);

}
