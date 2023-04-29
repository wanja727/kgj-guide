package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.constant.Authority;
import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.Role;
import com.wanja727.kgjguide.constant.StoreSize;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Review;
import com.wanja727.kgjguide.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    UsersRepository usersRepository;

    private GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    // 카페정보 등록
    public Cafe createCafe() {
        Cafe cafe = Cafe.builder()
                .cafeId("16654572")
                .cafeNm("커피인류고래힐점")
                .brchNm("")
                .indsSclsNm("커피전문점/카페/다방")
                .bldNm("래미안힐스테이트고덕")
                .rdnmAdr("서울특별시 강동구 아리수로50길 50")
                .point(geometryFactory.createPoint(new Coordinate(127.148577656864, 37.55767790921)))
                .build();

        return cafe;
    }
    // 사용사 등록
    public Users createUser() {
        Users users = Users.builder()
                .authority(Authority.WRITE)
                .email("wanja727@naver.com")
                .name("김제완")
                .picture("")
                .role(Role.USER)
                .build();

        return users;
    }

    @Test
    @DisplayName("리뷰 등록 테스트")
    void saveReviewTest() {
        Cafe cafe = createCafe();
        cafeRepository.save(cafe);

        Users users = createUser();
        usersRepository.save(users);

        Review review = Review.builder()
                .cafe(cafe)
                .user(users)
                .consentScore(3)
                .comfortScore(4)
                .wifiScore(2)
                .floor(Floor.MORE)
                .content("콘센트는 적지만 와이파이 빵빵하고 괜찮네요")
                .storeSize(StoreSize.MEDIUM)
                .build();

        reviewRepository.save(review);
    }

}