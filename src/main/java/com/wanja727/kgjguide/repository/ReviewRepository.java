package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.dto.MostSeletedScoreDTO;
import com.wanja727.kgjguide.entity.Review;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 리뷰 등록시 카페의 평점 계산해야 함

    List<Review> findByCafeCafeId(String cafeId);

    @Query("select new com.wanja727.kgjguide.dto.MostSeletedScoreDTO(a.comfortScore) "+
             "from Review a "+
            "where a.cafe.cafeId = :cafeId "+
            "group by a.comfortScore "+
            "order by count(a.comfortScore) desc, a.comfortScore desc")
    List<MostSeletedScoreDTO> getMostSelected(@Param("cafeId") String cafeId);

}
