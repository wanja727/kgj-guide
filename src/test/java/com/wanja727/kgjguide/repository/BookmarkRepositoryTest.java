package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.StoreSize;
import com.wanja727.kgjguide.entity.Bookmark;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Review;
import com.wanja727.kgjguide.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
@Transactional
@Rollback(value = false) // 트랜젝션 끝날때 update 반영되는지 확인하기 위해서 Rollback 껐음
class BookmarkRepositoryTest {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    UsersRepository usersRepository;

    @Order(1)
    @Test
    @DisplayName("북마크 저장 테스트")
    public void testInsert() {

        Cafe cafe = cafeRepository.findById("16654572").orElseThrow(EntityNotFoundException::new);
        Users users = usersRepository.findByEmail("wanja727@gmail.com").orElseThrow(EntityNotFoundException::new);

        Bookmark bookmark = Bookmark.builder()
                .user(users)
                .cafe(cafe)
                .build();

        bookmarkRepository.save(bookmark);

    }

    @Order(2)
    @Test
    @DisplayName("북마크 삭제 테스트")
    @Disabled
    public void testDelete() {

        bookmarkRepository.deleteById(1L);
    }

    @Order(2)
    @Test
    @DisplayName("유저 북마크 목록 조회")
//    @Disabled
    public void selectByUserIdtest() {

        List<Bookmark> byUserUserId = bookmarkRepository.findByUserUserId(1L);

        byUserUserId.forEach(bookmark -> {
            System.out.println("bookmark = " + bookmark.getCafe().getCafeNm());
        });
    }


}