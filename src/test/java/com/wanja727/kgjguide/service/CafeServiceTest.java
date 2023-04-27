package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.CafeDetailDTO;
import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.dto.ReviewDTO;
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
    private CafeService cafeService;


    @Test
    @DisplayName("카페상세 조회")
    void getCafeDetailTest() throws Exception {
        CafeDetailDTO cafeInfo = cafeService.getCafeInfo("16654572");
        CafeDto cafeDto = cafeInfo.getCafeDto();
        System.out.println("cafeDto = " + cafeDto);
        List<ReviewDTO> reviewDTOList = cafeInfo.getReviewDTOList();
        reviewDTOList.forEach(reviewDTO -> System.out.println("reviewDTO = " + reviewDTO));
    }

}