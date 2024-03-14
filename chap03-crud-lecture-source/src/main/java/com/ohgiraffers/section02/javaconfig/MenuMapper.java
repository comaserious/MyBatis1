package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value={
            @Result (id = true , property="code",column = "menu_code"),
            @Result(property = "name", column = "menu_name"),
            @Result(property = "price", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })



    @Select("select menu_code\n" +
            ",menu_name\n" +
            ",menu_price\n" +
            ",category_code\n" +
            ",orderable_status\n" +
            "from tbl_menu\n" +
            "where orderable_status = 'Y'\n" +
            "order by menu_code")
    List<MenuDto> selectAllMenu();
    @Select("select menu_code \n" +
            ",menu_name \n" +
            ",menu_price \n" +
            ",category_code \n" +
            ",orderable_status \n" +
            "from tbl_menu \n" +
            "where menu_code = #{code}\n" +
            "and oderable_status = 'Y'\n" +
            "order by \n" +
            "menu_code")
    MenuDto selectMenuByCode();


    int registMenu(MenuDto menu);

    int updateMenu(MenuDto menuDto);

    int deleteMenu(int code);

}
