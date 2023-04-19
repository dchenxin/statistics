package com.ruoyi.utils;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.constant.GlobalConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;


import java.io.Serializable;

/**
 * @author: gaoy
 * @description: 请在方法和代码块前添加注释
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "uniapp响应体")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回标记：成功=1，失败=0")
    private int status;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回信息")
    private String msg;

    @Getter
    @Setter
    @ApiModelProperty(value = "数据")
    private T data;

    public Boolean isOk() {
        if (status != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static <T> Result<T> ok() {
        return restResult(null, GlobalConstant.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, GlobalConstant.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, GlobalConstant.SUCCESS, msg);
    }

    public static <T> Result<T> failed() {
        return restResult(null, GlobalConstant.FAIL, null);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, GlobalConstant.FAIL, msg);
    }

    public static <T> Result<T> failed(T data) {
        return restResult(data, GlobalConstant.FAIL, null);
    }

    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, GlobalConstant.FAIL, msg);
    }

    public static <T> Result<T> failed(T data, int code, String msg) {
        return restResult(data, code, msg);
    }

    public static <T> Result<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> Result<T> restResult(T data, int status, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setStatus(status);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
