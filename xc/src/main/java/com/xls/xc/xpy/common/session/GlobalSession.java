package com.xls.xc.xpy.common.session;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.config
 * @ClassName: GlobalSession
 * @Description: 全局Session
 * @Author: SkyChen
 * @Create: 2020-03-30 23:47
 * @Version: v1.0
 **/
public class GlobalSession {
    /**
     * session前缀
     */
    private static String prefix = "xc_";

    /**
     * session对象
     */
    private static Session session = SecurityUtils.getSubject().getSession();

    /**
     * 获取session中的用户ID
     * @return
     */
    public static int getUserId() {

        return (Integer) session.getAttribute(prefix + "userId");
    }

    /**
     * 设置session中的用户ID
     * @param userId
     */
    public static void setUserId(int userId) {
        session.setAttribute(prefix + "userId", userId);
    }

    /**
     * 获取session中的用户ID
     * @return
     */
    public static String getUserName() {

        return (String) session.getAttribute(prefix + "userName");
    }

    /**
     * 设置session中的用户名称
     * @param userName
     */
    public static void setUserName(String userName) {
        session.setAttribute(prefix + "userName", userName);
    }
}
