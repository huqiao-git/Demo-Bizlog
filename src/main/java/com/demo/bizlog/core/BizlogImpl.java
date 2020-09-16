package com.demo.bizlog.core;

import com.demo.bizlog.bean.Log;
import com.demo.bizlog.logger.ILogger;
import com.demo.bizlog.utils.PrimaryKey;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class BizlogImpl extends Bizlog implements InitializingBean, DisposableBean {

    private List<ILogger> loggers;

    @Override
    public void info(String msg) {
        writeLog(Log.LogLevelConst.INFO, msg);
    }

    @Override
    public void warn(String msg) {
        writeLog(Log.LogLevelConst.WARN, msg);
    }

    @Override
    public void error(String msg) {
        writeLog(Log.LogLevelConst.ERROR, msg);
    }

    private void writeLog(int level, String msg) {
        Log log = new Log();
        log.setLog_level(level);
        log.setMsg(msg);
        this.processLog(log);
    }

    @Override
    public void processLog(Log log) {
        log.setCreate_time(new Timestamp(Calendar.getInstance().getTime().getTime()));
        log.setLog_id(PrimaryKey.generatePk());
        if (this.loggers != null) {
            for (ILogger logger : loggers) {
                logger.process(log);
            }
        }
    }

    @Override
    public void afterPropertiesSet() {
        if (this.loggers != null) {
            for (ILogger logger : loggers) {
                logger.start();
            }
        }
    }

    @Override
    public void destroy() {
        if (this.loggers != null) {
            for (ILogger logger : loggers) {
                logger.stop();
            }
        }
    }

    public List<ILogger> getLoggers()
    {
        return loggers;
    }
    public void setLoggers(List<ILogger> loggers) { this.loggers = loggers; }

}
