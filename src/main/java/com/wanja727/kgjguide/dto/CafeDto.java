package com.wanja727.kgjguide.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wanja727.kgjguide.constant.StoreSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Geometry;

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
    private Geometry geometry;

    private double lat; //

    private double lng; //

    private StoreSize storeSize;

    private Long floor;

    private float consentScoreAverage;

    private float wifiScoreAverage;

    private float comfortScoreAverage;
}
