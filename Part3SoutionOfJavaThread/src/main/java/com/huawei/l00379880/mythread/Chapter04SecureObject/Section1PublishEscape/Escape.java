/***********************************************************
 * @Description : 对象溢出
 * 什么叫对象溢出：一种错误的发布，当一个对象还没有构造完成时，就使他被其他线程所见
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/17 08:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04SecureObject.Section1PublishEscape;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Escape {
    private int thisCanBeEscape = 0;

    private class InnerCls {
        public InnerCls() {
            // 在对象未完成构造之前就对外调用了，打印不出来信息
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
