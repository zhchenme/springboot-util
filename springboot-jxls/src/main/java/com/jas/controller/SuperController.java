package com.jas.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zc
 * @description
 * @create 2018-08-12 16:55
 */
public class SuperController {

    @Autowired(required = false)
    public HttpServletRequest request;
    
    public ResponseEntity<byte[]> down(String trueName, String downLoadPath) throws Exception {
        File file = new File(downLoadPath);
        HttpHeaders headers = new HttpHeaders();
        String fileName;
        
        try {
            String userAgent = request.getHeader("User-Agent");
            
            // 判断是否为IE
            if (userAgent.toUpperCase().indexOf("MSIE") > 0 || userAgent.toUpperCase().indexOf("TRIDENT") > 0) {
                fileName = URLEncoder.encode(trueName, "UTF-8");
            } else {
                fileName = new String(trueName.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            throw new Exception("文件名转码失败", e);
        } 
        
        // 解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        
        byte[] bytes;
        
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new Exception("读取文件失败", e);
        }
        
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
