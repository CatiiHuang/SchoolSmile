package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 教师类
 */
@TableName("teacher")
public class Teacher {

    /**
     * 教师id
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;
    /**
     * 教师姓名
     */
    @TableField("tname")
    private String tname;
    /**
     * 教师工号
     */
    @TableField("tnumber")
    private String tnumber;
    /**
     * 教师密码
     */
    @TableField("tpassword")
    private String tpassword;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", tpassword='" + tpassword + '\'' +
                '}';
    }
}
