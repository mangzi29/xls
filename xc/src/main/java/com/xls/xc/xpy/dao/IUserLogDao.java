package com.xls.xc.xpy.dao;


import com.xls.xc.xpy.vo.UserLogVo;

/**
 * @ProjectName: xc(星辰)
 * @PackageName: com.xls.xpy.dao
 * @InterfaceName: IUserLogDao
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 13:32
 * @Version: v1.0
 **/
public interface IUserLogDao {
    /**
     * 查询实体
     * @param id
     * @return
     */
    UserLogVo getUserLogVoById(Integer id) throws Exception;

    /**
     * 增加一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    Integer saveUserLogVo(UserLogVo userLogVo) throws Exception;

    /**
     * 修改一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    void updateUserLogVo(UserLogVo userLogVo) throws Exception;

    /**
     * 删除一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    void deleteUserLogVo(UserLogVo userLogVo) throws Exception;
}
