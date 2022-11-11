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
 * @since 2019-04-20
 */
public class Homework implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学生id
     */
    @TableField("userid")
    private Integer userid;
    /**
     * 图片的本地路径，上服务器之后可能这一块要改 唉！
     */
    @TableField("url")
    private String url;
    /**
     * 上传作业的名字
     */
    @TableField("name")
    private String name;
    /**
     * 上交课程的id号
     */
    @TableField("courseid")
    private Integer courseid;
    /**
     * 创建时间
     */
    @TableField("starttime")
    private String starttime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", userid=" + userid +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", courseid=" + courseid +
                ", starttime='" + starttime + '\'' +
                '}';
    }
}
