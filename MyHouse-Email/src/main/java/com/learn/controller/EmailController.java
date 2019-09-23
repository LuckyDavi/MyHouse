package com.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.dto.CommonResult;
import com.learn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author XieWei
 * @Description 邮件controller
 * @Created Date 2019/9/23 14:15
 **/
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailService emailService;

    /**
     * 发送邮件
     * @param json
     * @return
     * 测试用例：
        {
            "mailTo":"13283813740@163.com",
            "mailTittle":"Have a good day!",
            "mailText":"just happy!",
            "type":1
        }
     */
    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public CommonResult sendEmail(@RequestBody String json){
        if(json==null || "".equals(json)){
            return new CommonResult().failed("参数为空");
        }
        return emailService.sendEmail(json);
    }
}
