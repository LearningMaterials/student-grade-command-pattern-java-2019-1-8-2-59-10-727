package com.tw.service;

import com.tw.data.StudentData;
import com.tw.entity.Student;
import com.tw.entity.Subject;
import com.tw.web.CommandPage;

import java.util.*;
import java.util.stream.Collectors;

public class CommandService {
    private CommandPage commandPage = new CommandPage();
    private Scanner input = new Scanner(System.in);
    private StudentData studentData = new StudentData();

    public void mainPage() {
        commandPage.mainPage();
    }

    public void userSelect(int menuNumber) {
        if (menuNumber == 1) {
            commandPage.inputStudentInfoPage();
            addStudent();
        } else if (menuNumber == 2) {
            commandPage.inputStudentIdPage();
        } else if (menuNumber == 3) {
            System.exit(1);
        }
    }

    private void addStudent() {
        Student student = new Student();
        String studentInfo = input.nextLine();
        String[] studentArray = studentInfo.split(", ");
        if (studentArray.length < 3) {
            commandPage.inputStudentInfoAgainPage();
            addStudent();
        } else {
            student.setName(studentArray[0]);
            student.setStudentId(studentArray[1]);
            for (int i = 2; i < studentArray.length; i++) {
                Subject subject = new Subject();
                String[] subjectInfo = studentArray[i].split(": ");
                subject.setName(subjectInfo[0]);
                subject.setScore(Double.valueOf(subjectInfo[1]));
                student.setSubject(subject);
            }
            studentData.add(student);
            commandPage.inputStudentSuccessPage(student.getName());
        }

    }

}
