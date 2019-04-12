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

    public void mainPage() {
        commandPage.mainPage();
    }

    public void userSelectMenu(int menuNumber) {
        if (menuNumber == 1) {
            addStudentToStudentData();
        } else if (menuNumber == 2) {
            showStudentSubject();
        } else if (menuNumber == 3) {
            System.exit(1);
        }
    }

    private void showStudentSubject() {
        String result;
        commandPage.inputStudentIdPage();
        String studentId = input.nextLine();
        result = showStudentScore(studentId);
        while (Objects.isNull(result)) {
            commandPage.inputStudentIdAgainPage();
            result = getStudentSubjectByIds();
        }
        commandPage.showStudentSubject(result);
    }

    private String getStudentSubjectByIds() {
        String studentId;
        String result;
        studentId = input.nextLine();
        result = showStudentScore(studentId);
        return result;
    }

    private void addStudentToStudentData() {
        Student student;
        commandPage.inputStudentInfoPage();
        student = getStudent();
        while (Objects.isNull(student)) {
            commandPage.inputStudentInfoAgainPage();
            student = getStudent();
        }
        StudentData.add(student);
        commandPage.inputStudentSuccessPage(student.getName());
    }

    private Student getStudent() {
        String studentInfo;
        Student student;
        studentInfo = input.nextLine();
        student = addStudent(studentInfo);
        return student;
    }

    public Student addStudent(String studentInfo) {
        Student student = new Student();
        Subject subject = new Subject();
        String[] studentArray = studentInfo.split(", ");
        if (studentArray.length == 6) {
            student.setName(studentArray[0]);
            student.setStudentId(studentArray[1]);
            for (int i = 2; i < studentArray.length; i++) {
                String[] subjectInfo = studentArray[i].split(": ");
                switch (subjectInfo[0]) {
                    case "数学":
                        subject.setMath(Integer.parseInt(subjectInfo[1]));
                        break;
                    case "语文":
                        subject.setLanguage(Integer.parseInt(subjectInfo[1]));
                        break;
                    case "英语":
                        subject.setEnglish(Integer.parseInt(subjectInfo[1]));
                        break;
                    case "编程":
                        subject.setProgram(Integer.parseInt(subjectInfo[1]));
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

    public String showStudentScore(String studentIdStr) {
        List<String> studentIds = Arrays.asList(studentIdStr.split(", "));
        List<Integer> classSumList = new ArrayList<>();
        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n";
        if (studentIds.size() != 0) {
            List<Student> students = StudentData.getStudents().stream()
                    .filter(item -> studentIds.contains(item.getStudentId()))
                    .collect(Collectors.toList());

            for (Student student : students) {
                Integer sum = student.getSubject().getMath() + student.getSubject().getLanguage() + student.getSubject().getEnglish() + student.getSubject().getProgram();
                classSumList.add(sum);
                result += (student.getName() + "|");
                result += (student.getSubject().getMath().toString() + "|");
                result += (student.getSubject().getLanguage().toString() + "|");
                result += (student.getSubject().getEnglish().toString() + "|");
                result += (student.getSubject().getProgram().toString() + "|");
                result += (sum + "|");
                result += (sum / 4.00 + "\n");
            }
            Integer Median;
            if (classSumList.size() % 2 == 0) {
                Median = (classSumList.get(classSumList.size() / 2 - 1) + classSumList.get(classSumList.size() / 2)) / 2;
            } else {
                Median = classSumList.get(classSumList.size() / 2);
            }
            result += ("========================\n" +
                    "全班总分平均数：" + classSumList.stream().mapToDouble(Integer::intValue).sum() / classSumList.size() + "\n" +
                    "全班总分中位数：" + Median);
            return result;
        }
        //todo

        return null;
    }
}
