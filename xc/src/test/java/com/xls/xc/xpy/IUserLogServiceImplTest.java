package com.xls.xc.xpy;


import com.xls.xc.xpy.service.IUserLogService;
import com.xls.xc.xpy.vo.UserLogVo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy
 * @ClassName: IUserLogServiceImplTest
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-01 13:19
 * @Version: v1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IUserLogServiceImplTest {
    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    IUserLogService iUserLogService;

    @Test
    public void getUserLogVoTest() {
        UserLogVo userLogVoById = iUserLogService.getUserLogVoById(1);
        logger.info(userLogVoById.goString(userLogVoById));

    }

    @Test
    public void saveUserLogVoTest() {
        UserLogVo userLogVo = new UserLogVo();
        userLogVo.setContent("测试内容三");
        UserLogVo saveUserLogVo = iUserLogService.saveUserLogVo(userLogVo);
        if (saveUserLogVo!=null) {
            logger.info(saveUserLogVo.goString(saveUserLogVo));
        }else {
            logger.info("===========================");
        }

    }


    @Test
    public void updateUserLogVoTest() {
        UserLogVo userLogVo = new UserLogVo();
        userLogVo.setLogId(1);
        userLogVo.setLogNo("20200401001");
        userLogVo.setLogCode("20200401001");
        userLogVo.setContent("测试内容一");
        userLogVo.setUserId(1);
        userLogVo.setUserName("csk");
        userLogVo.setIp("127.0.0.1");
        UserLogVo saveUserLogVo = iUserLogService.updateUserLogVo(userLogVo);
        logger.info(saveUserLogVo.goString(saveUserLogVo));
    }
}
