package com.xls.xc.xpy.common;

import org.apache.commons.collections.MapUtils;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.entity
 * @ClassName: ReturnEntity
 * @Description: 返回实体类
 * @Author: SkyChen
 * @Create: 2020-03-31 14:34
 * @Version: v1.0
 **/
public class ResultEntity {

    public static final int SUCCESS = ResultCode.SUCCESS;
    public static final int ERROR = ResultCode.FAIL;

    private int code;
    private String message;
    private String url;
    private Object data;



    public ResultEntity() { }


    public ResultEntity(int code, String message, String url, Object data) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.url = url;
    }

    /**
     * 无实参 返回结果空实体对象
     * @return
     */
    public static ResultEntity createResultEntity(){
        return new ResultEntity();
    }

    /**
     * 有实参 返回结果空实体对象
     * @return
     */
    public static ResultEntity createResultEntity(int code, String message, String url, Object data){
        return new ResultEntity(code,message,url,data);
    }

    /**
     * 无实参 快捷返回成功实体对象
     * @return
     */
    public static ResultEntity getEntitySuccess() {
        return new ResultEntity(SUCCESS, MapUtils.getString(ResultInfo.map, SUCCESS), "", "");
    }

    /**
     * 有实参 快捷返回成功实体对象
     * @return
     */
    public static ResultEntity getEntitySuccess(Object data) {
        return new ResultEntity(SUCCESS, MapUtils.getString(ResultInfo.map, SUCCESS), "", data);
    }

    /**
     * 有实参 快捷返回成功实体对象
     * @return
     */
    public static ResultEntity getEntitySuccess(String url, Object data) {
        return new ResultEntity(SUCCESS, MapUtils.getString(ResultInfo.map, SUCCESS), url, data);
    }

    /**
     * 无实参 快捷返回失败实体对象
     * @return
     */
    public static ResultEntity getEntityError() {
        return getEntityError(ERROR, MapUtils.getString(ResultInfo.map, ERROR, "服务器忙，请稍后再试！"));
    }


    /**
     * 有实参 快捷返回失败实体对象
     * @return
     */
    public static ResultEntity getEntityError(Integer errCode) {
        return getEntityError(errCode, MapUtils.getString(ResultInfo.map, errCode, "服务器忙，请稍后再试！"));
    }


    /**
     * 有实参 快捷返回失败实体对象
     * @return
     */
    public static ResultEntity getEntityError(Integer errCode, String message) {
        return new ResultEntity(errCode, message, "", "");
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
