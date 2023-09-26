package com.anugerah.jpa.hibernate.demo.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.anugerah.jpa.hibernate.demo.DemoApplication;
import com.anugerah.jpa.hibernate.model.entities.Course;
import com.anugerah.jpa.hibernate.model.repos.CourseRepository;

@SpringBootTest(classes=DemoApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    
    @Test
    public void findByIdTest(){
        Course course = courseRepository.findById(10001L);
        assertEquals("belajar spring boot", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteByIdTest(){
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void saveTest(){
        // get a course
        Course course = courseRepository.findById(10001L);
        assertEquals("belajar spring boot", course.getName());

        //update details
        course.setName("belajar spring boot advanced");
        courseRepository.save(course);

        //check the value
        Course course2 = courseRepository.findById(10001L);
        assertEquals("belajar spring boot advanced", course2.getName());
    }
}
