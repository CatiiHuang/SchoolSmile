package com.faceschool.demo.entity;

import java.util.Date;

public class SigninCourse {

    /**
     * 课程id
     */
    private Integer cid;
    /**
     * 课程名称
     */
    private String cname;
    /**
     * 对课程的相关描述
     */
    private String description;
    /**
     * 设置签到人数
     */
    private Integer count;
    /**
     * 班级编号02131702
     */
    private String gradename;
    /**
     * 每个设置的课程对应的老师id
     */
    private Integer teacherid;
    /**
     * 创建的课程地点
     */
    private String classroom;
    /**
     * 创建签到时的时间
     */
    private Date createtime;
    /**
     *创建时间的格式化
     */
    private String starttime;
    /**
     * 创建签到时返回的四位数编码
     */
    private Integer verify;

    public SigninCourse(){}

    public SigninCourse(Course course,Integer verify) {
        this.cid = course.getCid();
        this.classroom = course.getClassroom();
        this.cname = course.getCname();
        this.count = course.getCount();
        this.createtime = course.getCreatetime();
        this.description = course.getDescription();
        this.teacherid = course.getTeacherid();
        this.starttime = course.getStarttime();
        this.gradename = course.getGradename();
        this.verify = verify;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }


    @Override
    public String toString() {
        return "SigninCourse{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", gradename='" + gradename + '\'' +
                ", teacherid=" + teacherid +
                ", classroom='" + classroom + '\'' +
                ", createtime=" + createtime +
                ", starttime='" + starttime + '\'' +
                ", verify=" + verify +
                '}';
    }
}
