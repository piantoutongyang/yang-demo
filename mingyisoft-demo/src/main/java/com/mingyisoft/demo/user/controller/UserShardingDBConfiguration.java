package com.mingyisoft.demo.user.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.google.common.collect.Lists;

import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.StandardShardingStrategyConfiguration;


@Configuration
@MapperScan(basePackages = {"com.mingyisoft.demo.user.dao"}, sqlSessionFactoryRef = "userShardingSqlSessionFactory")
public class UserShardingDBConfiguration {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    private static final String USER_1_MASTER = "ds_master";
    private static final String USER_1_SLAVE = "ds_slave0";
    private static final String USER_SHARDING_1 = "dsMasterSlave1";
//    private static final String USER_SHARDING_2 = "dsMasterSlave2";
//
//    private static final String USER_SHARDING_DATA_SOURCE = "userSharding";
    
    //官网
//		DataSource getMasterSlaveDataSource() throws SQLException {
//    		MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
//			masterSlaveRuleConfig.setName("ds_master_slave");
//			masterSlaveRuleConfig.setMasterDataSourceName("ds_master");
//			masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("ds_slave0", "ds_slave1"));
//			return MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(), masterSlaveRuleConfig, new LinkedHashMap<String, Object>(), new Properties());
//    }

//    public void aaa() throws Exception {
//        // 配置真实数据源
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//        
//        // 配置主库
//        BasicDataSource masterDataSource = new BasicDataSource();
//        masterDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        masterDataSource.setUrl("jdbc:mysql://localhost:3306/ds_master");
//        masterDataSource.setUsername("root");
//        masterDataSource.setPassword("");
//        dataSourceMap.put("ds_master", masterDataSource);
//        
//        // 配置第一个从库
//        BasicDataSource slaveDataSource1 = new BasicDataSource();
//        slaveDataSource1.setDriverClassName("com.mysql.jdbc.Driver");
//        slaveDataSource1.setUrl("jdbc:mysql://localhost:3306/ds_slave0");
//        slaveDataSource1.setUsername("root");
//        slaveDataSource1.setPassword("");
//        dataSourceMap.put("ds_slave0", slaveDataSource1);
//        
//        // 配置第二个从库
//        BasicDataSource slaveDataSource2 = new BasicDataSource();
//        slaveDataSource2.setDriverClassName("com.mysql.jdbc.Driver");
//        slaveDataSource2.setUrl("jdbc:mysql://localhost:3306/ds_slave1");
//        slaveDataSource2.setUsername("root");
//        slaveDataSource2.setPassword("");
//        dataSourceMap.put("ds_slave1", slaveDataSource2);
//        
//        // 配置读写分离规则
//        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave0", "ds_slave1"));
//        
//        // 获取数据源对象
//        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new HashMap<String, Object>(), new Properties());
//
//    }

    @Bean(USER_1_MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.sharding.master")
    public DataSource dsUser1(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
 

    @Bean(USER_1_SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.sharding.slave")
    public DataSource dsUserSlave1(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
     

    @Bean(USER_SHARDING_1)
    public DataSource masterSlave1(@Qualifier(USER_1_MASTER) DataSource dsUser1,@Qualifier(USER_1_SLAVE) DataSource dsUserSlave1) throws Exception {
    	Map<String,DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put(USER_1_MASTER, dsUser1);
        dataSourceMap.put(USER_1_SLAVE, dsUserSlave1);
        MasterSlaveRuleConfiguration ruleConfiguration = new MasterSlaveRuleConfiguration("xxxx", USER_1_MASTER, Lists.newArrayList(USER_1_SLAVE));
        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, ruleConfiguration, new ConcurrentHashMap<>());
    }
    
    @Bean("userShardingSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier(USER_SHARDING_1) DataSource dataSource) throws Exception{
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean("userTransaction")
    public DataSourceTransactionManager userTransactionManager(@Qualifier(USER_SHARDING_1) DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    
//    @Bean("userTransaction")
//    public DataSourceTransactionManager userTransactionManager(@Qualifier(USER_SHARDING_DATA_SOURCE) DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }

    
//    public DataSource dsUser(@Qualifier(USER_SHARDING_1) DataSource dsUser1, @Qualifier(USER_SHARDING_2) DataSource dsUser2) throws Exception {
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//        dataSourceMap.put("dsUser1", dsUser1);
//        dataSourceMap.put("dsUser2", dsUser2);
//        ShardingRuleConfiguration userRule = getUserRule();
//        userRule.setDefaultDataSourceName("dsUser1");
//        DataSource ds = ShardingDataSourceFactory.createDataSource(dataSourceMap, userRule, new ConcurrentHashMap<>(), new Properties());
//        return ds;
//    }
    
//    @Bean(USER_SHARDING_DATA_SOURCE)
//    DataSource getMasterSlaveDataSource() throws SQLException {
//		Map<String, DataSource> dataSourceMap = new HashMap<>();
//	    // 配置主库
//	    BasicDataSource masterDataSource = new BasicDataSource();
//	    masterDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    masterDataSource.setUrl("jdbc:mysql://localhost:3306/ds0");
//	    masterDataSource.setUsername("root");
//	    masterDataSource.setPassword("123456");
//	    dataSourceMap.put("ds_master", masterDataSource);
//	    
//	    // 配置第一个从库
//	    BasicDataSource slaveDataSource1 = new BasicDataSource();
//	    slaveDataSource1.setDriverClassName("com.mysql.jdbc.Driver");
//	    slaveDataSource1.setUrl("jdbc:mysql://localhost:3306/ds1");
//	    slaveDataSource1.setUsername("root");
//	    slaveDataSource1.setPassword("123456");
//	    dataSourceMap.put("ds_slave0", slaveDataSource1);
//	    
//	    // 配置读写分离规则
//	    MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("xxxx","ds_master",Arrays.asList("ds_slave0"));
//	    // 创建数据源对象
//		DataSource ds = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new LinkedHashMap<String, Object>());
//		
//		return ds;
//    }
 

//    @Bean("userShardingSqlSessionFactory")
//    public SqlSessionFactory userSqlSessionFactory(@Qualifier(USER_SHARDING_DATA_SOURCE) DataSource dataSource) throws Exception{
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }

    

}
