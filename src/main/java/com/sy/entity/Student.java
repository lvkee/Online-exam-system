package com.sy.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 实验十 1. 创建一个实体类 之后所有步骤的方法名和对应参数名根据你的实体修改
 * 2. @NotBlank... 为数据验证
 * @author chris
 */
public class Student {

    private int sId;
    @NotBlank
    @Size(max = 20,min = 5)
    private String sName;
    @NotBlank
    @Size(max = 20)
    private String sNickname;
    @NotNull
    private String sPwd;
    @NotNull
    private String sEmail;

    private Date sCreateDate;

    private Date sUpdateDate;
    @NotNull
    private Date sBirth;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNickname() {
        return sNickname;
    }

    public void setsNickname(String sNickname) {
        this.sNickname = sNickname;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Date getsCreateDate() {
        return sCreateDate;
    }

    public void setsCreateDate(Date sCreateDate) {
        this.sCreateDate = sCreateDate;
    }

    public Date getsUpdateDate() {
        return sUpdateDate;
    }

    public void setsUpdateDate(Date sUpdateDate) {
        this.sUpdateDate = sUpdateDate;
    }

    public Date getsBirth() {
        return sBirth;
    }

    public void setsBirth(Date sBirth) {
        this.sBirth = sBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sNickname='" + sNickname + '\'' +
                ", sPwd='" + sPwd + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sCreateDate=" + sCreateDate +
                ", sUpdateDate=" + sUpdateDate +
                ", sBirth=" + sBirth +
                '}';
    }
}
