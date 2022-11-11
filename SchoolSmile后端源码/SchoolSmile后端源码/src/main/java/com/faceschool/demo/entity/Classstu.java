package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 每个班级与学生的关联
 */
@TableName("classstu")
public class Classstu {

    /**
     * 每个班级关联的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建的课程id
     */
    @TableField("classid")
    private Integer classid;
    /**
     * 签到的学生的id
     */
    @TableField("studentid")
    private Integer studentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "classstu{" +
                "id=" + id +
                ", classid=" + classid +
                ", studentid=" + studentid +
                '}';
    }
}
