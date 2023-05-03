package com.wanja727.kgjguide.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
@Builder
public class MostSeletedScoreDTO {

    int score;

    public MostSeletedScoreDTO(int score){
        this.score = score;
    }
}
