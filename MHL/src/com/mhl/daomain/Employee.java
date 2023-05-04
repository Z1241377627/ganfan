package com.mhl.daomain;

public class Employee {
    private Integer id;
    private String enpId;
    private String pwd;
    private String name;
    private String job;

    public Employee(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnpId() {
        return enpId;
    }

    public void setEnpId(String enpId) {
        this.enpId = enpId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee(Integer id, String enpId, String pwd, String name, String job) {
        this.id = id;
        this.enpId = enpId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }
}
