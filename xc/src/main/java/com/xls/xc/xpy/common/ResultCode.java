package com.xls.xc.xpy.common;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.entity
 * @ClassName: ResultCode
 * @Description: 状态码
 * @Author: SkyChen
 * @Create: 2020-03-31 14:44
 * @Version: v1.0
 **/
public interface ResultCode {


    /**
     * 成功状态吗
     */
    int SUCCESS = 200;



    /**
     * 失败
     */
    int FAIL = 400;


    /**
     * 参数异常
     */
    int PARAM_ERROR = 1001;


}
