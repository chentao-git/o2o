package com.imooc.o2o.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Configuration
//首先使用注解@EnableTransactionManagement 开启事物支持后
//在Service 上添加注解@Transactional 便可
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {

    //注入DataSourceConfiguration里面的DataSource通过createDataSource()获取
    @Autowired
    private DataSource dataSource;
    @Override
    /**
     * 关于事务管理，需返回PlatformTransactionManager的实现
     */
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
