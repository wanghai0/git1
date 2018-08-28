package com.ctcc.xfxt2.entity;

public class TdDy {

    private String dydm;

    private String dymc;

    private Integer type;

    public TdDy(String dydm, String dymc, Integer type) {
        this.dydm = dydm;
        this.dymc = dymc;
        this.type = type;
    }

    public TdDy() {
        super();
    }

    public String getDydm() {
        return dydm;
    }

    public void setDydm(String dydm) {
        this.dydm = dydm == null ? null : dydm.trim();
    }

    public String getDymc() {
        return dymc;
    }

    public void setDymc(String dymc) {
        this.dymc = dymc == null ? null : dymc.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}