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
public class Homeworkcomment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 教师账号
     */
    @TableField("user")
    private String user;
    /**
     * 图片路径
     */
    @TableField("url")
    private String url;
    /**
     * 作业名称
     */
    @TableField("name")
    private String name;
    /**
     * 课程名称
     */
    @TableField("coursename")
    private String coursename;
    /**
     * 学生姓名
     */
    @TableField("studentname")
    private String studentname;
    /**
     * 老师反馈
     */
    @TableField("content")
    private String content = "暂无";
    /**
     * 教师姓名
     */
    @TableField("teachername")
    private String teachername;
    /**
     * 作业id
     */
    @TableField("homeworkid")
    private Integer homeworkid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Integer getHomeworkid() {
        return homeworkid;
    }

    public void setHomeworkid(Integer homeworkid) {
        this.homeworkid = homeworkid;
    }


    @Override
    public String toString() {
        return "Homeworkcomment{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", coursename='" + coursename + '\'' +
                ", studentname='" + studentname + '\'' +
                ", content='" + content + '\'' +
                ", teachername='" + teachername + '\'' +
                ", homeworkid=" + homeworkid +
                '}';
    }
}
