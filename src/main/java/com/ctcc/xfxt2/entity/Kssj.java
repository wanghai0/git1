package com.ctcc.xfxt2.entity;

public class Kssj {

    private String ksh;

    private String kjh;

    private String xm;

    private String zjhm;

    public Kssj(String ksh, String kjh, String xm, String zjhm) {
        this.ksh = ksh;
        this.kjh = kjh;
        this.xm = xm;
        this.zjhm = zjhm;
    }

    public Kssj() {
        super();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getKjh() {
        return kjh;
    }

    public void setKjh(String kjh) {
        this.kjh = kjh == null ? null : kjh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm == null ? null : zjhm.trim();
    }
}