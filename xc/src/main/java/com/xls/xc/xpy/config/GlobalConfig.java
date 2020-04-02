package com.xls.xc.xpy.config;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.config
 * @ClassName: GlobalConfig
 * @Description: 全局配置类
 * @Author: SkyChen
 * @Create: 2020-03-30 18:25
 * @Version: v1.0
 **/
public class GlobalConfig {

    /**
     * IP地址
     */
    private String ip;

    /**
     * 主机名
     */
    private String hostName;


    /**
     * 主域名
     */
    private String mainHost;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMainHost() {
        return mainHost;
    }

    public void setMainHost(String mainHost) {
        this.mainHost = mainHost;
    }
}
