package com.ehualu.rise.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.property.PropertyConfig;


@Controller
@AuthClass("login")
@RequestMapping("/admin/upload")
public class UploadController {

	private static final Logger logger = Logger.getLogger(UploadController.class);
	
    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public String image(
            HttpServletRequest request,
            HttpSession session,
            @RequestParam("filedata") MultipartFile file) throws Exception {
 
        // 将图片按日期分开存放，方便管理
    	Date date = new Date();
    	String path_segment = PropertyConfig.getProperty("UPLOAD_FILE") + new SimpleDateFormat("yyyyMMdd").format(date);
    	
        // 存放到web根目录下,如果日期目录不存在，则创建,
        // 注意 request.getRealPath("/") 已经标记为不推荐使用了.
        final String path = session.getServletContext().getRealPath("/") + path_segment;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        logger.info(path);
 
        // 以下是真正的上传部分
        String error = "";
        // 取得原文件名
        String originName = file.getOriginalFilename();
        // 取得文件后缀
        String fileExt = originName.substring(originName.lastIndexOf(".") + 1);
        // 按时间戳生成图片文件名
        String picture = new SimpleDateFormat("yyyyMMddHHmmss").format(date) + "."+ fileExt;
        try {
 
            IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(dir, picture)));
 
        } catch (Exception e) {
            logger.error("error:", e);
            error = e.getMessage();
        }
        //upload/images/2012/11_09/20121109223012.jpg
        String url = request.getContextPath()+path_segment + "/" + picture;
        // 将图片路径按xheditor要求的json格式字符串返回
        return "{\"err\":\"" + error + "\",\"msg\":\"" + url + "\"}";
    }
}
