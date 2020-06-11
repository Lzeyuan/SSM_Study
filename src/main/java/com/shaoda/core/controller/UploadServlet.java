package com.shaoda.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * 文件上传对应的Servlet
 * @author LIZIEN
 * 2020.5.11
 * */
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
@Controller
public class UploadServlet {

    @RequestMapping("/upload/view")
    public String View() {
        return "file/upload";
    }

    @RequestMapping("/upload/upload")
    public String upLoad(@RequestParam("upLoadFile") CommonsMultipartFile file, HttpServletRequest request) {

        // 获取当天时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(System.currentTimeMillis());

        // 获取文件名
        String uploadFileName = file.getOriginalFilename();
        String prefix = uploadFileName.substring(0, uploadFileName.indexOf("."));
        String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        uploadFileName = date + " " + prefix + suffix;

        // 文件名为空返回上传页
        if ("".equals(uploadFileName)) {
            return "file/upload";
        }

        // System.out.println("上传文件名" + uploadFileName);

        // 上传路径
        String path = request.getServletContext().getRealPath("/upload");

        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        // 如果文件夹不存在，则新建
        realPath = new File(path + "\\" + date);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        // System.out.println("保存地址：" + realPath);

        // 文件输入流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = file.getInputStream();
            os = new FileOutputStream(new File(realPath, uploadFileName));
            int len = 0;
            byte[] buffer = new  byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "file/upload";
    }

}
