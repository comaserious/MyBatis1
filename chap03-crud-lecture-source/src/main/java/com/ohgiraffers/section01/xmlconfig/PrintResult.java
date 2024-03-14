package com.ohgiraffers.section01.xmlconfig;

import java.awt.*;
import java.util.List;

public class PrintResult {

    /*필기.
    *  사용자 -> 인포직원 -> 청소업체*/

    public void printMenuList(List<MenuDto> menuList) {
        System.out.println("전체 메뉴 조회의 결과");
        for(MenuDto menu : menuList){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage ="";
        switch(errorCode){
            case "selectList": errorMessage="메뉴 전체 조회를 실패했습니다"; break;
            case "selectOne" : errorMessage ="메뉴 코드로 메뉴 조회를 실패했습니다"; break;
            case "insert" : errorMessage="메뉴 입력에 실패했습니다"; break;
            case "update": errorMessage="수정 실패"; break;
            case "delete": errorMessage="삭제 실패";break;

        }

        System.out.println(errorMessage);
    }

    public void printMenu(MenuDto menuDto) {

        System.out.println(menuDto);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage ="";
        switch (successCode){
            case "insert": successMessage="입력에 성공"; break;
            case "update": successMessage="수정 완료"; break;
            case "delete" : successMessage="삭제 완료"; break;

        }
        System.out.println(successMessage);
    }
}
