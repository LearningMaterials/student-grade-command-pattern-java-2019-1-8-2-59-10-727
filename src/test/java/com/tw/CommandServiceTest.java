package com.tw;

import com.tw.service.CommandService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class CommandServiceTest {
    CommandService commandService = new CommandService();

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void main_page_info (){
        commandService.mainPage();
        Assert.assertEquals("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：", log.getLog().trim());
    }

    @Test
    public void user_select_one_menu (){
        commandService.userSelect(1);
        Assert.assertEquals("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：", log.getLog().trim());
    }

    @Test
    public void user_select_Two_menu (){
        commandService.userSelect(2);
        Assert.assertEquals("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：", log.getLog().trim());
    }
}
