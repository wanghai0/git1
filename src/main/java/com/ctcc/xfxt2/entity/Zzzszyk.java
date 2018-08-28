package com.ctcc.xfxt2.entity;

import java.util.Date;

public class Zzzszyk {

    private String ksh;

    private String yxdh;

    private String zydh1;

    private String zydh2;

    private String zydh3;

    private String zydh4;

    private String zydh5;

    private String zydh6;

    private String fcbj;

    private Date inputtime;

    private String digest;

    private Integer status;

    public Zzzszyk(String ksh, String yxdh, String zydh1, String zydh2, String zydh3, String zydh4, String zydh5,
            String zydh6, String fcbj, Date inputtime, String digest, Integer status) {
        this.ksh = ksh;
        this.yxdh = yxdh;
        this.zydh1 = zydh1;
        this.zydh2 = zydh2;
        this.zydh3 = zydh3;
        this.zydh4 = zydh4;
        this.zydh5 = zydh5;
        this.zydh6 = zydh6;
        this.fcbj = fcbj;
        this.inputtime = inputtime;
        this.digest = digest;
        this.status = status;
    }

    public Zzzszyk() {
        super();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getYxdh() {
        return yxdh;
    }

    public void setYxdh(String yxdh) {
        this.yxdh = yxdh == null ? null : yxdh.trim();
    }

    public String getZydh1() {
        return zydh1;
    }

    public void setZydh1(String zydh1) {
        this.zydh1 = zydh1 == null ? null : zydh1.trim();
    }

    public String getZydh2() {
        return zydh2;
    }

    public void setZydh2(String zydh2) {
        this.zydh2 = zydh2 == null ? null : zydh2.trim();
    }

    public String getZydh3() {
        return zydh3;
    }

    public void setZydh3(String zydh3) {
        this.zydh3 = zydh3 == null ? null : zydh3.trim();
    }

    public String getZydh4() {
        return zydh4;
    }

    public void setZydh4(String zydh4) {
        this.zydh4 = zydh4 == null ? null : zydh4.trim();
    }

    public String getZydh5() {
        return zydh5;
    }

    public void setZydh5(String zydh5) {
        this.zydh5 = zydh5 == null ? null : zydh5.trim();
    }

    public String getZydh6() {
        return zydh6;
    }

    public void setZydh6(String zydh6) {
        this.zydh6 = zydh6 == null ? null : zydh6.trim();
    }

    public String getFcbj() {
        return fcbj;
    }

    public void setFcbj(String fcbj) {
        this.fcbj = fcbj == null ? null : fcbj.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}