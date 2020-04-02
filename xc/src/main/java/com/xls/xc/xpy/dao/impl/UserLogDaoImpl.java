package com.xls.xc.xpy.dao.impl;


import com.xls.xc.xpy.common.BaseDaoHibernate4;
import com.xls.xc.xpy.dao.IUserLogDao;
import com.xls.xc.xpy.util.HostInformationTool;
import com.xls.xc.xpy.vo.UserLogVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.dao
 * @ClassName: UserLogDao
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 00:34
 * @Version: v1.0
 **/
@Repository
@Transactional(rollbackFor = {Exception.class})
public class UserLogDaoImpl extends BaseDaoHibernate4<UserLogVo> implements IUserLogDao {

    /**
     * 查询实体
     * @param id
     * @return
     */
    @Override
    public UserLogVo getUserLogVoById(Integer id) throws Exception{
        return getEntity(UserLogVo.class, id);
    }


    /**
     * 增加一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public Integer saveUserLogVo(UserLogVo userLogVo) throws Exception{
            userLogVo.setCreateTime(HostInformationTool.getCurrentTimestamp());
            Serializable serializable = saveEntity(userLogVo);
            //int a = 1/0;
            return Integer.valueOf(serializable.toString());

    }


    /**
     * 修改一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public void updateUserLogVo(UserLogVo userLogVo) throws Exception{
        userLogVo.setUpdateTime(HostInformationTool.getCurrentTimestamp());
        updateEntity(userLogVo);
    }


    /**
     * 删除一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public void deleteUserLogVo(UserLogVo userLogVo) throws Exception{
        deleteEntity(userLogVo);
    }
}
