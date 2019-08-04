package com.xdclass.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {

    private static SqlSessionFactory ourSqlSessionFactory;
    private static SqlSessionFactory middleSqlSessionFactory;
    private static final String OUR = "our";
    private static final String MIDDLE = "middle";

    private static final String MIDDLE_MIDDLE = "mybatis-config-middle.xml";
    private static final String OUR_MIDDLE = "mybatis-config-our.xml";
    private static Reader middleResourceAsReader = null;
    private static Reader ourResourceAsReader = null;
    static {
        try {
             middleResourceAsReader = Resources.getResourceAsReader(MIDDLE_MIDDLE);
             ourResourceAsReader = Resources.getResourceAsReader(OUR_MIDDLE);

            middleSqlSessionFactory =  new SqlSessionFactoryBuilder().build(middleResourceAsReader);
            ourSqlSessionFactory =  new SqlSessionFactoryBuilder().build(ourResourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                middleResourceAsReader.close();
                ourResourceAsReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取sqlsession
     * @param code
     * @return
     */
    public static SqlSession getSqlSession(String code) {
        if (code.equals(MIDDLE)) {
            return middleSqlSessionFactory.openSession();
        }
        return ourSqlSessionFactory.openSession();
    }
}
