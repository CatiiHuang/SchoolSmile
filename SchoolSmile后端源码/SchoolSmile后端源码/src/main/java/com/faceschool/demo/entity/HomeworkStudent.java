package com.faceschool.demo.entity;

public class HomeworkStudent {

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
     *学生姓名
     */
    private String studentname;
    /**
     * 学生学号
     */
    private String snumber;
    /**
     * 学生id
     */
    private Integer studentid;
    /**
     * 提交时间
     */
    private String starttime;

    public HomeworkStudent(){}

    public HomeworkStudent(Homework homework, Student student) {
        this.id = homework.getId();
        this.userid = homework.getUserid();
        this.url = homework.getUrl();
        this.name = homework.getName();
        this.courseid = homework.getCourseid();
        this.studentname = student.getName();
        this.snumber = student.getSnumber();
        this.starttime = homework.getStarttime();
        this.studentid = student.getId();
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

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        return "HomeworkStudent{" +
                "id=" + id +
                ", userid=" + userid +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", courseid=" + courseid +
                ", studentname='" + studentname + '\'' +
                ", snumber='" + snumber + '\'' +
                ", studentid=" + studentid +
                ", starttime='" + starttime + '\'' +
                '}';
    }
}
