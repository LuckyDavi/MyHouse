package com.learn.user.controller;


import com.learn.user.service.UserService;
import com.learn.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 谢为
 * @since 2019-10-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getMemberExportToExcel", method = RequestMethod.GET)
    public void getMemberExportToExcel(HttpServletResponse response) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // 文件名
        String fileName = "成员统计-" + format.format(new Date());
        // 表格名
        String sheetName = "成员统计-" + format.format(new Date());
        // 表頭名稱
        String[] headers = {"姓名", "性别", "年龄", "生日", "职业"};
        // 列寬
        Integer[] colWidths = {12, 12, 12, 24, 30};
        // 獲取表格内容
        List<List<String>> list = userService.getExportDatas();
        // 生成excel表格
        ExcelUtil.exportExcel(response, fileName, sheetName, headers, colWidths, list);
    }
}
