package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDao {

    public List<MenuDto> selectAllMenu(SqlSession session) {

        return session.selectList("MenuMapper.selectAllMenu");
    }
    public static MenuDto selectMenuByCode(SqlSession session, int code) {

        return session.selectOne("MenuMapper.selectMenuByCode" ,code);
    }

    public int insertMenu(SqlSession session, MenuDto menu) {
        return session.insert("MenuMapper.insertMenu",menu);
    }

    public int updateMenu(SqlSession session, MenuDto menuDto) {
        int result = session.update("MenuMapper.updateMenu",menuDto);
        return result;
    }

    public int deleteMenu(SqlSession session, int code) {

        int result = session.delete("MenuMapper.deleteMenu",code);
        return result;
    }
}
