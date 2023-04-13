package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.repository.CafeRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@Log4j2
class CafeServiceTest {

    @Autowired
    private CafeRepository cafeRepository;

    @Test
    @DisplayName("카페목록 조회")
    public void getCafeListTest(){
//        List<CafeDto> cafeList = cafeRepository.getCafeList(127.1488309, 37.5594976);
//
//        cafeList.forEach(cafe -> log.info(cafe.toString()));
    }

}