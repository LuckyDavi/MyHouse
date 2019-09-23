package com.learn.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.learn.dto.CommonResult;
import com.learn.service.EmailService;
import com.learn.utils.EmailUtil;
import org.springframework.stereotype.Service;

/**
 * @Author XieWei
 * @Description 发送邮件Service实现类
 * @Created Date 2019/9/23 12:13
 **/
@Service
public class EmailServiceImpl implements EmailService {

    /** 发送邮件 **/
    @Override
    public CommonResult sendEmail(String json) {
        String mailTo = null;
        String mailTittle = null;
        String mailText = null;
        Integer type = null;
        JSONObject result = new JSONObject();

        //解析json
        JSONObject requestJson = JSONObject.parseObject(json);
        if(requestJson.containsKey("mailTo") && requestJson.containsKey("mailTittle")
                && requestJson.containsKey("mailText") && requestJson.containsKey("type")){
            mailTo = requestJson.getString("mailTo");
            mailTittle = requestJson.getString("mailTittle");
            mailText = requestJson.getString("mailText");
            type = requestJson.getInteger("type");
        }else{
            return new CommonResult().failed("请求参数缺失！");
        }
        //发送邮件
        try{
            EmailUtil.sendEmail(mailTo,mailTittle,mailText,type);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResult().failed("邮件发送失败");
        }
        return new CommonResult().success("邮件发送成功");
    }
}
