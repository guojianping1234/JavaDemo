package com.myspringbt.demo.dataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.myspringbt.demo.dao.priDataSource"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisDbAConfig {

    public static final String MAPPER_LOCATION = "classpath:mapper/priDataSource/*.xml";

    @Autowired
    @Qualifier("db1")
    private DataSource ds1;

    @Bean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1); // 使用主数据源, 连接主库
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(MybatisDbAConfig.MAPPER_LOCATION);
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();

    }

    @Bean("SqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory1());
    }


}
