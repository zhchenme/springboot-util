package com.jas.util;

import net.sf.jxls.transformer.XLSTransformer;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * @author zc
 * @description jxls 工具类
 * @create 2018-08-12 16:19
 */
public class JxlsUtils {
    public static final String TEMPLATE_PATH = "E:\\workspace\\springboot-jxls\\src\\main\\resources\\templates\\export\\template";
    public static final String SAVE_PATH = "E:\\workspace\\springboot-jxls\\src\\main\\resources\\templates\\export\\temp";

    private JxlsUtils(){}
    
    /**
     *  导出 Excel
     * 
     * @param source 模板文件路径
     * @param target 目标文件（文件下载时的路径）
     * @param beansMaps
     * @return 下载文件路径
     * @throws Exception
     */
    public static String export(String source, String target, Map<String, Object> beansMaps) throws Exception {
        String[] sourceArrays = source.split("\\.");
        source = TEMPLATE_PATH + File.separator + source;
        target = SAVE_PATH + File.separator + sourceArrays[0] + "-" + System.currentTimeMillis() + "." + sourceArrays[1];
        File file = new File(SAVE_PATH);
        
        if (!file.exists()) {
            file.mkdir();
        }
                
        XLSTransformer transformer = new XLSTransformer();
        
        transformer.transformXLS(source, beansMaps, target);
        
        return target;
    }

    /**
     * 存储导入模板文件
     *
     * @param file         模板文件对象
     * @param templateName 模板文件名
     * @return 文件存储路径
     */
    public static String uploadTemplate(MultipartFile file, String templateName) throws Exception {
        File targetFile = template(templateName);
        saveFile(file, targetFile);
        return targetFile.getAbsolutePath();
    }

    /**
     * 模板文件对象
     *
     * @param templateName 模板名称
     * @return File 对象
     */
    public static File template(String templateName) {
        return new File(TEMPLATE_PATH, templateName);
    }

    /**
     * 根据模板名称获取模板路径
     *
     * @param templateName
     * @return String
     */
    public static String getTemplatePath(String templateName) {
        return template(templateName).getAbsolutePath();
    }

    /**
     * 文件存储
     * 
     * @param file       原始文件对象
     * @param targetFile 文件存储对象
     */
    private static void saveFile(MultipartFile file, File targetFile) throws Exception {
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        file.transferTo(targetFile);
    }

    /**
     * 文件存储
     * 
     * @param file 临时文件对象
     * @return String
     */
    public static String uploadTemp(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        File targetFile = new File(SAVE_PATH, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        
        file.transferTo(targetFile);
        return targetFile.getAbsolutePath();
    }
}