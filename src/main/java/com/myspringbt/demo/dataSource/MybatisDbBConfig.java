package com.myspringbt.demo.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.myspringbt.demo.dao.secondDataSource"}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisDbBConfig {
    public static final String MAPPER_LOCATION = "classpath:mapper/secondDataSource/*.xml";

    @Autowired
    @Qualifier("db2")
    private DataSource ds2;

    @Bean("sqlSessionFactory2")
    @Primary
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds2);
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(MybatisDbBConfig.MAPPER_LOCATION);
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();

    }

    @Bean("SqlSessionTemplate2")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }


}
