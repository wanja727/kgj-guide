package com.wanja727.kgjguide.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CafeDto {

    private String bizesId; // 상가업소번호

    private String openBizesNm; // 상호명

    private String brchNm; // 지점명

    private String indsSclsNm; // 상권업종소분류명

    private String bldNm; // 건물명

    private String rdnmAdr; // 도로명주소

    private double lon; // 경도

    private double lat; // 위도

    private String dist; // 현재위치에서 카페까지의 직선거리 계산결과

//    @QueryProjection
//    public CafeDto(String bizesId, String openBizesNm, String brchNm, String indsSclsNm, String bldNm, String rdnmAdr, double lon, double lat, double dist) {
//        this.bizesId = bizesId;
//        this.openBizesNm = openBizesNm;
//        this.brchNm = brchNm;
//        this.indsSclsNm = indsSclsNm;
//        this.bldNm = bldNm;
//        this.rdnmAdr = rdnmAdr;
//        this.lon = lon;
//        this.lat = lat;
//        this.dist = dist;
//    }

}
