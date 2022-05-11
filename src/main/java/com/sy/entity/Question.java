package com.sy.entity;

import java.sql.Date;

/**
 * @author chris
 */
public class Question {

    private int id;

    private int questionType;

    private int subjectId;

    private int score;

    private int gradeLevel;

    private String correct;

    private int infoTextContent;

    private int createUser;

    private boolean deleted;

    private int status;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public int getInfoTextContent() {
        return infoTextContent;
    }

    public void setInfoTextContent(int infoTextContent) {
        this.infoTextContent = infoTextContent;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionType=" + questionType +
                ", subjectId=" + subjectId +
                ", score=" + score +
                ", gradeLevel=" + gradeLevel +
                ", correct='" + correct + '\'' +
                ", infoTextContent=" + infoTextContent +
                ", createUser=" + createUser +
                ", deleted=" + deleted +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
