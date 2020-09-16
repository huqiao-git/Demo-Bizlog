package com.demo.bizlog.bean;

import java.sql.Timestamp;

public class Log {

    private Long log_id;

    private int log_level = LogLevelConst.INFO;

    private String msg;

    private Timestamp create_time;

    public Long getLog_id() { return log_id; }
    public void setLog_id(Long log_id) { this.log_id = log_id; }
    public int getLog_level() { return log_level; }
    public void setLog_level(int log_level) { this.log_level = log_level; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public Timestamp getCreate_time() { return create_time; }
    public void setCreate_time(Timestamp create_time) { this.create_time = create_time; }

    /**
     * 日志级别
     */
    public interface LogLevelConst {
        /** 提示 */
        int INFO = 1;
        /** 告警 */
        int WARN = 2;
        /** 错误 */
        int ERROR = 3;
    }

}
