package org.scoula.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 이 클래스도 스프링 컨테이너에 빈으로 등록
@Data // getter, setter, toString(), equals(), hashCode() 등의 메서드를 자동으로 생성
public class Restaurant {
    // @Autowired 어노테이션은 스프링이 chef 필드를 자동으로 주입하도록 지시
    // 즉, Chef 클래스의 빈이 자동으로 chef 필드에 주입
    @Autowired // Restaurant 클래스는 Chef 클래스에 의존
    private Chef chef;
}
