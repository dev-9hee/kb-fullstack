package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

// MyBatis 를 사용하여 데이터베이스로부터 현재 시스템 시간을 가져오는 TimeMapper 라는 인터페이스를 정의
public interface TimeMapper {
    // getTime() 메서드가 호출될 때 이 SQL 쿼리를 실행하도록 매핑
    @Select("SELECT sysdate()") // 데이터베이스의 현재 시스템 시간을 반환하는 SQL 쿼리
    public String getTime();

    public String getTime2();
}
