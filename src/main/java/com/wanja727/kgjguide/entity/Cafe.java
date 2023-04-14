package com.wanja727.kgjguide.entity;

import lombok.*;
import org.hibernate.annotations.Comment;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cafe {

    @Id
	@Column(length = 20)
	@Comment("상가업소번호")
    private String bizesId;

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

	// 거리계산을 위하여 경도/위도 대신 point
	@Column
	private Point point;

//	private double lon; // 경도
//	private double lat; // 위도

//	@Transient
//	private double distance;

//	public Cafe(String number, String 커피인류고래힐점, String s, String s1, String 래미안힐스테이트고덕, String s2, double v, double v1) {

//	}
}
