package com.learnbyheart.demo1.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResultMsg {
    //是不是广播 false就是给某个人返回消息
    private boolean isSystem;
    private String fromName;

    private Object msg;
}
