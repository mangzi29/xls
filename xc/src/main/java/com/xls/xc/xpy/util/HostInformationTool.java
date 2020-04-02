package com.xls.xc.xpy.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.util
 * @ClassName: HostInformationTool
 * @Description: 主机信息工具类
 * @Author: SkyChen
 * @Create: 2020-03-30 23:34
 * @Version: v1.0
 **/
public class HostInformationTool {

     private final static Logger logger = LoggerFactory.getLogger(HostInformationTool.class);

    /**
     * 获取请求的Ip地址
     * @param request
     * @return
     */
    public static String getAddressIP(HttpServletRequest request) throws Exception{
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                //Based on the IP network card in the machine configuration
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    logger.info("HostInformationTool.getAddressIP Error: ",e.toString());
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //在通过多个代理的情况下,第一个真正的IP IP为客户,多个IP依照“,”分割,"***.***.***.***".length()
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取当前时间
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
