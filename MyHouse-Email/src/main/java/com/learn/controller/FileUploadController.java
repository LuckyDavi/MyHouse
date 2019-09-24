package com.learn.controller;

import com.learn.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author XieWei
 * @Description 文件上传
 * @Created Date 2019/9/23 17:37
 **/

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping(value = "/fileUpload",method =RequestMethod.POST)
    public Object fileUpload( @RequestParam("files") MultipartFile[] files,Integer type) {
        return fileUploadService.fileUpload(files,type);
    }

}
