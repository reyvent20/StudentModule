package com.etiqa.test.StudentModule.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException(long courseId) {
        super(String.format("Course is not found with id : '%s'", courseId));
    }
}
