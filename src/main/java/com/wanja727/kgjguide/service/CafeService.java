package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.CafeDetailDTO;
import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.dto.ReviewDTO;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Review;
import com.wanja727.kgjguide.repository.CafeRepository;
import com.wanja727.kgjguide.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.locationtech.jts.geom.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CafeService {

    private final ModelMapper modelMapper;

    private final CafeRepository cafeRepository;
    private final ReviewRepository reviewRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    // 현재위치 기준 주변 카페 목록 조회
    public List<CafeDto> getCafeList(double lng, double lat) {

        Point currPoint = geometryFactory.createPoint(new Coordinate(lng, lat));
        List<CafeDto> cafeList = cafeRepository.getCafeList(currPoint);
        log.info("cafeList.size() = " + cafeList.size());

        cafeList.forEach(cafeDto -> {
            // 지도에 마커 찍기 위해서 위도,경도 세팅
            Geometry latlng = cafeDto.getGeometry();
            double x = latlng.getCoordinate().getX();
            double y = latlng.getCoordinate().getY();
            cafeDto.setLat(y);
            cafeDto.setLng(x);

            cafeDto.setReviewCnt(reviewRepository.findByCafeCafeId(cafeDto.getCafeId()).size()); // 리뷰 개수 세팅
        });

        return cafeList;
    }

    public CafeDetailDTO getCafeInfo(String cafeId) throws Exception {
        // 결과 DTO 선언
        CafeDetailDTO cafeDetailDTO = new CafeDetailDTO();

        // 카페 정보 조회
        Optional<Cafe> cafe = cafeRepository.findById(cafeId);
        // 카페 없으면 에러
        if(!cafe.isPresent()){
            throw new Exception("카페 정보 결과가 없습니다.");
        }
        // Entity -> DTO 변환
        CafeDto cafeDto = CafeDto.builder()
                .cafeNm(cafe.get().getCafeNm())
                .cafeId(cafe.get().getCafeId())
                .bldNm(cafe.get().getBldNm())
                .brchNm(cafe.get().getBrchNm())
                .floor(cafe.get().getFloor())
                .lat(cafe.get().getPoint().getY()) // Point에서 lat(위도) 좌표 꺼내서 세팅
                .lng(cafe.get().getPoint().getX()) // Point에서 lng(경도) 좌표 꺼내서 세팅
                .rdnmAdr(cafe.get().getRdnmAdr())
                .consentScoreRep(cafe.get().getConsentScoreRep())
                .comfortScoreRep(cafe.get().getComfortScoreRep())
                .wifiScoreRep(cafe.get().getWifiScoreRep())
                .storeSize(cafe.get().getStoreSize())
                .indsSclsNm(cafe.get().getIndsSclsNm())
                .build();
        // 결과 DTO에 카페 정보 세팅
        cafeDetailDTO.setCafeDto(cafeDto);

        // 리뷰 목록 조회
        List<Review> reviewList = reviewRepository.findByCafeCafeId(cafeId);

        // Entity -> DTO변환
//        List<ReviewDTO> reviewDTOList = reviewList.stream()
//                .map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());

        List<ReviewDTO> reviewDTOList = reviewList.stream()
                .map(review -> ReviewDTO.builder()
                        .reviewId(review.getReviewId())
                        .userId(review.getUser().getUserId())
                        .cafeId(review.getCafe().getCafeId())
                        .storeSize(review.getStoreSize())
                        .floor(review.getFloor())
                        .consentScore(review.getConsentScore())
                        .wifiScore(review.getWifiScore())
                        .comfortScore(review.getComfortScore())
                        .content(review.getContent())
                        // 작성일시 Format
                        .regTime(review.getRegDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")))
                        .updateTime(review.getModDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")))
                        // Gmail 주소에서 id부분만 추출하여 작성자명으로 표기 wanja727@gmail.com -> wanja727
                        .userEmailId(review.getUser().getEmail().split("@")[0])
                        .build()
                ).collect(Collectors.toList());

        // 결과 DTO에 리뷰 목록 세팅
        cafeDetailDTO.setReviewDTOList(reviewDTOList);

        return cafeDetailDTO;
    }
}
