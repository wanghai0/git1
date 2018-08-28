package com.ctcc.xfxt2.entity;

import java.util.Date;

public class User {

    private Integer id;

    private Integer roleId;

    private String loginName;

    private String password;

    private String salt;

    private String userName;

    private String mobile;

    private String address;

    private String email;

    private String dydm;

    private Date loginTime;

    private Integer loginCount;

    private String status;

    public User(Integer id, Integer roleId, String loginName, String password, String salt, String userName,
            String mobile, String address, String email, String dydm, Date loginTime, Integer loginCount,
            String status) {
        this.id = id;
        this.roleId = roleId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
        this.userName = userName;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
        this.dydm = dydm;
        this.loginTime = loginTime;
        this.loginCount = loginCount;
        this.status = status;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDydm() {
        return dydm;
    }

    public void setDydm(String dydm) {
        this.dydm = dydm == null ? null : dydm.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}