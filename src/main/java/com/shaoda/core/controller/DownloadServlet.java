package com.shaoda.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

/**
 * 文件下载对应的Servlet
 * @author LIZIEN
 * 2020.5.11
 * */

@Controller
public class DownloadServlet {

    @RequestMapping("/download/view")
    public String View() {
        return "file/download";
    }

    @RequestMapping("/download/download")
    public String Download(String file, HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file = URLEncoder.encode(request.getParameter("filename"),"utf-8").replace("+", " ");

            //动态获取服务器的路径
            String time = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            String path = request.getServletContext().getRealPath("upload") + "/" + time + "/" + file;

            //页面输出流
            FileInputStream fis = new FileInputStream(path);
            response.setHeader("Content-Disposition", "attachment; filename=" + file);


            byte[] bt = new byte[1024];
            int length = 0;
            while ((length = fis.read(bt)) != -1) {
                out.write(bt, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "file/download";
    }
}