/**
 * 版权所有©深航渔
 */
package com.shenhangyu.icard.icardweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.shenhangyu.icard.icardweb.security.IDecryption;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *描述：
 *@author moshenghang
 *@create 2020/4/14 0014 22:11
 */
@Configuration
@EnableTransactionManagement
public class IMyBatisConfig {
    private static Logger logger = LoggerFactory.getLogger(IMyBatisConfig.class);
    @Autowired
    private IDruidConfig iDruidConfig;
    @Autowired
    private IDecryption iDecryption;
    @Bean(name="dataSource")
    public DataSource druiDataSource(){
        logger.info("druidSourceConfig:{}",iDruidConfig);
        DruidDataSource druidDataSource = new DruidDataSource();
        try{
            druidDataSource.setDriverClassName(iDruidConfig.getDriverClassName());
            druidDataSource.setUrl(iDruidConfig.getUrl());
            druidDataSource.setUsername(iDruidConfig.getUsername());
            druidDataSource.setPassword(iDruidConfig.getPassword());
            //logger.info("配置参数的密码："+iDruidConfig.getPassword()+"，解密后的密码："+iDecryption.decryption(iDruidConfig.getPassword()));
            //druidDataSource.setPassword(iDecryption.decryption(iDruidConfig.getPassword()));
            druidDataSource.setMaxActive(iDruidConfig.getMaxActive());
            druidDataSource.setMinIdle(iDruidConfig.getMinIdle());
            druidDataSource.setInitialSize(iDruidConfig.getInitialSize());
            druidDataSource.setMaxWait(iDruidConfig.getMaxWait());
            druidDataSource.setTimeBetweenEvictionRunsMillis(iDruidConfig.getTimeBetweenEvictionRunsMillis());
            druidDataSource.setPoolPreparedStatements(iDruidConfig.isPoolPreparedStatements());
            druidDataSource.setMaxOpenPreparedStatements(iDruidConfig.getMaxOpenPreparedStatements());
            druidDataSource.setFilters(iDruidConfig.getFilters());
            druidDataSource.setMinEvictableIdleTimeMillis(iDruidConfig.getMinEvictableIdleTimeMillis());
            druidDataSource.setTestWhileIdle(iDruidConfig.isTestWhileIdle());
            druidDataSource.setTestOnBorrow(iDruidConfig.isTestOnBorrow());
            druidDataSource.setValidationQuery(iDruidConfig.getValidationQuery());
            druidDataSource.setValidationQueryTimeout(iDruidConfig.getValidationQueryTimeout());
            druidDataSource.setMaxEvictableIdleTimeMillis(iDruidConfig.getMinEvictableIdleTimeMillis());
        }catch (Exception e){
            logger.error("SQLException:{}",e);
        }
        return druidDataSource;
    }
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druiDataSource());
        sqlSessionFactoryBean.setTypeHandlersPackage("classpath:com/shenhangyu/icard/icardweb/bean/*");
        //分页插件 
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasenable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourceLoader.getResources("classpath:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager()throws Exception{
    	return new DataSourceTransactionManager(druiDataSource());
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
}
