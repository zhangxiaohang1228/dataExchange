package com.zxh.dataexchange.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: zxh
 * @Date: 2019/10/16 22:24
 * @desc: 第一数据源的对应
 */

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.zxh.dataexchange.mapper"},// 1. dao 层所在的包
        entityManagerFactoryRef = "firstEntityManagerFactory",
        transactionManagerRef = "firstTransactionManager")
@EnableTransactionManagement
public class FirstConfig {

  @Autowired
  @Qualifier("defaultDataSource")
  private DataSource dataSource;


  @Bean
  @Primary
  public PlatformTransactionManager firstTransactionManager() {
    return new JpaTransactionManager(firstEntityManagerFactory().getObject());
  }

  @Bean(name = "entityManagerFactory")
  @Primary
  public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory() {

    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setJpaProperties(hibernateProperties());

    factoryBean.setPackagesToScan("com.zxh.dataexchange.bean");// 2. 实体类所在的包

    return factoryBean;
  }


  private Properties hibernateProperties() {
    final Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    return hibernateProperties;
  }


}