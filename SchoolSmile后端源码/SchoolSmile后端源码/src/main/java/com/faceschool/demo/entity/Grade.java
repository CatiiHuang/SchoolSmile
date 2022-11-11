package com.faceschool.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 班级类
 */
@TableName("grade")
public class Grade {

    /**
     * 班级id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 班级名称
     */
    @TableField("name")
    private String name;

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

    @Override
    public String toString() {
        return "grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
