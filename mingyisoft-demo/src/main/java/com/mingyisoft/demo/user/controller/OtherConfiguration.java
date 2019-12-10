package com.mingyisoft.demo.user.controller;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean; 


@Configuration
@MapperScan(basePackages = {"com.mingyisoft.demo.other.dao"}, sqlSessionFactoryRef = "otherSessionFactory")
public class OtherConfiguration {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    private static final String USER_SHARDING_DATA_SOURCE = "otherSharding";
    
    @Bean(USER_SHARDING_DATA_SOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.other")
    public DataSource dsUser1(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean("otherSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier(USER_SHARDING_DATA_SOURCE) DataSource dataSource) throws Exception{
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
