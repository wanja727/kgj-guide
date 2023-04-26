package com.wanja727.kgjguide.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CafeDto {

    private String cafeId;

    private String cafeNm; // 상호명

    private String brchNm; // 지점명

    private String indsSclsNm; // 상권업종소분류명

    private String bldNm; // 건물명

    private String rdnmAdr; // 도로명주소

    private double dist; // 현재위치에서 카페까지의 직선거리 계산결과

    @JsonIgnore
    private Geometry latlng;

    private double lat; //

    private double lng; //
}
