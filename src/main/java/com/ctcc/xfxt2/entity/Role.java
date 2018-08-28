package com.ctcc.xfxt2.entity;

public class Role {

    private Integer id;

    private String roleName;

    private String description;

    private String status;

    public Role(Integer id, String roleName, String description, String status) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}