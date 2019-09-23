package com.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.learn.dto.CommonResult;

/**
 * @Author XieWei
 * @Description 发送邮件Service
 * @Created Date 2019/9/23 12:12
 **/
public interface EmailService {
    /** 发送邮件 **/
    CommonResult sendEmail(String json);
}
