package com.xls.xc.xpy.service;


import com.xls.xc.xpy.vo.UserLogVo;

/**
 * @ProjectName: xc(星辰)
 * @PackageName: com.xls.xpy.service.impl
 * @InterfaceName: IGlobalLogService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 13:30
 * @Version: v1.0
 **/
public interface IUserLogService {
    /**
     * 查询实体
     * @param logId
     * @return
     */
    UserLogVo getUserLogVoById(Integer logId);

    /**
     * 增加一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    UserLogVo saveUserLogVo(UserLogVo userLogVo);

    /**
     * 修改一个UserLogVo实体
     * @param newUserLogVo
     * @return
     */
    UserLogVo updateUserLogVo(UserLogVo newUserLogVo);

    /**
     * 删除一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    boolean deleteUserLogVo(UserLogVo userLogVo);
}
