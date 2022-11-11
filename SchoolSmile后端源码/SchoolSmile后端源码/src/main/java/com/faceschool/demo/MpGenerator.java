package com.faceschool.demo;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {

    public static void main(String[] args) {
//        assert (false) : "代码生成属于危险操作，请确定配置后取消断言执行代码生成！";
        assert(false);
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
       String sourcePath = "E:/ideaworkspace/four/schoolface/src/main/java";
       String basePackage = "com.faceschool.demo";

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Fyly");
        gc.setOutputDir(sourcePath);
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        /*gc.setServiceName("%sApi");
        gc.setServiceImplName("%sService");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");*/

        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/lenos?serverTimezone=GMT%2B8")
                .setUsername("root")
                .setPassword("123456");
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
         mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.nochange)// 表名生成策略
//                .setCapitalMode(false)
//                .setDbColumnUnderline(true)
               // .setTablePrefix(new String[] { "ec_" })// 此处可以修改为您的表前缀
                .entityTableFieldAnnotationEnable(true)
                .setRestControllerStyle(true)
                .setEntityLombokModel(false)
                //.setSuperEntityClass("com.deepinsight.club.common.base.BaseEntity")
                //.setSuperEntityColumns("id", "uid", "create_user_id", "create_date", "last_update_user_id", "last_update_date")
//                .setSuperServiceClass("")
               // .setSuperServiceImplClass("com.baomidou.mybatisplus.service.impl.ServiceImpl")
                .setInclude(new String[]{"face"});//修改替换成你需要的表名，多个表名传数组

        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage)
                .setController("controller")
                .setService("service")//服务接口
                .setServiceImpl("service.impl")//服务实现
                .setMapper("mapper")//dao层
                .setXml("mapper")//dao层对应的xml文件
                .setEntity("entity");//pojo对象
        mpg.setPackageInfo(packageConfig);


//       TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setController("/template/controller.java.vm")
//                .setEntity("/template/entity.java.vm")
//                .setMapper("/template/mapper.java.vm")
//                .setXml("/template/mapper.xml.vm")
//                .setService("/template/service.java.vm")
//                .setServiceImpl("/template/serviceImpl.java.vm");
//        mpg.setTemplate(templateConfig);

        // 执行生成
        mpg.execute();

       /* String originSourcePath = sourcePath + basePackage.replaceAll("\\.", "/");
        FileSystemUtils.deleteRecursively(new File(originSourcePath + "/entity/"));
        FileSystemUtils.deleteRecursively(new File(originSourcePath + "/api/"));
    */
    }
}
