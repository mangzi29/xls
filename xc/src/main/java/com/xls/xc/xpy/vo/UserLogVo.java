package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.config
 * @ClassName: UserLog
 * @Description: 用户日志操作实体类
 * @Author: SkyChen
 * @Create: 2020-03-30 23:58
 * @Version: v1.0
 **/
@Entity
@Table(name = "user_log_vo")
public class UserLogVo extends BaseObject<UserLogVo> implements Serializable {
    /**
     * 日志ID
     */
    @Id
    @GeneratedValue
    @Column(name = "log_id")
    private int logId;

    /**
     * 日志编号
     */
    @Column(name = "log_no")
    private String logNo;


    /**
     * 日志编码
     */
    @Column(name = "log_code")
    private String logCode;

    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Timestamp createTime; /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 记录内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作用户IP
     */
    @Column(name = "ip")
    private String ip;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
}
