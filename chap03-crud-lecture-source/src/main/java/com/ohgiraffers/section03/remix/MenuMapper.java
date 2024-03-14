package com.ohgiraffers.section03.remix;



import java.util.List;

public interface MenuMapper {


    List<MenuDto> selectAllMenu();

    MenuDto selectMenuByCode(int code);

    int registMenu(MenuDto menu);

    int updateMenu(MenuDto menuDto);

    int deleteMenu(int code);

}
