package com.xls.xc.xpy;


import com.xls.xc.xpy.common.log.GlobalLog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls
 * @ClassName: GlobalLogTest
 * @Description: GlobalLogTest测试
 * @Author: SkyChen
 * @Create: 2020-03-31 13:20
 * @Version: v1.0
 **/

//web请求容器 这里需要模拟请求
@WebAppConfiguration
//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
//@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class GlobalLogRequestTest {
    @Autowired
    WebApplicationContext context;

    @Autowired
    GlobalLog globalLog;

    //虚拟MVC请求，获取得到处理结果 创建是根据此前获得的IOC容器对象创建
    MockMvc mvc;
    @Before
    public void initMockMvc(){
        mvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception{
        //发起一次请求    andReturn返回的结果
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get("/userLog/getUserLog").param("id","1")).andReturn();
        MockHttpServletRequest request = mvcResult.getRequest();
        Object message = request.getAttribute("data");
        System.out.println(message);
        globalLog.log("ddd",request);


    }

}
