package com.xdclass.test;

import com.xdclass.busi.QryBusi;
import com.xdclass.busi.impl.QryBusiImpl;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void  testList() {
        QryBusi qryBusi = new QryBusiImpl();
        List list = qryBusi.queryList(2);
        System.out.println(list);
    }

    @Test
    public void testUpdate() {
        QryBusi qryBusi = new QryBusiImpl();
        List list = qryBusi.queryList(2);
        qryBusi.modifyListStatus(list, "10D");
    }

}
