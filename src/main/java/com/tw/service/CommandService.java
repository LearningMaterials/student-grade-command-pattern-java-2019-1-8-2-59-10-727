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
        } else if (menuNumber == 2) {
            commandPage.inputStudentIdPage();
        } else if (menuNumber == 3) {
            System.exit(1);
        }
    }

}
