package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;

public class AsyncLogImpl2 extends BaseAsyncLog {

    @Override
    public void onProcess(Log log) {
        System.out.println("AsyncLogDemo - 2");
    }

    @Override
    public void onInit() {
        System.out.println("AsyncLogImpl2 - Init");
    }

    @Override
    public void onDestroy() {
        System.out.println("AsyncLogImpl2 - Destroy");
    }

    @Override
    public void onflush() { }
}
