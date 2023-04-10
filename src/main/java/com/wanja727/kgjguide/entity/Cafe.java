package com.wanja727.kgjguide.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cafe {

    @Id
	@Column(length = 20)
    private String bizesId; // 상가업소번호

	@Column(length = 500)
	private String openBizesNm; // 상호명

	@Column(length = 500)
	private String brchNm; // 지점명

	@Column(length = 100)
	private String indsSclsNm; // 상권업종소분류명

	@Column(length = 500)
    private String bldNm; // 건물명

	@Column(length = 300)
	private String rdnmAdr; // 도로명주소

	private double lon; // 경도
	private double lat; // 위도
}
