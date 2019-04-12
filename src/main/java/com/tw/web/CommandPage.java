package com.tw.web;

public class CommandPage {

    public void mainPage() {
        System.out.print("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：");
    }

    public void inputStudentInfoPage() {
        System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }

    public void inputStudentInfoAgainPage() {
        System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
    }

    public void inputStudentIdPage() {
        System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }
    public void inputStudentIdAgainPage() {
        System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public void inputStudentSuccessPage(String name) {
        System.out.println("学生" + name + "的成绩被添加");
    }
    public void showStudentSubject(String result){
        System.out.println(result);
    }
}
