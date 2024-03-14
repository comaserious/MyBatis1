package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

/*필기.
*  Service 의 역할
*  1. SqlSession 생성
*  2. DAO(데이터 베이스 접근 객체)의 메소드 호출
*  3. 트랜잭션(commit, rollback) 제어
*  4. SqlSession 닫기*/
public class MenuService {

    private final MenuDao menuDao;


    public MenuService(){
        this.menuDao = new MenuDao();

    }
    public List<MenuDto> selectAllMenu() {

        SqlSession session = getSqlSession();

        List<MenuDto> menuList = menuDao.selectAllMenu(session);
        session.close();

        return menuList;

    }


    public MenuDto selectMenuByCode(int code) {
        SqlSession session = getSqlSession();

        MenuDto menu = MenuDao.selectMenuByCode(session,code);

        session.close();

        return menu;
    }


    public boolean registMenu(MenuDto menu) {
        SqlSession session= getSqlSession();

        int result = menuDao.insertMenu(session,menu);


        // 트렌젝션
        if(result >0){
            session.commit();

        }
        else {
            session.rollback();

        }
        session.close();
        return (result > 0)? true:false;

    }

    public boolean updateMenu(MenuDto menuDto) {
        SqlSession session = getSqlSession();

        int result = menuDao.updateMenu(session,menuDto);

        if(result > 0){
            session.commit();
        }
        else{
            session.rollback();
        }
        session.close();

        return result >0 ? true:false;
    }

    public boolean deleteMenu(int code) {
        SqlSession session = getSqlSession();
        int result = menuDao.deleteMenu(session,code);
        if(result > 0 ){
            session.commit();
        }
        else{
            session.rollback();
        }
        session.close();

        return result >0 ? true: false;
    }
}
