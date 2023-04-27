package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.locationtech.jts.geom.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CafeService {

    private final CafeRepository cafeRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    @GetMapping
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
        } );

        return cafeList;
    }

}
