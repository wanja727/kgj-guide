package com.wanja727.kgjguide.dto;

import com.wanja727.kgjguide.constant.StoreSize;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Users;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReviewDTO {

    private Long reviewId;

    private Long userId;

    private String cafeId;

    private StoreSize storeSize;

    private Long floor;

    private float consentScore;

    private float wifiScore;

    private float comfortScore;

    private String content;

}
