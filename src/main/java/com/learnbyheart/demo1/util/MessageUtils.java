package com.learnbyheart.demo1.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnbyheart.demo1.pojo.ResultMsg;

public class MessageUtils {
    public static String getMsg(boolean isSystemMsg,String fromName,Object msg){


        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setMsg(msg);
        resultMsg.setSystem(isSystemMsg);
        if(fromName!=null) {
            resultMsg.setFromName(fromName);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(resultMsg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
