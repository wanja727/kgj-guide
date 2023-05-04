package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {


    List<Review> findByCafeCafeId(String cafeId);

//    @Query("select new com.wanja727.kgjguide.dto.MostSeletedScoreDTO(a.comfortScore) "+
//             "from Review a "+
//            "where a.cafe.cafeId = :cafeId "+
//            "group by a.comfortScore "+
//            "order by count(a.comfortScore) desc, a.comfortScore desc")
//    List<MostSeletedScoreDTO> getMostSelected(@Param("cafeId") String cafeId);

}
