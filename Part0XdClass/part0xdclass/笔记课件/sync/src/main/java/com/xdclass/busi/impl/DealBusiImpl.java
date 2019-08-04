package com.xdclass.busi.impl;

import com.xdclass.busi.DealBusi;
import com.xdclass.consts.DataStutusConst;
import com.xdclass.middle.model.Student;
import com.xdclass.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealBusiImpl implements DealBusi {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealBusiImpl.class);

    @Override
    public void deal(List data) {
        //將data转换成业务库的实体
        List<com.xdclass.our.model.Student> students = adapter(data);
        //处理数据，并入库
        students.forEach(student -> {
            student.setName(student.getName() + "test");
            SqlSession ourSession = SqlSessionUtil.getSqlSession("our");
            try {
                ourSession.insert("com.xdclass.our.mapper.StudentMapper.insertSelective", student);
                ourSession.commit();
                //修改中间表的状态
                modifyMiddle(student.getId(), DataStutusConst.FINISH);
            } catch (Exception e) {
                LOGGER.error("处理数据发生异常=======》", e);
                //发生异常，修改中间表状态为10E
                modifyMiddle(student.getId(), DataStutusConst.ERROR);
            } finally {
                ourSession.close();
            }

        });

    }

    private void modifyMiddle(int id, String status) {
        Student student = new Student();
        student.setId(id);
        student.setDataStatus(status);
        student.setDealTime(new Date());

        SqlSession middleSession = SqlSessionUtil.getSqlSession("middle");
        try {
            middleSession.update("com.xdclass.middle.mapper.StudentMapper.updateStatusById", student);
            middleSession.commit();
        } catch (Exception e) {
            LOGGER.error("修改中间表状态失败========>",e);
        } finally {
            middleSession.close();
        }
    }

    /**
     * 数据适配
     *
     * @param students
     * @return
     */
    private List<com.xdclass.our.model.Student> adapter(List<Student> students) {
        List<com.xdclass.our.model.Student> result = new ArrayList<>();
        students.forEach(stu -> {
            com.xdclass.our.model.Student student = new com.xdclass.our.model.Student();
            student.setDepartment(stu.getDepartment());
            student.setSex(stu.getSex());
            student.setId(stu.getId());
            student.setName(stu.getName());
            student.setBirth(stu.getBirth());
            student.setAddTime(new Date());
            result.add(student);
        });
        return result;
    }
}
