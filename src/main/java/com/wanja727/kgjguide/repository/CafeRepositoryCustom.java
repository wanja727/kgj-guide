package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.dto.CafeDto;

import java.util.List;

public interface CafeRepositoryCustom {

    List<String> getCafeList(double lat, double lng);
}
