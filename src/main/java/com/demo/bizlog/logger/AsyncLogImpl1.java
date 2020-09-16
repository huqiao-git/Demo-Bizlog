package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;

public class AsyncLogImpl1 extends BaseAsyncLog {

    @Override
    public void onProcess(Log log) { System.out.println("AsyncLogDemo - 1"); }

    @Override
    public void onInit() { System.out.println("AsyncLogImpl1 - Init"); }

    @Override
    public void onDestroy() { System.out.println("AsyncLogImpl1 - Destroy"); }

    @Override
    public void onflush() { }
}
