package com.xls.xc.xpy.common;


import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.entity
 * @ClassName: ResultInfo
 * @Description: 结果信息
 * @Author: SkyChen
 * @Create: 2020-03-31 16:39
 * @Version: v1.0
 **/
public class ResultInfo {

    public static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(ResultCode.SUCCESS, "操作成功");
        map.put(ResultCode.FAIL, "服务器忙，请稍后再试！");
        map.put(ResultCode.PARAM_ERROR, "参数异常");
    }
}
