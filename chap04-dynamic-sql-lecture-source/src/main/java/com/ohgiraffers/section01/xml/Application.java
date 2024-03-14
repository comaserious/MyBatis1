package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application {


    public static void main(String[] args) {

        /*필기. myBatis 의 동적 SQL 확인하기*/

        Scanner scr = new Scanner(System.in);

        do{
            System.out.println("===================MyBatis 동적 SQL===================");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 :
                    ifSubMenu();
                    break;
                case 2 :
                    chooseSubMenu();
                    break;
                case 3 :
                    foreachSubMenu();
                    break;
                case 4 :
                    trimSubMenu();
                    break;
                case 9 :
                    System.out.println("시스템을 종료합니다"); return;
                default:
                    System.out.println("잘못입력하셨습니다 다시 입력해주세요"); break;
            }



        }while(true);



    }

    private static void trimSubMenu() {

        Scanner scr = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("=================trim=========================");
            System.out.println("1. 검색 조건이 있는 경우 메뉴코드로 조회 , 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리코드로 검색 ,\n 단 메뉴와 카테고리 코드 둘다 일치하는 경우도 검색하며,\n 검색조건이 없는 경우 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9 . 이전메뉴로");
            System.out.print("메뉴를 선택하세요 : ");
            int no = scr.nextInt();

            switch (no) {
                case 1 :
                    menuService.searchMenuByCodeOrSearchAll(inputAllorOne());
                    break;
                case 2 :
                    menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap());
                    break;
                case 3 :
                    menuService.modifyMenu(inputChangeInfo());
                    break;
                case 9 : return;

            }
        }while(true);
    }

    private static Map<String,Object> inputChangeInfo() {

        Scanner scr = new Scanner(System.in);
        Map<String,Object> map = new HashMap<>();
        System.out.print("변경할 메뉴 코드를 입력해주세요 : ");
        int code = scr.nextInt();
        System.out.print("변경할 메뉴의 이름을 입력해주세요 : ");
        scr.nextLine();
        String name = scr.nextLine();
        System.out.print("변경할 카테고리 코드를 입력해주세요 : ");
        int categoryCode = scr.nextInt();
        System.out.print("판매 여부를 결정해주세요 :  ");
        scr.nextLine();
        String orderableStatus = scr.nextLine();

        map.put("code",code);
        map.put("name",name);
        map.put("categoryCode",categoryCode);
        map.put("orderableStatus",orderableStatus);

        return map;
    }

    private static Map<String,Object> inputSearchCriteriaMap() {
        Scanner scr =new Scanner(System.in);
        System.out.print("검색할 조건을 입력하세요(category or name or both or null) : ");
        String condition = scr.nextLine();
        Map<String,Object> criteria = new HashMap<>();
        if(condition.equals("category")){
            System.out.print("검색할 카테고리를 입력하세요 : ");
            int categoryValue = scr.nextInt();
            criteria.put("categoryValue", categoryValue);
        }else if (condition.equals("name")){
            System.out.print("검색할 메뉴의 이름을 입력하세요 : ");
            String nameValue = scr.nextLine();
            criteria.put("nameValue",nameValue);

        }else if (condition.equals("both")){
            System.out.print("카테고리 코드를 입력하세요 : ");
            int categoryValue = scr.nextInt();
            scr.nextLine();
            System.out.print("이름을 입력하세요 : ");
            String nameValue = scr.nextLine();

            criteria.put("categoryValue",categoryValue);
            criteria.put("nameValue",nameValue);

        }
        return criteria;
    }

    private static SearchCriteria inputAllorOne() {
        Scanner scr = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까 ? 예 or 아니오  : ");
        boolean hasSearchValue = "예".equals(scr.nextLine()) ;
        SearchCriteria searchCriteria =new SearchCriteria();
        if(hasSearchValue) {
            System.out.print("검색할 메뉴 코드를 입력하세요 : ");
            String code = scr.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);

        }
        return searchCriteria;
    }

    private static void foreachSubMenu() {
        Scanner scr = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("===============foreach=================");
            System.out.println("1. 랜덤한 메뉴 5개 조회하기");
            System.out.println("9. 이전메뉴로");
            int no = scr.nextInt();
            switch (no){
                case 1 :
                    menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList());
                    break;
                case 9 : return;
            }




        }while(true);
    }

    private static List<Integer> createRandomMenuCodeList() {

        Set<Integer> set = new TreeSet<>();

        while(set.size()<5){
            set.add((int)(Math.random()*22)+7);
        }
        List<Integer> list = new ArrayList<>(set);


        return  list;

    }

    private static void chooseSubMenu() {
        Scanner scr = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("=====================choose====================");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기 (식사,음료 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력해주세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 :
                    menuService.searchMenuBySuperCategory(inputSupCategory());
                    break;
                case 9 : return;

            }


        }while(true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner scr = new Scanner(System.in);
        System.out.print("상위 분류를 선택하세요 : 식사 음료 디저트");
        String value = scr.nextLine();

        return new SearchCriteria("category",value);
    }

    private static void ifSubMenu() {

        Scanner scr = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("================if 서브 메뉴==================");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 ");
            System.out.print("원하는 메뉴를 선택하세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 : menuService.selectMenuByPrice(inputPrice());break;
                case 2 : menuService.searchMenu(inputSearchCriteria()); break;
                case 9 : return;

            }
        }while(true);
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner scr = new Scanner(System.in);
        System.out.print("검색 기준을 입력해주세요 (name or category) : ");
        String condition = scr.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = scr.nextLine();


      return new SearchCriteria(condition,value);
    }

    private static int inputPrice() {

        Scanner scr = new Scanner(System.in);
        System.out.print("메뉴의 최대가격을 적으시오 : ");
        int price = scr.nextInt();

        return price;
    }
}
