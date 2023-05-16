package com.wanja727.kgjguide.repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanja727.kgjguide.entity.QCafe;

import javax.persistence.EntityManager;
import java.util.List;

import static com.wanja727.kgjguide.entity.QCafe.cafe;

public class CafeRepositoryCustomImpl {

    private JPAQueryFactory queryFactory;

    public CafeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /*
    Projections.constructor(CafeDto.class,
                                cafe.rdnmAdr,
                                cafe.indsSclsNm,
                                cafe.lat,
                                cafe.lon,
                                cafe.bizesId,
                                cafe.bldNm,

    new QCafeDto(
                                cafe.bizesId,
                                cafe.openBizesNm,
                                cafe.brchNm,
                                cafe.indsSclsNm,
                                cafe.bldNm,
                                cafe.rdnmAdr,
                                cafe.lon,
                                cafe.lat,

                                Expressions.stringTemplate("ST_Distance_Sphere({0}, {1})",
                                        Expressions.stringTemplate("POINT({0}, {1})",
                                                lng,
                                                lat
                                        ),
                                        Expressions.stringTemplate("POINT({0}, {1})",
                                                cafe.lon,
                                                cafe.lat
                                        )
                                ).as("dist")
    * */

//    @Override
//    public List<String> getCafeList(double lat, double lng) {
//
//        List<String> content = queryFactory
//                .select(
//                       Expressions.stringTemplate("cast(ST_Distance({0}, {1})) as String",
//                                        Expressions.stringTemplate("POINT({0}, {1})",
//                                                lng,
//                                                lat
//                                        ),
//                                        Expressions.stringTemplate("POINT({0}, {1})",
//                                                cafe.lon,
//                                                cafe.lat
//                                        )
//                                ).as("dist")
//                )
//                .from(QCafe.cafe)
//
//                .fetch();
//
//        return content;
//
//    }
}
