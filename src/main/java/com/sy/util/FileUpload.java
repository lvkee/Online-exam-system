package com.sy.util;

import com.sy.entity.FileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件上传 ajax 方式
 */
public class FileUpload {
    private static Logger logger = LoggerFactory.getLogger(FileUpload.class);

    //本地路径
    public static final String FILE_URL = "/Users/chris/Documents/project/javaEE_SSM/src/main/webapp/admin/file";

//    public static final String FILE_URL = Constants.BASE_FILE_URL;    //服务器部署路径


    /**
     * 多个文件上传，循环调用单个文件上传的方法
     *
     * @param file
     * @return
     */
    public static List<FileEntity> uploadFiles(MultipartFile[] file) {
        //一起一档的文件目录是 基础目录
        String fileFolder = FILE_URL;
        List<FileEntity> fileList = new ArrayList<>();
        File isFolder = new File(fileFolder);
        if (!isFolder.exists()) {
            isFolder.mkdirs();
        }

        for (MultipartFile multipartFile : file) {
            fileList.add(uploadFile(multipartFile, fileFolder));
        }
        return fileList;
    }

    /**
     * 上传文件(单个)
     * 1.Constants.LOCAL_FILE_URL 是本地文件存储路径，部署要换成 Constants.BASE_FILE_URL
     * 2.jsp 表单提交的时候要设置 method="post" enctype="multipart/form-data"
     * 3.要在 springmvc 中有对上传文件的大小做限制
     * 4.要考虑传递过来的是多个文件问题，暂时没有实现
     *
     * @param upFile     页面传过来的文件
     * @param fileFolder 上传文件的全路径
     * @return 文件对象
     */
    public static FileEntity uploadFile(MultipartFile upFile, String fileFolder) {
        //定义返回对象，返回文件对象
        FileEntity f = new FileEntity();
        if (upFile.getSize() > 0) {
            // 得到文件的原始名称，如：美女.png
            String fileName = upFile.getOriginalFilename();
            File file = new File(fileFolder, fileName);
            try {
                System.out.println("file : " + file.toString());
                // 读取 upFile、写入为 file
                upFile.transferTo(file);
                //文件下载路径，服务器路径
                String fileRoute = "/admin/file/" + fileName;
                f.setFileAdd(fileRoute);
                //文件名
                f.setFileName(fileName);
                //后缀
                f.setSuffix(fileName.substring(fileName.lastIndexOf(".") + 1));
                //文件类型
                f.setfType(getType(fileName.substring(fileName.lastIndexOf(".") + 1)));
//                文件创建时间
                f.setCreateTime(new Date());
                System.out.println("f : " + f.getFileAdd());
                return f;
            } catch (IOException e) {
                e.printStackTrace();
                logger.debug("上传文件失败");
            }
        }
        return null;
    }

    /**
     * 根据文件后缀判断文件类型
     *
     * @param name
     * @return
     */
    public static String getType(String name) {
        if ("pdf".equals(name)) {
            return "pdf";
        } else if ("excel".equals(name)) {
            return "excel";
        } else if ("xls".equals(name)) {
            return "excel";
        } else if ("xlsx".equals(name)) {
            return "excel";
        } else if ("docx".equals(name)) {
            return "word";
        } else if ("doc".equals(name)) {
            return "word";
        } else if ("png".equals(name)) {
            return "png";
        } else if ("jpg".equals(name)) {
            return "png";
        } else if ("jpeg".equals(name)) {
            return "png";
        } else if ("rar".equals(name)) {
            return "zip";
        } else if ("ppt".equals(name)) {
            return "ppt";
        } else if ("pptx".equals(name)) {
            return "ppt";
        } else {
            return "txt";
        }
    }
}