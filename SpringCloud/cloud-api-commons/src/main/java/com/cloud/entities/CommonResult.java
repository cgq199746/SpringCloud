package com.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//全参构造器
@NoArgsConstructor//空参构造器
public class CommonResult<T> {
    private Integer code ;

    private String msg;

    private T data;

    public CommonResult(Integer code,String msg){
       // this(code,msg,null);
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}
