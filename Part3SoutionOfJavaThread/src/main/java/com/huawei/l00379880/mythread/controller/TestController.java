/***********************************************************
 * @Description : 测试的接口
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 17:27
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "多线程方法的测试接口")
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping("/1")
    @ApiOperation("就是测试下")
    String test1() {
        return "test";
    }
}
