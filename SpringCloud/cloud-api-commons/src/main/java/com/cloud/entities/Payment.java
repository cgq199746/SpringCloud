package com.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor//全参构造器
@NoArgsConstructor//空参构造器
public class Payment implements Serializable {

    private Integer id;

    //订单号
    private String serial;

}
