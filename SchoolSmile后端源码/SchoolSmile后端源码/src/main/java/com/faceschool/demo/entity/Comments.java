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
 * @since 2019-04-19
 */
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间展示
     */
    @TableField("starttime")
    private String starttime;
    /**
     * 课程id
     */
    @TableField("courseid")
    private Integer courseid;
    /**
     * 评论
     */
    @TableField("content")
    private String content;
    /**
     * 学生id
     */
    @TableField("studentid")
    private Integer studentid;


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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "Comments{" +
        ", id=" + id +
        ", starttime=" + starttime +
        ", courseid=" + courseid +
        ", content=" + content +
        ", studentid=" + studentid +
        "}";
    }
}
