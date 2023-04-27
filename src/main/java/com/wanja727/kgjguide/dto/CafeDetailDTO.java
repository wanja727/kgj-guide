package com.wanja727.kgjguide.dto;

import com.wanja727.kgjguide.entity.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CafeDetailDTO {

    private CafeDto cafeDto;

    private List<ReviewDTO> reviewDTOList;
}
