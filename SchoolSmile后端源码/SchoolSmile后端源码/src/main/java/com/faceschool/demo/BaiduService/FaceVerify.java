package com.faceschool.demo.BaiduService;

import com.faceschool.demo.BaiduUtils.Base64Util;
import com.faceschool.demo.BaiduUtils.FileUtil;
import com.faceschool.demo.BaiduUtils.GsonUtils;
import com.faceschool.demo.BaiduUtils.HttpUtil;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在线活体检测
 */
public class FaceVerify {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String faceVerify(File file) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceverify";
        try {
            byte[] bytes = FileUtil.readFileByBytes(file);
            String image = Base64Util.encode(bytes);
            Map<String,Object> map = new HashMap<>();
            List<Object> list = new ArrayList<>();
            map.put("image",image);
            map.put("image_type","BASE64");
            map.put("face_field","age,beauty,face_liveness");
            list.add(map);
            String param = GsonUtils.toJson(list);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static double getResult(String result){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        map = gson.fromJson(result,Map.class);
        Map<String,Object> map1 = (Map<String, Object>) map.get("result");
        return (double)map1.get("face_liveness");
    }

    /*public static void main(String[] args) {
        FaceVerify.faceVerify();
    }*/
}
