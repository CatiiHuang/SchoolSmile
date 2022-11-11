package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fyly
 * @since 2019-04-25
 */
public class Recom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论时间
     */
    @TableField("starttime")
    private String starttime;
    /**
     * 课程名称
     */
    @TableField("coursename")
    private String coursename;
    /**
     * 学生评论
     */
    @TableField("studentcontent")
    private String studentcontent;
    /**
     * 学生姓名
     */
    @TableField("studentname")
    private String studentname;
    /**
     * 教师姓名
     */
    @TableField("teachername")
    private String teachername;
    /**
     * 教师反馈
     */
    @TableField("teachercontent")
    private String teachercontent = "暂无";
    /**
     * 被评论的id
     */
    @TableField("commentid")
    private Integer commentid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStudentcontent() {
        return studentcontent;
    }

    public void setStudentcontent(String studentcontent) {
        this.studentcontent = studentcontent;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeachercontent() {
        return teachercontent;
    }

    public void setTeachercontent(String teachercontent) {
        this.teachercontent = teachercontent;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "Recom{" +
                "id=" + id +
                ", starttime='" + starttime + '\'' +
                ", coursename='" + coursename + '\'' +
                ", studentcontent='" + studentcontent + '\'' +
                ", studentname='" + studentname + '\'' +
                ", teachername='" + teachername + '\'' +
                ", teachercontent='" + teachercontent + '\'' +
                ", commentid=" + commentid +
                '}';
    }
}
