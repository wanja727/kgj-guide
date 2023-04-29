package com.wanja727.kgjguide.entity;

import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.StoreSize;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Getter @Setter
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
    @Comment("지점명")
    private String brchNm;

    @Column(length = 100)
    @Comment("상권업종소분류명")
    private String indsSclsNm;

    @Column(length = 500)
    @Comment("건물명")
    private String bldNm;

    @Column(length = 300)
    @Comment("도로명주소")
    private String rdnmAdr;

    // 거리계산을 위하여 경도/위도 대신 point
    @Column
    @Comment("위치")
    private Point point;

    @Column
    @Enumerated(EnumType.STRING)
    @Comment("매장 크기")
    private StoreSize storeSize;

    @Column
    @Enumerated(EnumType.STRING)
    @Comment("층수")
    private Floor floor;

    @Column
    @Comment("대표 콘센트 점수")
    private int consentScoreRep;

    @Column
    @Comment("대표 와이파이 점수")
    private int wifiScoreRep;

    @Column
    @Comment("대표 편안함 점수")
    private int comfortScoreRep;
}
