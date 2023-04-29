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

    // 주변 카페 목록 조회
    public List<CafeDto> getCafeList(double lng, double lat) {

        Point currPoint = geometryFactory.createPoint(new Coordinate(lng, lat));
        List<CafeDto> cafeList = cafeRepository.getCafeList(currPoint);
        log.info("cafeList.size() = " + cafeList.size());

        cafeList.forEach(cafeDto -> {
            Geometry latlng = cafeDto.getGeometry();
            double x = latlng.getCoordinate().getX();
            double y = latlng.getCoordinate().getY();
            cafeDto.setLat(y);
            cafeDto.setLng(x);
        });

        return cafeList;
    }

    public CafeDetailDTO getCafeInfo(String cafeId) throws Exception {
        // 결과 DTO 선언
        CafeDetailDTO cafeDetailDTO = new CafeDetailDTO();

        // 리뷰 목록
        List<Review> reviewList = reviewRepository.findByCafeCafeId(cafeId);
        // Entity -> DTO변환
        List<ReviewDTO> reviewDTOList = reviewList.stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
        // 결과 DTO에 리뷰 목록 세팅
        cafeDetailDTO.setReviewDTOList(reviewDTOList);

        // 카페 정보
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

        return cafeDetailDTO;
    }
}
