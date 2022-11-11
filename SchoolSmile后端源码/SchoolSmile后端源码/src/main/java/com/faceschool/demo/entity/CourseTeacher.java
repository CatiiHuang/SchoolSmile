package com.faceschool.demo.entity;

import java.util.Date;

public class CourseTeacher {

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
     * 创建时间格式化
     */
    private String starttime;
    /**
     * 教师姓名
     */
    private String teachername;

    public CourseTeacher(){}

    public CourseTeacher(Course course,String teachername) {
        this.cid = course.getCid();
        this.classroom = course.getClassroom();
        this.teacherid = course.getTeacherid();
        this.cname = course.getCname();
        this.count = course.getCount();
        this.gradename = course.getGradename();
        this.description = course.getDescription();
        this.createtime = course.getCreatetime();
        this.starttime = course.getStarttime();
        this.teachername = teachername;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "CourseTeacher{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", gradename='" + gradename + '\'' +
                ", teacherid=" + teacherid +
                ", classroom='" + classroom + '\'' +
                ", createtime=" + createtime +
                ", starttime='" + starttime + '\'' +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
