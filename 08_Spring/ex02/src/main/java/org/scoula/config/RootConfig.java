package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스가 하나 이상의 스프링 빈을 정의하고 있는 설정 클래스임을 나타냄
@ComponentScan(basePackages = {"org.scoula"}) // 이 설정은 Chef 와 Restaurant 클래스가 해당 패키지에 있을 경우, 자동으로 스프링 빈으로 등록
public class RootConfig {
}
