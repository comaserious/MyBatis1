package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("================메퍼 element 테스트 메뉴===============");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 테스트");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 테스트 서브메뉴");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = scr.nextInt();
            switch (no){
                case 1 :
                    elementTestService.selectCacheTest();
                    break;
                case 2 :
                    elementTestService.resultMapSubMenu();
                    break;
                case 3 : break;
                case 4 : break;

            }
        }while(true);


    }
}
