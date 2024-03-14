package com.ohgiraffers.section01.xmlconfig;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class Application {

    public static void main(String[] args) {

        getSqlSession();
        // sqlSessionFactory는 공유 되고 있고
        // sqlSession은 새로운 인스턴스가 생성되고 있다

    }
}
