package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeService {

    private final CafeRepository cafeRepository;

//    @GetMapping
//    public List<CafeDto> getCafeList(double lat, double lng) {
//
////        List<CafeDto> cafeList = cafeRepository.getCafeList(123, 456);
//
//        return cafeList;
//    }

}
