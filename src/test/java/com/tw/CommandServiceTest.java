package com.tw;

import com.tw.data.StudentData;
import com.tw.entity.Student;
import com.tw.entity.Subject;
import com.tw.service.CommandService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class CommandServiceTest {
    private CommandService commandService = new CommandService();
    private Student student = new Student();
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void init_student_date(){
        Subject subject = new Subject();
        subject.setMath(100);
        subject.setEnglish(80);
        subject.setLanguage(90);
        subject.setProgram(70);
        student.setSubject(subject);
        student.setStudentId("1562");
        student.setName("小明");
    }

    @Test
    public void main_page_info (){
        commandService.mainPage();
        Assert.assertEquals("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：", log.getLog().trim());
    }

    @Test
    public void add_student_to_studentDate (){
        Student result = commandService.addStudent("小明, 1562, 数学: 100, 语文: 90, 英语: 80, 编程: 70");

        Assert.assertEquals(student.getName(),result.getName());
        Assert.assertEquals(student.getStudentId(),result.getStudentId());
        Assert.assertEquals(student.getSubject().getEnglish(),result.getSubject().getEnglish());
        Assert.assertEquals(student.getSubject().getLanguage(),result.getSubject().getLanguage());
        Assert.assertEquals(student.getSubject().getMath(),result.getSubject().getMath());
        Assert.assertEquals(student.getSubject().getProgram(),result.getSubject().getProgram());
    }

    @Test
    public void show_student_score(){
        StudentData.add(student);
        String result = commandService.showStudentScore("1562");
        Assert.assertEquals("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "小明|100|90|80|70|340|85.0\n" +
                "========================\n" +
                "全班总分平均数：340.0\n" +
                "全班总分中位数：340", result);
    }
}
