package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDto;

import java.util.List;

public interface ElementTestMapper {
    List<String> selectCacheTest();

    List<MenuDto> selectResultMapTest();

    List<MenuDto> selectResultMapConstructorTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuDto> selectSqlTest();
}
