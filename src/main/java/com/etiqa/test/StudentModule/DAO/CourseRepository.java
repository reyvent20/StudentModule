package com.etiqa.test.StudentModule.DAO;

import com.etiqa.test.StudentModule.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
