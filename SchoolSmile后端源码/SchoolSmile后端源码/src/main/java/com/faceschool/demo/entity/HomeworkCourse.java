package com.faceschool.demo.entity;

public class HomeworkCourse {

    /**
     * id
     */
    private Integer id;
    /**
     * 学生id
     */
    private Integer userid;
    /**
     * 图片的本地路径，上服务器之后可能这一块要改 唉！
     */
    private String url;
    /**
     * 上传作业的名字
     */
    private String name;
    /**
     * 上交课程的id号
     */
    private Integer courseid;
    /**
     * 课程名称
     */
    private String coursename;
    /**
     * 创建时间
     */
    private String starttime;

    public HomeworkCourse() {}

    public HomeworkCourse(Homework homework, String coursename) {
        this.id = homework.getId();
        this.userid = homework.getUserid();
        this.url = homework.getUrl();
        this.name = homework.getName();
        this.courseid = homework.getCourseid();
        this.starttime = homework.getStarttime();
        this.coursename = coursename;
    }

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

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        return "HomeworkCourse{" +
                "id=" + id +
                ", userid=" + userid +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", starttime='" + starttime + '\'' +
                '}';
    }
}
