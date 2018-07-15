package com.huawei.l00379880.mythread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***********************************************************
 * @Description : 启动类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 17:05
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
