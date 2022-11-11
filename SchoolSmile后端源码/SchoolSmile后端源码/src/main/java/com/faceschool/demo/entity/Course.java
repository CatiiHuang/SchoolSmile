package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.Objects;

/**
 * 每次签到的课程类
 */
@TableName("course")
public class Course {

    /**
     * 课程id
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    /**
     * 课程名称
     */
    @TableField("cname")
    private String cname;
    /**
     * 对课程的相关描述
     */
    @TableField("description")
    private String description;
    /**
     * 设置签到人数
     */
    @TableField("count")
    private Integer count;
    /**
     * 班级编号02131702
     */
    @TableField("gradename")
    private String gradename;
    /**
     * 每个设置的课程对应的老师id
     */
    @TableField("teacherid")
    private Integer teacherid;
    /**
     * 创建的课程地点
     */
    @TableField("classroom")
    private String classroom;
    /**
     * 创建签到时的时间
     */
    @TableField("createtime")
    private Date createtime;
    /**
     * 创建时间格式化
     */
    @TableField
    private String starttime;

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

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", gradename='" + gradename + '\'' +
                ", teacherid=" + teacherid +
                ", classroom='" + classroom + '\'' +
                ", createtime=" + createtime +
                ", starttime='" + starttime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(cid, course.cid) &&
                Objects.equals(cname, course.cname) &&
                Objects.equals(description, course.description) &&
                Objects.equals(count, course.count) &&
                Objects.equals(gradename, course.gradename) &&
                Objects.equals(teacherid, course.teacherid) &&
                Objects.equals(classroom, course.classroom) &&
                Objects.equals(createtime, course.createtime) &&
                Objects.equals(starttime, course.starttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, description, count, gradename, teacherid, classroom, createtime, starttime);
    }
}
