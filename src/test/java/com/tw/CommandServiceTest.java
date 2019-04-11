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
}
