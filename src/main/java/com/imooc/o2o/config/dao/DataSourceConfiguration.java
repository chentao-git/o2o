package com.imooc.o2o.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.imooc.o2o.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    /**
     * 生成与spring-dao-xml 对应的bean dataSource
     */
@Bean(name = "dataSpurce")
    public ComboPooledDataSource createDataSource(){
        //生成dataSource实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //跟配置文件一样设置以下信息
    try {
        //驱动
        dataSource.setDriverClass(jdbcDriver);
        //url
        dataSource.setJdbcUrl(jdbcUrl);
        //用户
        dataSource.setDataSourceName(jdbcUsername);
        //密码
        dataSource.setPassword(jdbcPassword);
    } catch (PropertyVetoException e) {
        e.printStackTrace();
    }
    return dataSource;
}

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
