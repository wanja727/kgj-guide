package com.wanja727.kgjguide.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.StoreSize;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CafeDto {

    private String cafeId; // 카페ID

    private String cafeNm; // 카페명

    private String brchNm; // 지점명

    private String indsSclsNm; // 상권업종소분류명

    private String bldNm; // 건물명

    private String rdnmAdr; // 도로명주소

    private double dist; // 지도중심에서 카페까지 거리 계산결과

    @JsonIgnore
    private Geometry geometry;

    private double lat;

    private double lng;

    private StoreSize storeSize;

    private Floor floor;

    private int consentScoreRep;

    private int wifiScoreRep;

    private int comfortScoreRep;

    private int reviewCnt;
}
