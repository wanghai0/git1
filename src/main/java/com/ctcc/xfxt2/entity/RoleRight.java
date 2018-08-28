package com.ctcc.xfxt2.entity;

public class RoleRight {

    private Integer id;

    private Integer roleId;

    private Integer rightId;

    private String status;

    public RoleRight(Integer id, Integer roleId, Integer rightId, String status) {
        this.id = id;
        this.roleId = roleId;
        this.rightId = rightId;
        this.status = status;
    }

    public RoleRight() {
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

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}