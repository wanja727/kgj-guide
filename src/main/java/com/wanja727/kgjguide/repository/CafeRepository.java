package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.entity.Cafe;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, String>, QuerydslPredicateExecutor<Cafe> { //CafeRepositoryCustom

    @Query("select new com.wanja727.kgjguide.dto.CafeDto(a.bizesId, a.openBizesNm, a.brchNm, a.indsSclsNm, a.bldNm, a.rdnmAdr, distance(:currPoint, a.point, true)) "+
            "from Cafe a "+
            "where dwithin(:currPoint, a.point, 500, true) = true "+
            "order by distance(:currPoint, a.point, true)")
    List<CafeDto> getCafeList(@Param("currPoint") Point currPoint);
}
