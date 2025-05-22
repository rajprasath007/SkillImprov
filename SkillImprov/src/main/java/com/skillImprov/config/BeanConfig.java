package com.skillImprov.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.Session;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Enrollment;
import com.skillImprov.entity.User;

@Configuration
@ComponentScan(basePackages="com.skillImprov.entity")

public class BeanConfig {
	

}
