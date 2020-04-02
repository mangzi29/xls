package com.xls.xc.xpy.controller;


import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.service.IUserLogService;
import com.xls.xc.xpy.vo.UserLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.controller
 * @ClassName: GlobalLogController
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 13:28
 * @Version: v1.0
 **/
@Controller
@RequestMapping("/userLog")
public class UserLogController {
    @Autowired
    IUserLogService iUserLogService;


    @RequestMapping("/getUserLog")
    public ResultEntity getUserLog(Integer logId){
        ResultEntity resultEntity = ResultEntity.getEntitySuccess();
        UserLogVo userLogVoById = iUserLogService.getUserLogVoById(logId);
        resultEntity.setData(userLogVoById);
        return resultEntity;
    }
}
