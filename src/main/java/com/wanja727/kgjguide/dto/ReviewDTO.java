package com.wanja727.kgjguide.dto;

import com.wanja727.kgjguide.constant.Floor;
import com.wanja727.kgjguide.constant.StoreSize;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@Builder
public class ReviewDTO {

    private Long reviewId;

    private Long userId;

    private String cafeId;

    private StoreSize storeSize;

    private Floor floor;

    private int consentScore;

    private int wifiScore;

    private int comfortScore;

    private String content;

    private String regTime;

    private String updateTime;

    private String userEmailId;
}
