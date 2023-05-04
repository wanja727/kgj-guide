package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.dto.MostSelectedDTO;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<MostSelectedDTO> getMostSelected(String cafeId, String columnName);
}
