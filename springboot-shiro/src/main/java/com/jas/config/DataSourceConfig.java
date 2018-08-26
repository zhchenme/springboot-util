package com.jas.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.jas.status.BaseLogicDeleteEnum;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;

/**
 * MyBatis Plus 与数据源配置类
 * 
 * @author zchen
 * @description
 * @create 2018-08-24 18:07
 */
@Configuration
@MapperScan(basePackages = {"com.jas.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(ResourceUtils.CLASSPATH_URL_PREFIX 
                        + "com/jas/mapper/*Mapper.xml"));
        factoryBean.setTypeAliasesPackage("com.jas.entity");
        factoryBean.setPlugins(new Interceptor[] { paginationInterceptor(), 
                optimisticLockerInterceptor(), sqlExplainInterceptor(), performanceInterceptor()});
        factoryBean.setGlobalConfig(this.globalConfiguration());

        return factoryBean.getObject();
    }

    /**
     * 乐观锁插件
     * 
     * @return
     */
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * SQL 分析拦截器，防止恶意删除或更新全表数据
     * 
     * @return
     */
    public SqlExplainInterceptor sqlExplainInterceptor() {
        return new SqlExplainInterceptor();
    }

    /**
     * 分页插件
     * 
     * @return
     */
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL 执行效率插件
     * 
     * @return
     */
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor intrceptor = new PerformanceInterceptor();
        
        intrceptor.setMaxTime(20000);
        intrceptor.setFormat(true);
        
        return intrceptor;
    }

    /**
     * 全局配置，主键策略、驼峰命名、设置逻辑删除
     * 
     * @return
     */
    private GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        
        conf.setLogicDeleteValue(BaseLogicDeleteEnum.LogicDelete.getValue());
        conf.setLogicNotDeleteValue(BaseLogicDeleteEnum.LogicNotDelete.getValue());
        conf.setIdType(IdType.AUTO.getKey());
        conf.setDbColumnUnderline(true);
        
        return conf;
    }
}
