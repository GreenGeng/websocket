package com.learnbyheart.demo1.pojo;

import lombok.Data;

@Data
public class Result {
    //用于登陆响应回给浏览器的数据

    private boolean flag;
    private String msg;
}
