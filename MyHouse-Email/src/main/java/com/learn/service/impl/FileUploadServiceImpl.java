package com.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.learn.dto.CommonResult;
import com.learn.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author XieWei
 * @Description TODO
 * @Created Date 2019/9/24 12:01
 **/
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${fileUpload.filepath}")
    private  String filePath;

    @Value("${fileUpload.imgPath}")
    private  String imgPath;
    /** 文件上传，分为正文图片和附件，type=0正文图片，type=1附件 **/
    @Override
    public CommonResult fileUpload(MultipartFile[] files, Integer type) {
        if (files==null || files.length==0) {
            return new CommonResult().failed("上传失败，请选择文件");
        }
        List<String> fileNames = new ArrayList<>();
        //文件名
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            fileNames.add(fileName);
        }

        String fileFolderPath = null;
        //type=0正文图片，type=1附件
        if(type == 1){
            //上传附件存放地址
            fileFolderPath = filePath;
        }else if(type == 0){
            //上传图片存放地址
            fileFolderPath = imgPath;
        }
        //项目路径
        String projectPath = System.getProperty("user.dir");
        //文件存放路径
        String fileDestination = projectPath+fileFolderPath;

        // 获取上传的文件名称，并结合存放路径，构建新的文件名称
        File filepath = new File(fileDestination);
        // 判断路径是否存在，不存在则新创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }

        try {
            for(int i=0;i<files.length;i++){
                MultipartFile file = files[i];
                String fileName = fileNames.get(i);
                file.transferTo(new File(fileDestination + File.separator + fileName));
            }
            return new CommonResult().success("上传成功");
        } catch ( IOException e) {
            e.printStackTrace();
            return new CommonResult().failed("上传失败！");
        }
    }
}
