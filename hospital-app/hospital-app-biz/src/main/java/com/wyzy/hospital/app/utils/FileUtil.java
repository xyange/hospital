package com.wyzy.hospital.app.utils;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static String getfileAbsolutePath(String filePath){
       return ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/"+filePath;
    }

    public static String getStaticPath(){
        return ClassUtils.getDefaultClassLoader().getResource("static").getPath() ;
    }







}
