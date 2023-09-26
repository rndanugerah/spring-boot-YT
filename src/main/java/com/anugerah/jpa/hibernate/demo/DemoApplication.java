package com.anugerah.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.anugerah.jpa.hibernate.model.entities.Course;
import com.anugerah.jpa.hibernate.model.repos.CourseRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.anugerah.jpa.hibernate.*")
@EntityScan("com.anugerah.jpa.hibernate.*")
@EnableJpaRepositories(basePackages = "com.anugerah.jpa.hibernate.model.repos.CourseRepository")
public class DemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);

		logger.info("Course 10001 -> {}", course);
	}

}
