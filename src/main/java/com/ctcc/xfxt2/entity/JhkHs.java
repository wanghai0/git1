package com.ctcc.xfxt2.entity;

public class JhkHs {

    private String yxdh;

    private String yxmc;

    private String zydh;

    private String zymc;

    private String zyfx;

    private String pcdm;

    private String kldm;

    public JhkHs(String yxdh, String yxmc, String zydh, String zymc, String zyfx, String pcdm, String kldm) {
        this.yxdh = yxdh;
        this.yxmc = yxmc;
        this.zydh = zydh;
        this.zymc = zymc;
        this.zyfx = zyfx;
        this.pcdm = pcdm;
        this.kldm = kldm;
    }

    public JhkHs() {
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

    public String getZydh() {
        return zydh;
    }

    public void setZydh(String zydh) {
        this.zydh = zydh == null ? null : zydh.trim();
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    public String getZyfx() {
        return zyfx;
    }

    public void setZyfx(String zyfx) {
        this.zyfx = zyfx == null ? null : zyfx.trim();
    }

    public String getPcdm() {
        return pcdm;
    }

    public void setPcdm(String pcdm) {
        this.pcdm = pcdm == null ? null : pcdm.trim();
    }

    public String getKldm() {
        return kldm;
    }

    public void setKldm(String kldm) {
        this.kldm = kldm == null ? null : kldm.trim();
    }
}