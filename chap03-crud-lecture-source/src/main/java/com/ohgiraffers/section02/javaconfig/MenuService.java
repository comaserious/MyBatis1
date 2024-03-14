package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;
    public MenuService(){

    }

    public List<MenuDto> selectAllMenu() {

        SqlSession session = getSqlSession();

        menuMapper = session.getMapper(MenuMapper.class);

        List<MenuDto> menuList= menuMapper.selectAllMenu();

        session.close();

        return menuList;
    }

    public MenuDto selectMenuByCode(int code) {

        SqlSession session = getSqlSession();

        menuMapper = session.getMapper(MenuMapper.class);

        MenuDto menu = menuMapper.selectMenuByCode();

        session.close();

        return menu;
    }

    public boolean registMenu(MenuDto menu) {

        SqlSession session = getSqlSession();
        menuMapper = session.getMapper(MenuMapper.class);

        int result = menuMapper.registMenu(menu);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();

        return result >0 ? true:false;
    }

    public boolean updateMenu(MenuDto menuDto) {
        SqlSession session = getSqlSession();
        menuMapper = session.getMapper(MenuMapper.class);

        int result =menuMapper.updateMenu(menuDto);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }

        return result > 0 ? true:false;
    }

    public boolean deleteMenu(int code) {

        SqlSession session =getSqlSession();
        menuMapper = session.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(code);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        return result>0? true:false;
    }
}
