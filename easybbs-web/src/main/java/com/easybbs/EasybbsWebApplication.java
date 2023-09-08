package com.easybbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author cyt
 * @date 2023/9/8 15:58
 */
@SuppressWarnings({"all"})
@SpringBootApplication(scanBasePackages = {"com.easybbs"}) // spring包扫描
@MapperScan(basePackages = {"com.easybbs.mappers"}) // 扫描mybatis
@EnableTransactionManagement // 支持事务
public class EasybbsWebApplication {
     public static void main(String[] args) {
           SpringApplication.run(EasybbsWebApplication.class, args);
      }
}
