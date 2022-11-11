package com.faceschool.demo.entity;

/**
 * 学生与评论的包装类
 */
public class CommentsStudent {

    /**
     * 记录id
     */
    private Integer id;
    /**
     * 创建时间展示
     */
    private String starttime;
    /**
     * 课程id
     */
    private Integer courseid;
    /**
     * 评论
     */
    private String content;
    /**
     * 学生id
     */
    private Integer studentid;
    /**
     * 评论的学生
     */
    private Student student;
    /**
     * 课程名称
     */
    private String coursename;


    public CommentsStudent(){}

    public CommentsStudent(Comments commnets, Student student, String coursename) {
        this.id = commnets.getId();
        this.starttime = commnets.getStarttime();
        this.courseid = commnets.getCourseid();
        this.content = commnets.getContent();
        this.studentid = commnets.getStudentid();
        this.student = student;
        this.coursename = coursename;
    }

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "CommentsStudent{" +
                "id=" + id +
                ", starttime='" + starttime + '\'' +
                ", courseid=" + courseid +
                ", content='" + content + '\'' +
                ", studentid=" + studentid +
                ", student=" + student +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
