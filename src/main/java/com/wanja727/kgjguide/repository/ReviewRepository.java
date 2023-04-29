package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 리뷰 등록시 카페의 평점 계산해야 함

    List<Review> findByCafeCafeId(String cafeId);

}
