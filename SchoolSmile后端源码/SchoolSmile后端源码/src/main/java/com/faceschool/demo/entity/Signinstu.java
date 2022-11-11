package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;

/**
 * 每次签到时的关联类
 */
@TableName("signinstu")
public class Signinstu {

    /**
     * 每次关联类的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 每次签到的签到类
     */
    @TableField("signinid")
    private Integer signinid;
    /**
     * 每次签到学生
     */
    @TableField("studentid")
    private Integer studentid;
    /**
     * 经度
     */
    @TableField("latitude")
    private BigDecimal latitude;
    /**
     * 纬度
     */
    @TableField("longitude")
    private BigDecimal longitude;
    /**
     * 签到是否成功的标记
     */
    @TableField("signin")
    private Integer signin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSigninid() {
        return signinid;
    }

    public void setSigninid(Integer signinid) {
        this.signinid = signinid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getSignin() {
        return signin;
    }

    public void setSignin(Integer signin) {
        this.signin = signin;
    }

    @Override
    public String toString() {
        return "Signinstu{" +
                "id=" + id +
                ", signinid=" + signinid +
                ", studentid=" + studentid +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", signin=" + signin +
                '}';
    }
}
