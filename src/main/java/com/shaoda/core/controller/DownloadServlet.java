package com.shaoda.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

/**
 * 文件下载对应的Servlet
 * @author LIZIEN
 * 2020.5.11
 * */

@Controller
public class DownloadServlet {

    @RequestMapping("/download")
    public String View() {
        return "file/download";
    }

    @RequestMapping("/download/dw")
    public String Download(String filename, HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream out = null;

        try {
            out = response.getOutputStream();
            filename = URLEncoder.encode(request.getParameter("filename"),"utf-8").replace("+", " ");

            //动态获取服务器的路径
            String time = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            String path = request.getServletContext().getRealPath("upload") + "/" + time + "/" + filename;

            //页面输出流
            FileInputStream fis = new FileInputStream(path);
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);

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
            return "file/download";
        }
    }

}