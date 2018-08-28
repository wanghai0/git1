package com.ctcc.xfxt2.entity;

public class ZykHs {

    private String ksh;

    private String pcdm;

    private String zyh;

    private String yxdh;

    private String zydh1;

    private String zydh2;

    private String zydh3;

    private String zydh4;

    private String zydh5;

    private String zydh6;

    private String zyzyfc;

    private String zfc;

    private String status;

    private String ip;

    private String inputtime;

    private String updatetime;

    private String printtime;

    private String confirmtim;

    private String digest;

    public ZykHs(String ksh, String pcdm, String zyh, String yxdh, String zydh1, String zydh2, String zydh3,
            String zydh4, String zydh5, String zydh6, String zyzyfc, String zfc, String status, String ip,
            String inputtime, String updatetime, String printtime, String confirmtim, String digest) {
        this.ksh = ksh;
        this.pcdm = pcdm;
        this.zyh = zyh;
        this.yxdh = yxdh;
        this.zydh1 = zydh1;
        this.zydh2 = zydh2;
        this.zydh3 = zydh3;
        this.zydh4 = zydh4;
        this.zydh5 = zydh5;
        this.zydh6 = zydh6;
        this.zyzyfc = zyzyfc;
        this.zfc = zfc;
        this.status = status;
        this.ip = ip;
        this.inputtime = inputtime;
        this.updatetime = updatetime;
        this.printtime = printtime;
        this.confirmtim = confirmtim;
        this.digest = digest;
    }

    public ZykHs() {
        super();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getPcdm() {
        return pcdm;
    }

    public void setPcdm(String pcdm) {
        this.pcdm = pcdm == null ? null : pcdm.trim();
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh == null ? null : zyh.trim();
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

    public String getZyzyfc() {
        return zyzyfc;
    }

    public void setZyzyfc(String zyzyfc) {
        this.zyzyfc = zyzyfc == null ? null : zyzyfc.trim();
    }

    public String getZfc() {
        return zfc;
    }

    public void setZfc(String zfc) {
        this.zfc = zfc == null ? null : zfc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getInputtime() {
        return inputtime;
    }

    public void setInputtime(String inputtime) {
        this.inputtime = inputtime == null ? null : inputtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getPrinttime() {
        return printtime;
    }

    public void setPrinttime(String printtime) {
        this.printtime = printtime == null ? null : printtime.trim();
    }

    public String getConfirmtim() {
        return confirmtim;
    }

    public void setConfirmtim(String confirmtim) {
        this.confirmtim = confirmtim == null ? null : confirmtim.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }
}