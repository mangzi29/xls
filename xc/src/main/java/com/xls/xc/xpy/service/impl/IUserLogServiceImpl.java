package com.xls.xc.xpy.service.impl;

import com.xls.xc.xpy.util.ObjectChangeValueTool;
import com.xls.xc.xpy.dao.IUserLogDao;
import com.xls.xc.xpy.service.IUserLogService;
import com.xls.xc.xpy.vo.UserLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.service.impl
 * @ClassName: IGlobalLogServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 13:42
 * @Version: v1.0
 **/
@Service
public class IUserLogServiceImpl implements IUserLogService {

    @Autowired
    IUserLogDao iUserLogDao;
    @Autowired
    HibernateTransactionManager transactionManager;
    /**
     * 查询实体
     * @param logId
     * @return
     */
    @Override
    public UserLogVo getUserLogVoById(Integer logId){
        UserLogVo userLogVo = null;
        try {
            userLogVo = iUserLogDao.getUserLogVoById(logId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogVo;
    }


    /**
     * 增加一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public UserLogVo saveUserLogVo(UserLogVo userLogVo) {
       try {
           Integer logId = iUserLogDao.saveUserLogVo(userLogVo);
           userLogVo.setLogId(logId);
       } catch (Exception e) {
            e.printStackTrace();
            return null;
       }
        return userLogVo;
    }


    /**
     * 修改一个UserLogVo实体
     * @param newUserLogVo
     * @return
     */
    @Override
    public UserLogVo updateUserLogVo(UserLogVo newUserLogVo) {
        UserLogVo userLogVo = null;
        try {

            UserLogVo   oldUserLogVo = iUserLogDao.getUserLogVoById(newUserLogVo.getLogId());
            userLogVo = ObjectChangeValueTool.changeAllValue(UserLogVo.class,oldUserLogVo, newUserLogVo);
            iUserLogDao.updateUserLogVo(userLogVo);
            userLogVo = iUserLogDao.getUserLogVoById(userLogVo.getLogId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogVo;
    }


    /**
     * 删除一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public boolean deleteUserLogVo(UserLogVo userLogVo) {
         try {
             iUserLogDao.deleteUserLogVo(userLogVo);
         } catch (Exception e) {

         }
        return true;
    }
}
