package com.ctcc.xfxt2.entity;

public class Right {

    private Integer id;

    private String rightName;

    private String url;

    private String description;

    private String status;

    public Right(Integer id, String rightName, String url, String description, String status) {
        this.id = id;
        this.rightName = rightName;
        this.url = url;
        this.description = description;
        this.status = status;
    }

    public Right() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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