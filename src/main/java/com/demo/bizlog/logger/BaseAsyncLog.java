package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseAsyncLog {

    private static final Logger logger = LoggerFactory.getLogger(BaseAsyncLog.class);

    private ScheduledExecutorService executor;

    final void init() {
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::process, 1, 1, TimeUnit.SECONDS);
        onInit();
    }

    final void destroy() {
        process();
        if (executor != null) {
            executor.shutdownNow();
        }
        onDestroy();
    }

    private List<Log> buffer = new CopyOnWriteArrayList<>();

    private ReentrantLock lock = new ReentrantLock();

    final void process() {
        if (lock.tryLock()) {
            try {
                //此处存在同步问题，须用迭代器
                Iterator<Log> its = buffer.iterator();
                Log log;
                while (its.hasNext()) {
                    try {
                        log = its.next();
                        onProcess(log);
                    } catch (Exception ex) {
                        logger.error("AsyncLog processing failure");
                    }
                }
                this.onflush();
            } finally {
                buffer.clear();
                lock.unlock();
            }
        }
    }

    final void add(Log log) {
        buffer.add(log);
        if (buffer.size() >= 1) {
            process();
        }
    }

    protected abstract void onProcess(Log log);

    protected abstract void onInit();

    protected abstract void onDestroy();

    protected abstract void onflush();

}
