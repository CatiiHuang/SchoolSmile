package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Objects;

/**
 * 学生类
 */
@TableName("student")
public class Student {

    /**
    *学生id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *学生姓名
     */
    @TableField("name")
    private String name;
    /**
     * 学生学号
     */
    @TableField("snumber")
    private String snumber;
    /**
     * 学生登录密码
     */
    @TableField("password")
    private String password;
    /**
     * 学生所属班级id
     */
    @TableField("gradeid")
    private Integer gradeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", snumber='" + snumber + '\'' +
                ", password='" + password + '\'' +
                ", gradeid=" + gradeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(snumber, student.snumber) &&
                Objects.equals(password, student.password) &&
                Objects.equals(gradeid, student.gradeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, snumber, password, gradeid);
    }
}
