package com.ctcc.xfxt2.entity;

import java.util.Date;

public class Log {

    private Integer id;

    private Integer userId;

    private Integer opType;

    private String opContent;

    private Date opTime;

    private String status;

    public Log(Integer id, Integer userId, Integer opType, String opContent, Date opTime, String status) {
        this.id = id;
        this.userId = userId;
        this.opType = opType;
        this.opContent = opContent;
        this.opTime = opTime;
        this.status = status;
    }

    public Log() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent == null ? null : opContent.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}