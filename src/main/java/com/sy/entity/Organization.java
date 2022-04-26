package com.sy.entity;

import java.util.Date;
import java.util.List;

public class Organization {

    private int oId;

    private String oName;

    private Date oCreateDate;

    private Date oLastUpdate;

    private List<Teacher> teacherList;

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public Date getoCreateDate() {
        return oCreateDate;
    }

    public void setoCreateDate(Date oCreateDate) {
        this.oCreateDate = oCreateDate;
    }

    public Date getoLastUpdate() {
        return oLastUpdate;
    }

    public void setoLastUpdate(Date oLastUpdate) {
        this.oLastUpdate = oLastUpdate;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
