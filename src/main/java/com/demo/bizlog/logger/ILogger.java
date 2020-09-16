package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;

public interface ILogger {

    void process(Log log);

    void start();

    void stop();

}
