package com.zhu.practice.common.domain.response;

import com.zhu.practice.common.domain.enums.ErrorEnum;
import lombok.Data;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
@Data
public class RES<T> {

    private Boolean success;

    private Integer errCode;

    private String errMsg;

    private T data;

    public static <T> RES<T> success() {
        RES<T> result = new RES<T>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> RES<T> success(T data) {
        RES<T> result = new RES<T>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> RES<T> fail(Integer code, String msg) {
        RES<T> result = new RES<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(code);
        result.setErrMsg(msg);
        return result;
    }

    public static <T> RES<T> fail(ErrorEnum errorEnum) {
        RES<T> result = new RES<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(errorEnum.getErrorCode());
        result.setErrMsg(errorEnum.getErrorMsg());
        return result;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
