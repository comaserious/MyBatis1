package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sf;

    public static SqlSession getSqlSession(){
        if(sf == null){
            try {
                InputStream i = Resources.getResourceAsStream("com/ohgiraffers/section01/xmlconfig/mybatis-config.xml");
                sf = new SqlSessionFactoryBuilder().build(i);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return sf.openSession(false);
    }
}
