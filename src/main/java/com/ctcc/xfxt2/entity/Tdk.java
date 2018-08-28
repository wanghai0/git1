package com.ctcc.xfxt2.entity;

import java.util.Date;

public class Tdk {

    private String ksh;

    private Date wcsj;

    private String tddw;

    private String tdyx;

    private Date tdsj;

    private String ksztmc;

    private String lqzy;

    private String tdyymc;

    private String bz;

    private String tdmbh;

    private String tdpc;

    private String tdzy;

    private String kl;

    private String zctddm;

    private String zctdmc;

    private Date ycczsj;

    private String lqfs;

    private String jhxz;

    public Tdk(String ksh, Date wcsj, String tddw, String tdyx, Date tdsj, String ksztmc, String lqzy, String tdyymc,
            String bz, String tdmbh, String tdpc, String tdzy, String kl, String zctddm, String zctdmc, Date ycczsj,
            String lqfs, String jhxz) {
        this.ksh = ksh;
        this.wcsj = wcsj;
        this.tddw = tddw;
        this.tdyx = tdyx;
        this.tdsj = tdsj;
        this.ksztmc = ksztmc;
        this.lqzy = lqzy;
        this.tdyymc = tdyymc;
        this.bz = bz;
        this.tdmbh = tdmbh;
        this.tdpc = tdpc;
        this.tdzy = tdzy;
        this.kl = kl;
        this.zctddm = zctddm;
        this.zctdmc = zctdmc;
        this.ycczsj = ycczsj;
        this.lqfs = lqfs;
        this.jhxz = jhxz;
    }

    public Tdk() {
        super();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public Date getWcsj() {
        return wcsj;
    }

    public void setWcsj(Date wcsj) {
        this.wcsj = wcsj;
    }

    public String getTddw() {
        return tddw;
    }

    public void setTddw(String tddw) {
        this.tddw = tddw == null ? null : tddw.trim();
    }

    public String getTdyx() {
        return tdyx;
    }

    public void setTdyx(String tdyx) {
        this.tdyx = tdyx == null ? null : tdyx.trim();
    }

    public Date getTdsj() {
        return tdsj;
    }

    public void setTdsj(Date tdsj) {
        this.tdsj = tdsj;
    }

    public String getKsztmc() {
        return ksztmc;
    }

    public void setKsztmc(String ksztmc) {
        this.ksztmc = ksztmc == null ? null : ksztmc.trim();
    }

    public String getLqzy() {
        return lqzy;
    }

    public void setLqzy(String lqzy) {
        this.lqzy = lqzy == null ? null : lqzy.trim();
    }

    public String getTdyymc() {
        return tdyymc;
    }

    public void setTdyymc(String tdyymc) {
        this.tdyymc = tdyymc == null ? null : tdyymc.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getTdmbh() {
        return tdmbh;
    }

    public void setTdmbh(String tdmbh) {
        this.tdmbh = tdmbh == null ? null : tdmbh.trim();
    }

    public String getTdpc() {
        return tdpc;
    }

    public void setTdpc(String tdpc) {
        this.tdpc = tdpc == null ? null : tdpc.trim();
    }

    public String getTdzy() {
        return tdzy;
    }

    public void setTdzy(String tdzy) {
        this.tdzy = tdzy == null ? null : tdzy.trim();
    }

    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl == null ? null : kl.trim();
    }

    public String getZctddm() {
        return zctddm;
    }

    public void setZctddm(String zctddm) {
        this.zctddm = zctddm == null ? null : zctddm.trim();
    }

    public String getZctdmc() {
        return zctdmc;
    }

    public void setZctdmc(String zctdmc) {
        this.zctdmc = zctdmc == null ? null : zctdmc.trim();
    }

    public Date getYcczsj() {
        return ycczsj;
    }

    public void setYcczsj(Date ycczsj) {
        this.ycczsj = ycczsj;
    }

    public String getLqfs() {
        return lqfs;
    }

    public void setLqfs(String lqfs) {
        this.lqfs = lqfs == null ? null : lqfs.trim();
    }

    public String getJhxz() {
        return jhxz;
    }

    public void setJhxz(String jhxz) {
        this.jhxz = jhxz == null ? null : jhxz.trim();
    }
}