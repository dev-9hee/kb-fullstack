package org.scoula.board.controller;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.service.BoardService;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration // 웹 관련 빈(Bean)들이 포함된 컨텍스트를 로드한다는 뜻
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
}) // 테스트에서 사용할 애플리케이션 컨텍스트를 구성
@Log4j
class BoardControllerTest {
    @Autowired
    BoardService boardService;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc; // Spring MVC 애플리케이션을 실제 서버에 배포하지 않고도 HTTP 요청 및 응답을 테스트할 수 있게 해주는 도구

    @BeforeEach // 각 테스트 메서드가 실행되기 전에 setup() 메서드가 실행
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void list() throws Exception {

        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // ResultActions 리턴
                        .andReturn()
                        .getModelAndView()
                        .getModelMap() // Model 리턴
        );
    }

    @Test
    public void create() throws Exception {

        String resultPage = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/board/create")
                                .param("title", "테스트 새글 제목")
                                .param("content", "테스트 새글 내용")
                                .param("writer", "user1")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }

    @Test
    public void get() throws Exception {

        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("no", "1"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );
    }

    @Test
    public void update() throws Exception {

        String resultPage = mockMvc.perform(
                        MockMvcRequestBuilders.post("/board/update")
                                .param("no", "1")
                                .param("title", "수정된 테스트 새글 제목")
                                .param("content", "수정된 테스트 새글 내용")
                                .param("writer", "user00")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }

    @Test
    public void delete() throws Exception {

        String resultPage = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/board/delete")
                                .param("no", "8")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }
}