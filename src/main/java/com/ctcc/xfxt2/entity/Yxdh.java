package com.ctcc.xfxt2.entity;

public class Yxdh {

    private String yxdh;

    private String yxmc;

    private String yxdm;

    private Integer dydm;

    private String jhsxdm;

    public Yxdh(String yxdh, String yxmc, String yxdm, Integer dydm, String jhsxdm) {
        this.yxdh = yxdh;
        this.yxmc = yxmc;
        this.yxdm = yxdm;
        this.dydm = dydm;
        this.jhsxdm = jhsxdm;
    }

    public Yxdh() {
        super();
    }

    public String getYxdh() {
        return yxdh;
    }

    public void setYxdh(String yxdh) {
        this.yxdh = yxdh == null ? null : yxdh.trim();
    }

    public String getYxmc() {
        return yxmc;
    }

    public void setYxmc(String yxmc) {
        this.yxmc = yxmc == null ? null : yxmc.trim();
    }

    public String getYxdm() {
        return yxdm;
    }

    public void setYxdm(String yxdm) {
        this.yxdm = yxdm == null ? null : yxdm.trim();
    }

    public Integer getDydm() {
        return dydm;
    }

    public void setDydm(Integer dydm) {
        this.dydm = dydm;
    }

    public String getJhsxdm() {
        return jhsxdm;
    }

    public void setJhsxdm(String jhsxdm) {
        this.jhsxdm = jhsxdm == null ? null : jhsxdm.trim();
    }
}