package com.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.learn.dto.CommonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author XieWei
 * @Description EmailService接口
 * @Created Date 2019/9/24 12:01
 **/
public interface FileUploadService {
    /** 文件上传，分为正文图片和附件，type=0正文图片，type=1附件 **/
    CommonResult fileUpload(MultipartFile[] files, Integer type);
}
