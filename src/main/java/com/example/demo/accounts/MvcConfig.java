package com.example.demo.accounts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by edwar on 11/22/2017.
 */
@Configuration
public class MvcConfig {

//    @Value("${ps=}")
//    private String aaaa;

//    @Primary
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/tours");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;
//    }

        @Primary
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://tours.ccstqrdndgqb.us-east-2.rds.amazonaws.com:3306/tours");
        driverManagerDataSource.setUsername("eduards");
        driverManagerDataSource.setPassword("eduards123");
        return driverManagerDataSource;
    }


}
