package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;

public class AsyncLogImpl3 extends BaseAsyncLog {

    @Override
    public void onProcess(Log log) {
        System.out.println("AsyncLogDemo - 3");
    }

    @Override
    public void onInit() {
        System.out.println("AsyncLogImpl3 - Init");
    }

    @Override
    public void onDestroy() {
        System.out.println("AsyncLogImpl3 - Destroy");
    }

    @Override
    public void onflush() { }
}
