package com.wanja727.kgjguide.entity;

import com.wanja727.kgjguide.constant.StoreSize;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cafe extends BaseEntity {

    @Id
    @Column(length = 20)
    @Comment("카페ID")
    private String cafeId;

    @Column(length = 500)
    @Comment("카페명")
    private String cafeNm;

    @Column(length = 500)
    private String brchNm; // 지점명

    @Column(length = 100)
    private String indsSclsNm; // 상권업종소분류명

    @Column(length = 500)
    private String bldNm; // 건물명

    @Column(length = 300)
    private String rdnmAdr; // 도로명주소

    // 거리계산을 위하여 경도/위도 대신 point
    @Column
    private Point point;

    @Enumerated(EnumType.STRING)
    @Comment("매장 크기")
    private StoreSize storeSize;

    @Column
    @Comment("층수")
    private Long floor;

    @Column
    @Comment("콘센트 점수 평균")
    private float consentScoreAverage;

    @Column
    @Comment("와이파이 점수 평균")
    private float wifiScoreAverage;

    @Column
    @Comment("편안함 점수 평균")
    private float comfortScoreAverage;
}
