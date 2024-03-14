package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.MenuDto;

import java.util.List;

public interface ElementTestMapper {
    List<String> selectCacheTest();

    List<MenuDto> selectResultMapTest();

    List<MenuDto> selectResultMapConstructorTest();
}
