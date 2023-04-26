package com.wanja727.kgjguide.entity;

import com.wanja727.kgjguide.constant.StoreSize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString(exclude = {"user", "cafe"})
public class Review extends BaseEntity {

    @Id
    @Column
    @Comment("리뷰ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @Enumerated(EnumType.STRING)
    @Comment("매장 크기")
    private StoreSize storeSize;

    @Column
    @Comment("층수")
    private Long floor;

    @Column
    @Comment("콘센트 점수")
    private float consentScore;

    @Column
    @Comment("와이파이 점수")
    private float wifiScore;

    @Column
    @Comment("편안함 점수")
    private float comfortScore;

    @Column
    @Comment("내용")
    private String content;
}