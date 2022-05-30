package com.sy.entity;

import java.util.Date;

/**
 * 文件属性类
 */
public class FileEntity {

    private int id;
    //文件名称
    private String fileName;
    //文件地址
    private String fileAdd;
    //文件后缀
    private String suffix;
    //文件类型
    private String fType;
//    上传时间
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileAdd() {
        return fileAdd;
    }

    public void setFileAdd(String fileAdd) {
        this.fileAdd = fileAdd;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}