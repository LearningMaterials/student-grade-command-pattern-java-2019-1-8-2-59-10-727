package com.tw.data;

import com.tw.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    static List<Student> students = new ArrayList<>();

    public static void add(Student student) {
        students.add(student);
    }

    public static List<Student> getStudents() {
        return students;
    }
}
