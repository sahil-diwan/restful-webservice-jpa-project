package com.sahildiwan.restful.jpa.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "com.sahildiwan.restful.jpa.restfuljpacrud" })
public class StudentConfig  implements WebMvcConfigurer{
}
