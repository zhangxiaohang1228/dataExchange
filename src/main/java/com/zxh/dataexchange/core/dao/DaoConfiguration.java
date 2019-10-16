package com.zxh.dataexchange.core.dao;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zxh.dataexchange.core.commons.DataSourceNames;
import com.zxh.dataexchange.core.commons.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zxh
 * @Date: 2019-10-16 14:54
 * @Description: 数据源
 */
@Configuration
@MapperScan({"com.zxh.dataexchange.mapper"})
@EnableJpaRepositories("com.zxh.dataexchange.mapper")
public class DaoConfiguration {

    /**
     * 默认数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource defaultDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 第二数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.slave")
    public DataSource otherDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dynamicDataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        //设置默认数据源
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceNames.DEFAULT, defaultDataSource());
        dataSourceMap.put(DataSourceNames.OTHER, otherDataSource());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        //此处设置为了解决找不到mapper文件的问题
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 事务管理
     *
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }



}
