package com.etiqa.test.StudentModule.exception;

public class StudentNotFoundException extends Exception {
    private long student_id;

    public StudentNotFoundException(long student_id) {
        super(String.format("Student is not found with id : '%s'", student_id));
    }
}
