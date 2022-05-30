package com.sy.viewmodel.admin.file;

import com.sy.base.BasePage;

/**
 * @author chris
 * @date 2022/05/29
 */
public class FilePageRequestVM extends BasePage {

    private Integer id;

    private String fType;

    private String fileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
