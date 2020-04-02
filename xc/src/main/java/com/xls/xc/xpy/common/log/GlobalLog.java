package com.xls.xc.xpy.common.log;


import com.xls.xc.xpy.common.BaseDaoHibernate4;
import com.xls.xc.xpy.util.HostInformationTool;
import com.xls.xc.xpy.vo.UserLogVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.config
 * @ClassName: GlobalLog
 * @Description: 全局日志配置
 * @Author: SkyChen
 * @Create: 2020-03-30 23:09
 * @Version: v1.0
 **/
@Component
public class GlobalLog extends BaseDaoHibernate4 {

    protected final Logger logger =Logger.getLogger(getClass());


    /**
     * 记录日志
     * @param content  内容
     * @param request  请求
     */
    public void log(String content,ServletRequest request) {
        try {
            String addressIP = HostInformationTool.getAddressIP((HttpServletRequest) request);
            log(content,addressIP);
        } catch (Exception e) {

        }
    }


    /**
     * 记录用户的日志
     * @param content
     * @param ip
     */
    private void log(String content, String ip) {
        int userId = 0;
        String userName = "";
        try {
            //userId = GlobalSession.getUserId();
           // userName = GlobalSession.getUserName();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.warn("User操作日志记录====: ",ex);
        }
        UserLogVo userLogVo = new UserLogVo();
        userLogVo.setUserId(userId);
        userLogVo.setUserName(userName);
        userLogVo.setContent(content);
        userLogVo.setCreateTime(HostInformationTool.getCurrentTimestamp());
        userLogVo.setIp(ip);
        logger.info("============="+userLogVo.toString());
        Serializable serializable = saveEntity(userLogVo);
        userLogVo.setLogId(Integer.valueOf(serializable.toString()));
        //commit();
    }
}
