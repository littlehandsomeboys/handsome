package com.handsome.admin.ao.bean;

public class Title {
    private String id;

    private String code;

    private String name;

    private Integer limitPoint;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLimitPoint() {
        return limitPoint;
    }

    public void setLimitPoint(Integer limitPoint) {
        this.limitPoint = limitPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}