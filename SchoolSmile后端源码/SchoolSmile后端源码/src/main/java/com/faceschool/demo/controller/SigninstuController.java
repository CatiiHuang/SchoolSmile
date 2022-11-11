package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.Signin;
import com.faceschool.demo.entity.Signinstu;
import com.faceschool.demo.entity.Student;
import com.faceschool.demo.mapper.SigninMapper;
import com.faceschool.demo.mapper.SigninstuMapper;
import com.faceschool.demo.mapper.StudentMapper;
import com.google.gson.JsonObject;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Api(value = "学生签到controller", tags = {"创建学生签到类"})
@RestController
@RequestMapping("/signinstu")
public class SigninstuController {

    @Autowired
    private SigninMapper signinMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SigninstuMapper signinstuMapper;

      @ApiOperation(value = "获取学生签到时地理位置信息的接口")
      @ApiImplicitParams({
              @ApiImplicitParam(name = "user", value = "学生学号", required = true, dataType = "string", paramType = "query"),
              @ApiImplicitParam(name = "verify", value = "课程验证码", required = true, dataType = "string", paramType = "query"),
              @ApiImplicitParam(name = "latitude", value = "经度", required = true, dataType = "string", paramType = "query"),
              @ApiImplicitParam(name = "longitude", value = "纬度", required = true, dataType = "string", paramType = "query")
      })
      @GetMapping("/createsgnin")
      public JSONObject createsgnin(@RequestParam("user") String user, @RequestParam("verify") String verify,
                                    @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude){
          JSONObject jsonObject = new JSONObject();

          Signinstu signinstu = new Signinstu();
          BigDecimal lat = new BigDecimal(latitude);
          BigDecimal lon = new BigDecimal(longitude);
          Signin signin = signinMapper.selectByVerify(Integer.parseInt(verify));
          Student student = studentMapper.selectByName(user);
          signinstu.setStudentid(student.getId());
          signinstu.setSigninid(signin.getId());
          signinstu.setLatitude(lat);
          signinstu.setLongitude(lon);
          signinstu.setSignin(0);
          Integer a = signinstuMapper.insertSigninStu(signinstu);
          if (a != 0){
              jsonObject.put("signin",signinstu.getId());
              jsonObject.put("result","success");
          }else {
              jsonObject.put("signin",0);
              jsonObject.put("result","failed");
          }
          return jsonObject;
      }
}

