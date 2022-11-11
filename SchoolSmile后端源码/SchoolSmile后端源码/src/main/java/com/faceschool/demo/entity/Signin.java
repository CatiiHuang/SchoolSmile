package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * 签到类
 */
@TableName("signin")
public class Signin {

    /**
     * 每次创建签到的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 每次签到的课程
     */
    @TableField("cid")
    private Integer cid;
    /**
     * 每次创建签到的老师
     */
    @TableField("tid")
    private Integer tid;
    /**
     * 每次创建签到时的时间
     */
    @TableField("createtime")
    private Date createtime;
    /**
     * 创建时的验证码
     */
    @TableField("verify")
    private Integer verify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    @Override
    public String toString() {
        return "Signin{" +
                "id=" + id +
                ", cid=" + cid +
                ", tid=" + tid +
                ", createtime=" + createtime +
                ", verify=" + verify +
                '}';
    }
}
