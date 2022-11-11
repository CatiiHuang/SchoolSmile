package com.faceschool.demo.entity;

public class Qstudent {

    /**
     *学生id
     */
    private Integer id;
    /**
     *学生姓名
     */
    private String name;
    /**
     * 学生学号
     */
    private String snumber;
    /**
     * 学生登录密码
     */
    private String password;
    /**
     * 学生所属班级id
     */
    private Integer gradeid;
    /**
     * 是否签到的记录
     */
    private boolean signin;

    public Qstudent(){}

    public Qstudent(Student student, boolean signin){
        this.id = student.getId();
        this.name = student.getName();
        this.snumber = student.getSnumber();
        this.password = student.getPassword();
        this.gradeid = student.getGradeid();
        this.signin = signin;
    }

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

    public boolean isSignin() {
        return signin;
    }

    public void setSignin(boolean signin) {
        this.signin = signin;
    }

    @Override
    public String toString() {
        return "Qstudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", snumber='" + snumber + '\'' +
                ", password='" + password + '\'' +
                ", gradeid=" + gradeid +
                ", signin=" + signin +
                '}';
    }
}
