package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class AsyncLogger implements ILogger {

    private static final Logger logger = LoggerFactory.getLogger(Log4jLogger.class);

    private BlockingQueue<Log> logQueue = new ArrayBlockingQueue<>(4000);

    private BaseAsyncLog baseAsyncLog;

    @Override
    public void process(Log log) {
        if (!logQueue.offer(log)) {
            logger.info("Asynchronous log queue limits");
        }
    }

    @Override
    public void start() {
        this.baseAsyncLog.init();
        new Thread(() -> {
            while (true) {
                try {
                    Log log = logQueue.poll(1, TimeUnit.SECONDS);
                    if (log == null) {
                        baseAsyncLog.process();
                    } else if (log.equals(POISON)) {
                        baseAsyncLog.destroy();
                        return;
                    } else {
                        baseAsyncLog.add(log);
                    }
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        logQueue.offer(POISON);
    }

    private static final Log POISON = POISON();

    private static Log POISON() {
        Log log = new Log();
        log.setLog_id(-1L);
        return log;
    }

    public void setBaseAsyncLog(BaseAsyncLog baseAsyncLog) {
        this.baseAsyncLog = baseAsyncLog;
    }
}
