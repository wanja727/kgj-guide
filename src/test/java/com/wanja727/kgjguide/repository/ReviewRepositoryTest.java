package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.constant.Authority;
import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.Role;
import com.wanja727.kgjguide.constant.StoreSize;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Review;
import com.wanja727.kgjguide.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
@Transactional
@Rollback(value = false) // 트랜젝션 끝날때 update 반영되는지 확인하기 위해서 Rollback 껐음
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    UsersRepository usersRepository;

    @PersistenceContext
    EntityManager em;

    static Long reviewId = 0L;

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

    @Order(1)
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

        Review save = reviewRepository.saveAndFlush(review); // DB강제 반영 (아래 UPDATE 테스트에서 수정하기 위해)
        reviewId = save.getReviewId();
        System.out.println("등록한 ReviewId = " + reviewId);

        // 리뷰 저장후에 카페TB에 결과 반영
        //cafe.setFloor();
    }

    @Order(2)
    @Test
    @DisplayName("리뷰 수정 테스트")
    void modifyReviewTest() throws Exception {
        System.out.println("수정할 reviewId = " + reviewId);
        Review review = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        review.setContent("오늘 가니깐 완전별로였음!!!!!");
        //update는 save호출 따로 안해도 트랜젝션 끝나면 flush 되면서 수정사항 반영됨
        //reviewRepository.save(review);
    }

    @Order(3)
    @Test
    @DisplayName("리뷰 삭제 테스트")
    @Disabled
    void removeReviewTest() {

        //assumeTrue(false, () -> "테스트 안할거임");

        System.out.println("삭제할 reviewId = " + reviewId);
        reviewRepository.deleteById(reviewId);
    }

    @Test
    @DisplayName("findByReviewCafeId 테스트")
    void reivewListByCafeId() {
        List<Review> byReviewCafeId = reviewRepository.findByCafeCafeId("16654572");
        System.out.println("byReviewCafeId.size() = " + byReviewCafeId.size());
        byReviewCafeId.forEach(review -> System.out.println("review = " + review));
    }

}