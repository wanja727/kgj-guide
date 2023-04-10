package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Cafe;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class CafeRepositoryTest {

    @Autowired
    private CafeRepository cafeRepository;

    @Test
    @DisplayName("카페 저장 테스트")
    public void testInsert() {
        List<Cafe> cafeList = new ArrayList<Cafe>();

        cafeList.add(new Cafe("16654572","커피인류고래힐점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148577656864,37.55767790921));
        cafeList.add(new Cafe("16188265","더텐PC카페","더텐PC","커피전문점/카페/다방","강일타워","서울특별시 강동구 아리수로93길 27",127.173797947816,37.5656151686338));
        cafeList.add(new Cafe("12080498","커피클래식","","커피전문점/카페/다방","","서울특별시 강동구 아리수로64길 22",127.153439895287,37.5610918249633));
        cafeList.add(new Cafe("16047415","이디야커피","고덕래미안힐스점","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148519736767,37.5577946285561));
        cafeList.add(new Cafe("17014690","홀트강동복지관","","커피전문점/카페/다방","홀트강동복지관","서울특별시 강동구 아리수로93길 41",127.17324797717,37.5662150250254));
        cafeList.add(new Cafe("25398615","스테이지28카페","","커피전문점/카페/다방","","서울특별시 강동구 아리수로61길 105",127.146934200676,37.5658205798925));
        cafeList.add(new Cafe("16675641","오션스터디카페","강일점","커피전문점/카페/다방","강일큐브","서울특별시 강동구 아리수로 423",127.17429410087,37.5647626379122));
        cafeList.add(new Cafe("16160024","JOO인테리어가구카페","JOO인테리어가구","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148519736767,37.5577946285561));
        cafeList.add(new Cafe("16039944","한방애차","","전통찻집/인삼찻집","임페리얼타워","서울특별시 강동구 아리수로93길 19",127.174094920627,37.5653739617982));
        cafeList.add(new Cafe("15995178","복고다방","고덕하나로마트점","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148519736767,37.5577946285561));
        cafeList.add(new Cafe("23203185","커피베이강동강일점","강동강일점","커피전문점/카페/다방","강일리버파크3단지아파트","서울특별시 강동구 아리수로93길 40",127.175090469376,37.5654259747658));
        cafeList.add(new Cafe("17509550","냥냥하우스","","애견카페","강일프라자","서울특별시 강동구 아리수로93길 33-9",127.173174222586,37.5657189286176));
        cafeList.add(new Cafe("17450884","피넛커피","강동점","커피전문점/카페/다방","","서울특별시 강동구 아리수로 376-1",127.169934774758,37.5618216626877));
        cafeList.add(new Cafe("17851427","디저트카페제이","","커피전문점/카페/다방","아이메디컬","서울특별시 강동구 아리수로93나길 38",127.174090013757,37.5719696427688));
        cafeList.add(new Cafe("17867292","메가엠지씨커피고덕래미안점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148577656864,37.55767790921));
        cafeList.add(new Cafe("17967779","원유로스페셜티강동구","강일동점","커피전문점/카페/다방","강동리버스트6단지","서울특별시 강동구 아리수로93가길 87",127.171516110799,37.5713208701938));
        cafeList.add(new Cafe("17913627","컴포즈커피","강동강일점","커피전문점/카페/다방","아이메디컬","서울특별시 강동구 아리수로93나길 38",127.174090013757,37.5719696427688));
        cafeList.add(new Cafe("18628343","메가엠지씨커피강일","리버파크점","커피전문점/카페/다방","골드프라자","서울특별시 강동구 아리수로93길 9",127.174334204355,37.5652314667596));
        cafeList.add(new Cafe("18884457","매머드커피고덕래미안점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",127.148577656864,37.55767790921));

        cafeList.forEach(cafe -> {
            Cafe result = cafeRepository.save(cafe);
            log.info("BIZESID: " + result.getBizesId());
        });
    }

    @Test
    @DisplayName("상가업소번호로 카페 조회 테스트")
    public void testSelect() {
        String bizesId = "17509550";

        Optional<Cafe> result = cafeRepository.findById(bizesId);

        Cafe cafe = result.orElseThrow();

        log.info(cafe);
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0,5);

        Page<Cafe> result = cafeRepository.findAll(pageable);

        log.info("total count: "+result.getTotalElements());
        log.info("total pages: "+result.getTotalPages());
        log.info("page number: "+result.getNumber());
        log.info("page size: "+result.getSize());

        List<Cafe> cafeList = result.getContent();

        cafeList.forEach(cafe -> log.info(cafe));
    }



}