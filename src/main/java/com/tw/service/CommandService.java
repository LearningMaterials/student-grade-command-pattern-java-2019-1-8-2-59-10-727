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
            Student student = addStudent();
            if(student == null){
                commandPage.inputStudentInfoAgainPage();
                addStudent();
            }else{
                studentData.add(student);
                commandPage.inputStudentSuccessPage(student.getName());
            }
        } else if (menuNumber == 2) {
            commandPage.inputStudentIdPage();
        } else if (menuNumber == 3) {
            System.exit(1);
        }
    }

    private Student addStudent() {
        Student student = new Student();
        Subject subject = new Subject();
        String studentInfo = input.nextLine();
        String[] studentArray = studentInfo.split(", ");
        if (studentArray.length == 6) {
            student.setName(studentArray[0]);
            student.setStudentId(studentArray[1]);
            for (int i = 2; i < studentArray.length; i++) {
                String[] subjectInfo = studentArray[i].split(": ");
                switch (subjectInfo[0]) {
                    case "数学":
                        subject.setMath(Double.parseDouble(subjectInfo[1]));
                        break;
                    case "语文":
                        subject.setLanguage(Double.parseDouble(subjectInfo[1]));
                        break;
                    case "英语":
                        subject.setEnglish(Double.parseDouble(subjectInfo[1]));
                        break;
                    case "编程":
                        subject.setProgram(Double.parseDouble(subjectInfo[1]));
                        break;
                        default:
                            return null;
                }
            }
            student.setSubject(subject);
            return student;
        }
        return null;
    }
}
