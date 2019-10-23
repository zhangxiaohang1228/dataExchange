package com.zxh.dataexchange.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @Author: zxh
 * @Date: 2019/10/16 22:50
 * @desc
 */
//@Configuration
//@EnableTransactionManagement
public class TransactionManagersConfig {
  //Autowired
  EntityManagerFactory emf;
  //Autowired
  //@Qualifier("defaultDataSource")
  private DataSource dataSource;

  //@Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager tm =
            new JpaTransactionManager();
    tm.setEntityManagerFactory(emf);
    tm.setDataSource(dataSource);
    return tm;
  }
}

