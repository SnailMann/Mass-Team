package com.snailmann.common.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ResultVO<T> implements java.io.Serializable {

    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "数据提示信息",allowEmptyValue = true)
    private String msg;
    @ApiModelProperty(value = "传输数据",allowEmptyValue = true)
    private T data;
    

    public ResultVO(){}

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

}
