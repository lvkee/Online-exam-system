package com.sy.viewmodel.admin.question;

import com.sy.base.BasePage;


public class QuestionPageRequestVM extends BasePage {

    private Integer id;
    private Integer level;
    private Integer subjectId;
    private Integer questionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "QuestionPageRequestVM{" +
                "id=" + id +
                ", level=" + level +
                ", subjectId=" + subjectId +
                ", questionType=" + questionType +
                ", pageIndex=" + getPageIndex() +
                ", pageSize=" + getPageSize() +
                '}';
    }
}
