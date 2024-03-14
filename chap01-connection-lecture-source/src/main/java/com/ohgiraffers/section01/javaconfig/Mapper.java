package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

    @Select("select curdate() from dual")
    java.util.Date selectSysdate();
}
