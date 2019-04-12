package com.tw.controller;

import com.tw.service.CommandService;

import java.util.Scanner;

public class CommandController {
    CommandService commandService = new CommandService();

    public void run() {
        Scanner input = new Scanner(System.in);
        while (true){
            userSelectMenu(input);
        }
    }

    private void userSelectMenu(Scanner input) {
        commandService.mainPage();
        int menuNumber = input.nextInt();
        commandService.userSelectMenu(menuNumber);
    }
}
