package com.tw.data;

import com.tw.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
