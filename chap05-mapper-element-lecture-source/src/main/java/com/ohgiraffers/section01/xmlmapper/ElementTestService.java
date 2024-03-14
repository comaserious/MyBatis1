package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {
    private ElementTestMapper mapper;
    public void selectCacheTest() {
        SqlSession session = getSqlSession();
        mapper= session.getMapper(ElementTestMapper.class);

        for(int i = 0 ; i<10 ;i++){
            // 조회 시간 확인용 시작 시간
            Long startTime =System.currentTimeMillis();

            List<String> nameList = mapper.selectCacheTest();
            System.out.println(nameList);

            // 조회 시간 확인용 끝나는 시간
            Long endTime = System.currentTimeMillis();

            Long interval = endTime-startTime;
            System.out.println("수행에 걸린시간 " + interval+"(ms)");
        }

        session.close();

    }

    public void resultMapSubMenu() {

        Scanner scr = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("==================<resultMap> 서브메뉴===============");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <constructor> 테스트");
            System.out.print("메뉴 번호를 선택하세요 : ");
            int no = scr.nextInt();
            switch (no) {
                case 1:
                    elementTestService.selectResultMapTest();
                    break;
                case 2:
                    elementTestService.selectResultMapConstructorTest();
                    break;
            }
        }while (true);

    }

    private void selectResultMapConstructorTest() {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(ElementTestMapper.class);
        List<MenuDto> menuList = mapper.selectResultMapConstructorTest();

        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }
        session.close();
    }

    private void selectResultMapTest() {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(ElementTestMapper.class);
        List<MenuDto> menuList = mapper.selectResultMapTest();

        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }
        session.close();

    }
}
