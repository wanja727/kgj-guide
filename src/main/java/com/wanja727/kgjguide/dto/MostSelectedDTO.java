package com.wanja727.kgjguide.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
@Builder
public class MostSelectedDTO<T> {

    T property;

    public MostSelectedDTO(T property){
        this.property = property;
    }
}
