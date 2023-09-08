package com.easybbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 */
@SuppressWarnings({"all"})
@SpringBootApplication(scanBasePackages = {"com.easybbs"}) // spring包扫描
@MapperScan(basePackages = {"com.easybbs.mappers"}) // 扫描mybatis
@EnableTransactionManagement // 支持事务
public class EasybbsAdminApplication {
     public static void main(String[] args) {
           SpringApplication.run(EasybbsAdminApplication.class, args);
      }
}
