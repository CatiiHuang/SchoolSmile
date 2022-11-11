package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.Courselocation;
import com.faceschool.demo.entity.Signin;
import com.faceschool.demo.entity.Signinstu;
import com.faceschool.demo.entity.Teacher;
import com.faceschool.demo.mapper.CourselocationMapper;
import com.faceschool.demo.mapper.SigninMapper;
import com.faceschool.demo.mapper.TeacherMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-14
 */
@Api(value = "创建课程的controller", tags = {"创建课程的地理位置的接口"})
@RestController
@RequestMapping("/courselocation")
public class CourselocationController {

    @Autowired
    private CourselocationMapper courselocationMapper;
    @Autowired
    private SigninMapper signinMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @ApiOperation(value = "接收当前创建课程地点经度和纬度的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseid", value = "课程id", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "latitude", value = "经度", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "longitude", value = "纬度", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/create")
    public JSONObject creatlocation(@RequestParam("teacherid") String teacherid ,@RequestParam("courseid") String courseid,
                                     @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude){
        JSONObject jsonObject = new JSONObject();
        BigDecimal lat = new BigDecimal(latitude);
        BigDecimal lon = new BigDecimal(longitude);
        boolean result = true;
        Courselocation courselocation = new Courselocation();
        courselocation.setCourseid(Integer.parseInt(courseid));
        courselocation.setLatitude(lat);
        courselocation.setLongitude(lon);
        Integer a = courselocationMapper.insert(courselocation);
        if(a != 0){
            jsonObject.put("result",result);
        } else{
            result = false;
            jsonObject.put("result",result);
        }

        //创建签到类
        Signin signin = new Signin();
        Teacher teacher = teacherMapper.selectByName(teacherid);
        signin.setCid(Integer.parseInt(courseid));
        signin.setTid(teacher.getTid());
        int s = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
        signin.setVerify(s);
        signin.setCreatetime(new Date());
        Integer a1 = signinMapper.insert(signin);
        if (a1 != 0){
            jsonObject.put("classcode",s);
        }else {
            jsonObject.put("classcode",0);
        }
        return jsonObject;
    }

}

