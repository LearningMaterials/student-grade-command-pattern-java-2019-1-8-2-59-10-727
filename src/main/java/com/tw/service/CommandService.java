package com.tw.service;

import com.tw.data.StudentData;
import com.tw.web.CommandPage;

import java.util.Scanner;

public class CommandService {
    private CommandPage commandPage = new CommandPage();
    private Scanner input = new Scanner(System.in);
    private StudentData studentData = new StudentData();

    public void mainPage() {
        commandPage.mainPage();
    }
}
