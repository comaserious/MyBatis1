package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDto;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;


public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price){
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);
        /*필기. 기본자료형으로는 조건문의 값을 비교할 수 없으며 hashmap 의 key 혹은 dto의
        *      getter를 이용하여 값을 확인할 수 있다*/

        Map<String ,Integer> map = new HashMap<>();
        map.put("price",price);

        List<MenuDto> menuList  =mapper.selectMenuByPrice(map);

        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색결과가 존재하지 않습니다");
        }
        session.close();

    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDto> menuList = mapper.searchMenu(searchCriteria);


        if(menuList!=null&&menuList.size()>0    ){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과가 존재 하지 않습니다");
        }



    }

    public void searchMenuBySuperCategory(SearchCriteria searchCriteria) {
        SqlSession session = getSqlSession();

        mapper = session.getMapper(DynamicSqlMapper.class);
        List<MenuDto> menuList = mapper.searchMenuBySuperCategory(searchCriteria);

        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("해당하는 카테고리에 음식이 없습니다");
        }
        session.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        Map<String,List<Integer>> criteria = new HashMap<>();
        criteria.put("randomCodeList",randomMenuCodeList);
        List<MenuDto> menuList = mapper.searchMenuByRandomMenuCode(criteria);

        if(menuList!=null&& menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("없는번호가 있음 다시 시도");
        }
        session.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDto> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList!=null && menuList.size()>0) {
            for (MenuDto menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색결과 존재하지 않음 ");
        }
    }

    public void searchMenuByNameOrCategory(Map<String, Object> stringObjectMap) {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);
        List<MenuDto> menuList = mapper.searchMenuByNameOrCategory(stringObjectMap);
        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("조회에 실패 했습니다");
        }
    }

    public void modifyMenu(Map<String, Object> stringObjectMap) {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        // dml 구문이기 때문에 int 값을 증가시키는 값을 리턴해준다 이를 받아줘서 autocommit 이 아니기 때문에 수동으로 커밋을 해주어야한다
        int result = mapper.modifyMenu(stringObjectMap);
        if(result>0){
            session.commit();
            System.out.println("수정 성공");
        }
        else{
            session.rollback();
            System.out.println("수정 실패");
        }
    }
}
