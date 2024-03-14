package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /*필기.
        *  우리는 아직 view 즉 사용자들이 정보를 입력할 수 있는 화면을 배우지 않았다
        *  따라서 아직은 Application 이 view 라고 생각하고 진행을 해보자*/

        /*필기.
        *  시스템 요구사항
        *  1. 메뉴 전체 조회
        *  2. 메뉴 코드로 메뉴 조회
        *  3. 신규메뉴 추가
        *  4. 메뉴 수정
        *  5. 메뉴 삭제*/

        Scanner scr = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
            System.out.println("========================메뉴 관리 시스템=========================");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.print("메뉴 관리 번호를 입력해주세요 : ");
            int no = scr.nextInt();

            switch(no){
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2:
                    menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3:
                    menuController.registMenu(inputMenu());
                    break;
                case 4:
                    menuController.updateMenu(updateMenu());
                    break;
                case 5:
                    menuController.deleteMenu(inputMenuCode());
                    break;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다");
                    break;
            }

        }while(true);





    }


    private static Map<String,String> inputMenu() {
        Scanner scr = new Scanner(System.in);
        Map<String,String> parameter = new HashMap<>();
        /*메뉴이름, 메뉴가격,카테고리 코드 를 입력받아 넘겨준다*/
        System.out.print("메뉴 이름을 입력하세요 : ");
        String name = scr.nextLine();
        parameter.put("name",name);
        System.out.print("메뉴 가격을 입력하세요 : ");
        String price = scr.nextLine();
        parameter.put("price",price);
        System.out.print("카테고리 코드를 입력하세요 : ");
        String categoryCode = scr.nextLine();
        parameter.put("categoryCode",categoryCode);
        return parameter;
    }

    private static Map<String,String> inputMenuCode() {
        Scanner scr = new Scanner(System.in);
        System.out.print("조회할 메뉴 코드를 입력하세요 : ");
        String code = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();

        parameter.put("code",code);

        return parameter;
    }
    private static Map<String,String> updateMenu() {
        Scanner scr = new Scanner(System.in);
        Map<String,String> parameter = new HashMap<>();
        System.out.print("수정할 메뉴의 메뉴 코드를 입력하세요 : ");
        String code = scr.nextLine();
        parameter.put("code",code);
        System.out.print("수정할 메뉴의 이름을 입력하세요 : ");
        String name = scr.nextLine();
        parameter.put("name",name);
        System.out.print("수정할 가격을 입력하세요 : ");
        String price = scr.nextLine();
        parameter.put("price",price);
        System.out.print("수정할 카테고리 코드를 입력하세요 : ");
        String categoryCode = scr.nextLine();
        parameter.put("categoryCode",categoryCode);
        System.out.println("판매 상태를 입력하세요 : ");
        String orderableStatus = scr.nextLine();
        parameter.put("orderableStatus",orderableStatus);
        return parameter;
    }
}
