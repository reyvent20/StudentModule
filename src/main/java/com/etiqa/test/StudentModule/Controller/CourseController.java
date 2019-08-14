package com.etiqa.test.StudentModule.Controller;

import com.etiqa.test.StudentModule.DAO.CourseRepository;
import com.etiqa.test.StudentModule.Entity.Course;
import com.etiqa.test.StudentModule.exception.CourseNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseRepository courseRepo;

    @GetMapping("/all")
    public List<Course> getAllCourse() {
        logger.info("Course: getAllCourse - start");
        return courseRepo.findAll();
    }

    @GetMapping("/all/{id}")
    public Course getCourseById(@PathVariable(value = "id") Long courseId) throws CourseNotFoundException {
        logger.info("Course: getCourseById - start: id, " + courseId);
        return courseRepo.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        logger.info("Course: addCourse - start: course.toString(), " + course.toString());
        return courseRepo.save(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable(value = "id") Long courseId, @Valid @RequestBody Course course) throws CourseNotFoundException {
        Course course1 = courseRepo.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        course1.setTitle(course.getTitle());
        course1.setDescription(course.getDescription());

        logger.info("Course: updateCourse - start: course.toString(), " + course.toString());
        Course updatedCourse = courseRepo.save(course1);

        return updatedCourse;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(value = "id") Long courseId) throws CourseNotFoundException {
        logger.info("Course: deleteCourse - start: courseId, " + courseId);
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        courseRepo.delete(course);

        return ResponseEntity.ok().build();
    }
}
