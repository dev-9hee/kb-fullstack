package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {
        "org.scoula.controller",
        "org.scoula.exception",
        "org.scoula.board.controller"
}) // Spring MVC 용 컴포넌트 등록을 위한 스캔 페이지
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) { // 이 메서드는 주로 단순한 URL 매핑을 설정하기 위해 사용
        // ViewControllerRegistry 는 컨트롤러 로직 없이 뷰(view)로 바로 매핑할 수 있는 간단한 요청 경로 설정을 돕는 클래스
        registry.addViewController("/") // 루트 URL /에 대해 ViewController 를 추가
                .setViewName("forward:/resources/index.html"); // /로 들어오는 모든 요청을 /resources/index.html 로 포워드하도록 설정
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ResourceHandlerRegistry 클래스는 요청된 URL 과 실제 리소스 파일 시스템 경로를 매핑하는 데 사용
        registry
                .addResourceHandler("/resources/**") // url 이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/"); // webapp/resources/경로로 매핑
        // Spring MVC 에서 정적 리소스(이미지, CSS 파일, JavaScript 파일 등)의 경로를 설정
        registry.addResourceHandler("/assets/**") // 요청된 URL 패턴과 이를 처리할 리소스 핸들러를 등록
                .addResourceLocations("/resources/assets/"); // 실제 파일이 존재하는 위치를 설정
    }

    // jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);
    }
}
