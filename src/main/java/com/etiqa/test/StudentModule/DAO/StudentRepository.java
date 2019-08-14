package com.etiqa.test.StudentModule.DAO;

import com.etiqa.test.StudentModule.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(long courseId);
}
