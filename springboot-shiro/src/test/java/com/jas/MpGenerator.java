package com.jas;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author zchen
 * @description 代码生成
 * @create 2018-08-24 17:26
 */
public class MpGenerator {
    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/springboot_shiro?"
            + "useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "1234";
    private final static String TABLE_PREFIX = "t_";
    private final static String PARENT = "com.jas";

    @Test
    public void create() throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir("E:\\workspace\\springboot-shiro\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor("zchen");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUrl(URL);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[]{TABLE_PREFIX});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setInclude(new String[]{"t_user", "t_roles", "t_permissions"});
        strategy.setInclude(null);
        // strategy.setExclude(new String[]{"test"});
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT);

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
