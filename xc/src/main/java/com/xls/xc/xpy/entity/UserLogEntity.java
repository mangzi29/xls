package com.xls.xc.xpy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.entity
 * @ClassName: UserLogEntity
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 16:58
 * @Version: v1.0
 **/
public class UserLogEntity {
    /**
     * 日志编号
     */
    private int logId;

    /**
     * 记录内容
     */
    private String content;

    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Timestamp createTime;

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 操作用户IP
     */
    private String ip;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "AdminLog{" +
                "logId=" + logId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", adminName='" + userName + '\'' +
                ", adminId=" + userId +
                ", ip='" + ip + '\'' +
                '}';
    }
}
