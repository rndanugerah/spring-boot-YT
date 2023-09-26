package com.anugerah.jpa.hibernate.model.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anugerah.jpa.hibernate.model.entities.Course;

import jakarta.persistence.EntityManager;

@Repository
public class CourseRepository {
    
    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }
}
