package com.mapshop.net;

/**
 * Created by dongke.li on 2016/8/15.
 * 返回结果的实体类，必须和服务器返回的json字符串的字段一模一样,否则解析出错
 */
public class RetrofitResult<T> {
    private boolean success;   //是否成功
    private String errorMsg;   //错误信息
    private T data;   //数据的类型
    private int recordcount;
    private Object data2;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(int recordcount) {
        this.recordcount = recordcount;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }
}
