package com.sakerini.webcustomertracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@ServletComponentScan
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebCustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCustomerTrackerApplication.class, args);
    }

}
