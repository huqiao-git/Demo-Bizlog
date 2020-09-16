package com.demo.bizlog.logger;

import com.demo.bizlog.bean.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jLogger implements ILogger {

    private static final Logger logger = LoggerFactory.getLogger(Log4jLogger.class);

    @Override
    public void process(Log log) {
        String msg = log.getMsg();
        if(log.getMsg().isEmpty()) {
            return;
        }
        if (log.getLog_level() == Log.LogLevelConst.INFO) {
            logger.info(msg);
        } else if (log.getLog_level() == Log.LogLevelConst.WARN) {
            logger.warn(msg);
        } else if (log.getLog_level() == Log.LogLevelConst.ERROR) {
            logger.error(msg);
        } else {
            logger.debug(msg);
        }
    }

    @Override
    public void start() { }

    @Override
    public void stop() { }

}
