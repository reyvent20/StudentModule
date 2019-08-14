package com.etiqa.test.StudentModule.Controller;

import com.etiqa.test.StudentModule.DAO.StudentRepository;
import com.etiqa.test.StudentModule.Entity.Student;
import com.etiqa.test.StudentModule.exception.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentRepository studRepo;

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        logger.info("Student: getAllStudent - start");
        return studRepo.findAll();
    }

    @GetMapping("/all/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) throws StudentNotFoundException {
        logger.info("Student: getStudentById - start: studentId, " + studentId);
        return studRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentByCourseId(@PathVariable(value = "id") Long courseId) {

        logger.info("Student: getStudentByCourseId - start: courseId, " + courseId);
        return studRepo.findByCourseId(courseId);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        logger.info("Student: addStudent - start: student.toString(), " + student.toString());
        return studRepo.save(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long studentId, @Valid @RequestBody Student student) throws StudentNotFoundException {
        Student stud = studRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        stud.setFirstName(student.getFirstName());
        stud.setLastName(student.getLastName());
        stud.setCourseId(student.getCourseId());

        logger.info("Student: updateStudent - start: student.toString(), " + stud.toString());
        Student updatedStud = studRepo.save(stud);

        return updatedStud;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) throws StudentNotFoundException {
        logger.info("Student: deleteStudent - start: id, " + studentId);
        Student stud = studRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        studRepo.delete(stud);

        return ResponseEntity.ok().build();
    }
}
