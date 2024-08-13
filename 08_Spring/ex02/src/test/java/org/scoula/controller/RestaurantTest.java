package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class RestaurantTest {
    @Autowired
    public Restaurant restaurant;

    @Test
    void getChef() {
        // restaurant 객체가 null 이 아님을 확인, Restaurant 빈이 스프링에 의해 성공적으로 주입되었는지 확인
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("-------------------------------");
        log.info(restaurant.getChef());
    }
}