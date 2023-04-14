package com.wanja727.kgjguide.repository;

import com.querydsl.core.BooleanBuilder;
import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.QCafe;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
class CafeRepositoryTest {

    @Autowired
    private CafeRepository cafeRepository;

    private GeometryFactory geometryFactory = new GeometryFactory();

    @Order(1)
    @Test
    @DisplayName("카페목록 저장 테스트")
    public void testInsert() {

        // 카페정보 저장할 List
        List<Cafe> cafeList = new ArrayList<>();

        // 도로명주소 "아리수로" 위치한 카페목록 - 18건
        cafeList.add(new Cafe("16654572","커피인류고래힐점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921))));
        cafeList.add(new Cafe("16188265","더텐PC카페","더텐PC","커피전문점/카페/다방","강일타워","서울특별시 강동구 아리수로93길 27",geometryFactory.createPoint( new Coordinate(127.173797947816,37.5656151686338))));
        cafeList.add(new Cafe("12080498","커피클래식","","커피전문점/카페/다방","","서울특별시 강동구 아리수로64길 22",geometryFactory.createPoint( new Coordinate(127.153439895287,37.5610918249633))));
        cafeList.add(new Cafe("16047415","이디야커피","고덕래미안힐스점","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561))));
        cafeList.add(new Cafe("17014690","홀트강동복지관","","커피전문점/카페/다방","홀트강동복지관","서울특별시 강동구 아리수로93길 41",geometryFactory.createPoint( new Coordinate(127.17324797717,37.5662150250254))));
        cafeList.add(new Cafe("25398615","스테이지28카페","","커피전문점/카페/다방","","서울특별시 강동구 아리수로61길 105",geometryFactory.createPoint( new Coordinate(127.146934200676,37.5658205798925))));
        cafeList.add(new Cafe("16675641","오션스터디카페","강일점","커피전문점/카페/다방","강일큐브","서울특별시 강동구 아리수로 423",geometryFactory.createPoint( new Coordinate(127.17429410087,37.5647626379122))));
        cafeList.add(new Cafe("16160024","JOO인테리어가구카페","JOO인테리어가구","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561))));
        cafeList.add(new Cafe("16039944","한방애차","","전통찻집/인삼찻집","임페리얼타워","서울특별시 강동구 아리수로93길 19",geometryFactory.createPoint( new Coordinate(127.174094920627,37.5653739617982))));
        cafeList.add(new Cafe("15995178","복고다방","고덕하나로마트점","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561))));
        cafeList.add(new Cafe("23203185","커피베이강동강일점","강동강일점","커피전문점/카페/다방","강일리버파크3단지아파트","서울특별시 강동구 아리수로93길 40",geometryFactory.createPoint( new Coordinate(127.175090469376,37.5654259747658))));
        cafeList.add(new Cafe("17509550","냥냥하우스","","애견카페","강일프라자","서울특별시 강동구 아리수로93길 33-9",geometryFactory.createPoint( new Coordinate(127.173174222586,37.5657189286176))));
        cafeList.add(new Cafe("17450884","피넛커피","강동점","커피전문점/카페/다방","","서울특별시 강동구 아리수로 376-1",geometryFactory.createPoint( new Coordinate(127.169934774758,37.5618216626877))));
        cafeList.add(new Cafe("17851427","디저트카페제이","","커피전문점/카페/다방","아이메디컬","서울특별시 강동구 아리수로93나길 38",geometryFactory.createPoint( new Coordinate(127.174090013757,37.5719696427688))));
        cafeList.add(new Cafe("17867292","메가엠지씨커피고덕래미안점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921))));
        cafeList.add(new Cafe("17967779","원유로스페셜티강동구","강일동점","커피전문점/카페/다방","강동리버스트6단지","서울특별시 강동구 아리수로93가길 87",geometryFactory.createPoint( new Coordinate(127.171516110799,37.5713208701938))));
        cafeList.add(new Cafe("17913627","컴포즈커피","강동강일점","커피전문점/카페/다방","아이메디컬","서울특별시 강동구 아리수로93나길 38",geometryFactory.createPoint( new Coordinate(127.174090013757,37.5719696427688))));
        cafeList.add(new Cafe("18628343","메가엠지씨커피강일","리버파크점","커피전문점/카페/다방","골드프라자","서울특별시 강동구 아리수로93길 9",geometryFactory.createPoint( new Coordinate(127.174334204355,37.5652314667596))));
        cafeList.add(new Cafe("18884457","매머드커피고덕래미안점","","커피전문점/카페/다방","래미안힐스테이트고덕","서울특별시 강동구 아리수로50길 50",geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921))));

        // 도로명주소 "고덕로" 위치한 카페목록 - 77건
        cafeList.add(new Cafe("25299054","커피하우스","","커피전문점/카페/다방","삼익그린맨션","서울특별시 강동구 고덕로 210",geometryFactory.createPoint( new Coordinate(127.147048586973,37.5538013497357))));
        cafeList.add(new Cafe("23476791","카페까사데","","커피전문점/카페/다방","고덕삼환고층아파트","서울특별시 강동구 고덕로62길 126",geometryFactory.createPoint( new Coordinate(127.151852114316,37.5493847394624))));
        cafeList.add(new Cafe("12451227","소커피암사점","암사점","커피전문점/카페/다방","부강빌딩","서울특별시 강동구 고덕로 106",geometryFactory.createPoint( new Coordinate(127.13699008317,37.5545211868))));
        cafeList.add(new Cafe("16768691","썸베이크","","커피전문점/카페/다방","상일BUS종점차고지","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902))));
        cafeList.add(new Cafe("16598133","스타벅스","강동암사DT점","커피전문점/카페/다방","","서울특별시 강동구 고덕로 43",geometryFactory.createPoint( new Coordinate(127.13000020369,37.5551006269805))));
        cafeList.add(new Cafe("16740801","카페아이엠티","고덕메가스퀘어점","커피전문점/카페/다방","상일BUS종점차고지","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902))));
        cafeList.add(new Cafe("16674144","타임유스터디카페","상일동역점","커피전문점/카페/다방","아주빌딩","서울특별시 강동구 고덕로83길 12",geometryFactory.createPoint( new Coordinate(127.168895270422,37.5575793910593))));
        cafeList.add(new Cafe("25438048","카페엔젤","","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 133",geometryFactory.createPoint( new Coordinate(127.140331828712,37.5552483870889))));
        cafeList.add(new Cafe("16196215","하이","스트FIT수학학원","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("16195308","호야커피","암사점","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("12535968","카페베네2","","커피전문점/카페/다방","","서울특별시 강동구 고덕로 89",geometryFactory.createPoint( new Coordinate(127.135265118787,37.5549230508521))));
        cafeList.add(new Cafe("17006403","카페","도시농업파믹스센터이야기북","커피전문점/카페/다방","도시농업파믹스센터","서울특별시 강동구 고덕로 314",geometryFactory.createPoint( new Coordinate(127.160711414527,37.555620274129))));
        cafeList.add(new Cafe("17006767","요거프레소","고덕센트럴아이파크점","커피전문점/카페/다방","고덕센트럴IPARK","서울특별시 강동구 고덕로80길 99",geometryFactory.createPoint( new Coordinate(127.166390554855,37.5507677732735))));
        cafeList.add(new Cafe("16765440","공차","상일동역점","커피전문점/카페/다방","상일BUS종점차고지","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902))));
        cafeList.add(new Cafe("16955050","감성커피","상일동역점","커피전문점/카페/다방","고덕그라시움","서울특별시 강동구 고덕로 333",geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176))));
        cafeList.add(new Cafe("12671190","생각나니","","커피전문점/카페/다방","","서울특별시 강동구 고덕로61길 148",geometryFactory.createPoint( new Coordinate(127.151343819698,37.5612750087517))));
        cafeList.add(new Cafe("17080078","팔공티","","커피전문점/카페/다방","고덕그라시움","서울특별시 강동구 고덕로 333",geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176))));
        cafeList.add(new Cafe("17125772","커피충전","","커피전문점/카페/다방","","서울특별시 강동구 고덕로14길 66",geometryFactory.createPoint( new Coordinate(127.131001172777,37.5517470680262))));
        cafeList.add(new Cafe("17131496","나나니스캔디","","커피전문점/카페/다방","고덕그라시움","서울특별시 강동구 고덕로 333",geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176))));
        cafeList.add(new Cafe("17109120","Biensur","","커피전문점/카페/다방","용성빌딩","서울특별시 강동구 고덕로27길 19",geometryFactory.createPoint( new Coordinate(127.137552814725,37.5557777634037))));
        cafeList.add(new Cafe("17171830","세라젬웰카페","고덕점","커피전문점/카페/다방","고덕센트럴푸르지오","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253))));
        cafeList.add(new Cafe("23253436","카페러블리","","커피전문점/카페/다방","","서울특별시 강동구 고덕로10길 22",geometryFactory.createPoint( new Coordinate(127.129823738389,37.5537297252966))));
        cafeList.add(new Cafe("22497312","그랑카페","","커피전문점/카페/다방","","서울특별시 강동구 고덕로3길 10",geometryFactory.createPoint( new Coordinate(127.128628957005,37.5552527046732))));
        cafeList.add(new Cafe("15201763","1993주얼리","","커피전문점/카페/다방","","서울특별시 강동구 고덕로19길 8",geometryFactory.createPoint( new Coordinate(127.133859203846,37.5551380092204))));
        cafeList.add(new Cafe("16061902","떡까페마실방","","커피전문점/카페/다방","현대아파트","서울특별시 강동구 고덕로61길 37",geometryFactory.createPoint( new Coordinate(127.151938450404,37.5567469791794))));
        cafeList.add(new Cafe("17152583","홍성문커피","","커피전문점/카페/다방","신세계이마트명일점","서울특별시 강동구 고덕로 276",geometryFactory.createPoint( new Coordinate(127.155594698112,37.5547007581608))));
        cafeList.add(new Cafe("17140821","이디야커피","암사3동점","커피전문점/카페/다방","프라이어팰리스","서울특별시 강동구 고덕로 130",geometryFactory.createPoint( new Coordinate(127.140887149503,37.5541981957238))));
        cafeList.add(new Cafe("12460974","커피베이","고덕래미안점","커피전문점/카페/다방","","서울특별시 강동구 고덕로61길 104",geometryFactory.createPoint( new Coordinate(127.151660562307,37.5592949664444))));
        cafeList.add(new Cafe("23794526","콩셔틀","","커피전문점/카페/다방","","서울특별시 강동구 고덕로23길 13",geometryFactory.createPoint( new Coordinate(127.13494199384,37.5554613161049))));
        cafeList.add(new Cafe("21878825","요거프레소","암사점","커피전문점/카페/다방","부강빌딩","서울특별시 강동구 고덕로 106",geometryFactory.createPoint( new Coordinate(127.13699008317,37.5545211868))));
        cafeList.add(new Cafe("16951001","일일커피","","커피전문점/카페/다방","","서울특별시 강동구 고덕로 102",geometryFactory.createPoint( new Coordinate(127.136559831308,37.5545360623044))));
        cafeList.add(new Cafe("16232316","블링엔젤","","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("15838352","카페베네암사","","커피전문점/카페/다방","","서울특별시 강동구 고덕로 89",geometryFactory.createPoint( new Coordinate(127.135265118787,37.5549230508521))));
        cafeList.add(new Cafe("17171142","와플대학","상일동역캠퍼스","커피전문점/카페/다방","고덕그라시움","서울특별시 강동구 고덕로 333",geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176))));
        cafeList.add(new Cafe("20303047","카페이유","","커피전문점/카페/다방","","서울특별시 강동구 고덕로 52-18",geometryFactory.createPoint( new Coordinate(127.130613926305,37.5539067463908))));
        cafeList.add(new Cafe("17153261","카페밀","","커피전문점/카페/다방","","서울특별시 강동구 고덕로61길 106",geometryFactory.createPoint( new Coordinate(127.151647814458,37.5594210224169))));
        cafeList.add(new Cafe("16581121","이디야커피","암사3동점","커피전문점/카페/다방","프라이어팰리스","서울특별시 강동구 고덕로 140",geometryFactory.createPoint( new Coordinate(127.140725816202,37.554449316893))));
        cafeList.add(new Cafe("17104088","커피인류","","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("17103746","스윗퐁당","","커피전문점/카페/다방","","서울특별시 강동구 고덕로83길 158",geometryFactory.createPoint( new Coordinate(127.166090222316,37.5614701909619))));
        cafeList.add(new Cafe("20528972","다온","","커피전문점/카페/다방","삼익그린맨션","서울특별시 강동구 고덕로 210",geometryFactory.createPoint( new Coordinate(127.149445711747,37.5520075217112))));
        cafeList.add(new Cafe("17102161","디비디비딥","","커피전문점/카페/다방","우전빌딩","서울특별시 강동구 고덕로 40",geometryFactory.createPoint( new Coordinate(127.129644136818,37.5545753918183))));
        cafeList.add(new Cafe("16977092","감성커피","고덕역점","커피전문점/카페/다방","","서울특별시 강동구 고덕로 262",geometryFactory.createPoint( new Coordinate(127.154610523855,37.5546576734399))));
        cafeList.add(new Cafe("17185736","유어턴커피로스터스","","커피전문점/카페/다방","","서울특별시 강동구 고덕로20길 18-1",geometryFactory.createPoint( new Coordinate(127.13360146811,37.5539377168494))));
        cafeList.add(new Cafe("17264421","파니스","","커피전문점/카페/다방","시립서울장애인종합복지관","서울특별시 강동구 고덕로 201",geometryFactory.createPoint( new Coordinate(127.148526565486,37.5561998118108))));
        cafeList.add(new Cafe("17257032","DE1993JEWELRYCAFE","","커피전문점/카페/다방","리지빌딩","서울특별시 강동구 고덕로19길 8",geometryFactory.createPoint( new Coordinate(127.133859099567,37.5551470189916))));
        cafeList.add(new Cafe("17253045","커피베이","강동롯데캐슬퍼스트점","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 133",geometryFactory.createPoint( new Coordinate(127.140331828712,37.5552483870889))));
        cafeList.add(new Cafe("17435226","투썸플레이스","상일동역점","커피전문점/카페/다방","고덕아르테온(근린생활시설-2)","서울특별시 강동구 고덕로 360",geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375))));
        cafeList.add(new Cafe("17435278","인더후드","","커피전문점/카페/다방","고덕아르테온(근린생활시설-2)","서울특별시 강동구 고덕로 360",geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375))));
        cafeList.add(new Cafe("17497668","프롬하츠커피온조대왕문화센터점","","커피전문점/카페/다방","온조대왕문화체육관","서울특별시 강동구 고덕로 285",geometryFactory.createPoint( new Coordinate(127.157439387278,37.5567232887965))));
        cafeList.add(new Cafe("17437673","커피에반하다","상일동역점","커피전문점/카페/다방","고덕아르테온(근린생활시설-2)","서울특별시 강동구 고덕로 360",geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375))));
        cafeList.add(new Cafe("17513079","커스텀커피","강동상일점","커피전문점/카페/다방","고덕아르테온(근린생활시설-2)","서울특별시 강동구 고덕로 380",geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375))));
        cafeList.add(new Cafe("17524881","카페","프레쉬몽땅","커피전문점/카페/다방","","서울특별시 강동구 고덕로28길 10-5",geometryFactory.createPoint( new Coordinate(127.137595280389,37.5540570606798))));
        cafeList.add(new Cafe("17529162","디저트39","고덕역점","커피전문점/카페/다방","","서울특별시 강동구 고덕로 266",geometryFactory.createPoint( new Coordinate(127.155096850589,37.5546881861549))));
        cafeList.add(new Cafe("17527493","베어밀크","","커피전문점/카페/다방","","서울특별시 강동구 고덕로27길 33",geometryFactory.createPoint( new Coordinate(127.137751021138,37.5562567695086))));
        cafeList.add(new Cafe("17460952","소피스티케이트","","커피전문점/카페/다방","고덕센트럴푸르지오","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253))));
        cafeList.add(new Cafe("17687305","원유로스페셜티강동구","고덕역점","커피전문점/카페/다방","","서울특별시 강동구 고덕로 266",geometryFactory.createPoint( new Coordinate(127.155096850589,37.5546881861549))));
        cafeList.add(new Cafe("17584839","카리타로","","사주카페","삼익그린맨션","서울특별시 강동구 고덕로 210",geometryFactory.createPoint( new Coordinate(127.14921881565,37.5530511107837))));
        cafeList.add(new Cafe("17711841","카페","오메가","커피전문점/카페/다방","삼익그린맨션","서울특별시 강동구 고덕로 210",geometryFactory.createPoint( new Coordinate(127.149445711747,37.5520075217112))));
        cafeList.add(new Cafe("17871661","야옹커피","","커피전문점/카페/다방","프라이어팰리스","서울특별시 강동구 고덕로 130",geometryFactory.createPoint( new Coordinate(127.139465466806,37.553818410595))));
        cafeList.add(new Cafe("17859073","커스텀커피","강동암사점","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("17965341","펫니스","","애견카페","고덕리엔파크2단지아파트","서울특별시 강동구 고덕로 427",geometryFactory.createPoint( new Coordinate(127.172729340058,37.559885987492))));
        cafeList.add(new Cafe("17972055","원유로스페셜티강동구","상일동역점","커피전문점/카페/다방","","서울특별시 강동구 고덕로 391",geometryFactory.createPoint( new Coordinate(127.168955860414,37.5572193953854))));
        cafeList.add(new Cafe("18028320","시나본","상일동역점","커피전문점/카페/다방","고덕센트럴푸르지오","서울특별시 강동구 고덕로 399",geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253))));
        cafeList.add(new Cafe("18097314","메가엠지씨커피고덕그라시움점","","커피전문점/카페/다방","고덕그라시움(제2상가)","서울특별시 강동구 고덕로79길 29",geometryFactory.createPoint( new Coordinate(127.164702064569,37.5580634015011))));
        cafeList.add(new Cafe("18046146","피엘","엠까페","커피전문점/카페/다방","고덕그라시움","서울특별시 강동구 고덕로 333",geometryFactory.createPoint( new Coordinate(127.166240577475,37.5571191574342))));
        cafeList.add(new Cafe("18251163","제로투식스티커피","","커피전문점/카페/다방","우전빌딩","서울특별시 강동구 고덕로 40",geometryFactory.createPoint( new Coordinate(127.129644136818,37.5545753918183))));
        cafeList.add(new Cafe("18364576","이디야커피","고덕교차로","커피전문점/카페/다방","대한연세요양원","서울특별시 강동구 고덕로 421",geometryFactory.createPoint( new Coordinate(127.172553117705,37.557397839641))));
        cafeList.add(new Cafe("18429383","코드","","커피전문점/카페/다방","강동롯데캐슬퍼스트아파트","서울특별시 강동구 고덕로 131",geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847))));
        cafeList.add(new Cafe("18607628","카페35","","커피전문점/카페/다방","대명빌딩","서울특별시 강동구 고덕로20라길 5",geometryFactory.createPoint( new Coordinate(127.133956821233,37.5525707219079))));
        cafeList.add(new Cafe("18635908","담담","","커피전문점/카페/다방","","서울특별시 강동구 고덕로24길 24",geometryFactory.createPoint( new Coordinate(127.13544871715,37.5537259937506))));
        cafeList.add(new Cafe("18665828","레인바우","","커피전문점/카페/다방","","서울특별시 강동구 고덕로10길 26",geometryFactory.createPoint( new Coordinate(127.129780566447,37.5535491964013))));
        cafeList.add(new Cafe("18704869","멍핀","","커피전문점/카페/다방","","서울특별시 강동구 고덕로20라길 15",geometryFactory.createPoint( new Coordinate(127.134476865896,37.5526195878589))));
        cafeList.add(new Cafe("18683441","퍼스트커피랩","강동암사점","커피전문점/카페/다방","작은도시테라홈즈","서울특별시 강동구 고덕로20가길 27",geometryFactory.createPoint( new Coordinate(127.135455558462,37.554113497019))));
        cafeList.add(new Cafe("18771053","하이","오커피상일동역점","커피전문점/카페/다방","고덕그라시움(제1상가)","서울특별시 강동구 고덕로 353",geometryFactory.createPoint( new Coordinate(127.16439805106,37.5569078997681))));
        cafeList.add(new Cafe("18863483","카페썸머","","커피전문점/카페/다방","","서울특별시 강동구 고덕로23길 6",geometryFactory.createPoint( new Coordinate(127.135195030309,37.5551117587961))));
        cafeList.add(new Cafe("18771791","풀꽃","","전통찻집/인삼찻집","정산아파트","서울특별시 강동구 고덕로 47",geometryFactory.createPoint( new Coordinate(127.13039745085,37.5550044375247))));
        cafeList.add(new Cafe("18972626","매머드익스프레스","상일동역점","커피전문점/카페/다방","고덕그라시움(제4상가)","서울특별시 강동구 고덕로 385",geometryFactory.createPoint( new Coordinate(127.168399703426,37.5573596483776))));
        cafeList.add(new Cafe("19103356","읍천리382","상일동역점","커피전문점/카페/다방","고덕아르테온(근린생활시설-3)","서울특별시 강동구 고덕로80길 20",geometryFactory.createPoint( new Coordinate(127.165272343493,37.5556435960111))));

        // 루프돌면서 INSERT
        cafeList.forEach(cafe -> {
            Cafe result = cafeRepository.save(cafe);
            log.info("INSERT 성공 상가업소번호: " + result.getBizesId());
        });
    }

    @Order(2)
    @Test
    @DisplayName("상가업소번호로 카페 조회 테스트")
    public void testSelect() {

        String bizesId = "17509550";
        Optional<Cafe> result = cafeRepository.findById(bizesId);
        Cafe cafe = result.orElseThrow();
        log.info(cafe.toString());
    }

    @Test
    @DisplayName("페이징 테스트")
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

    @Test
    @DisplayName("Querydsl 조회 테스트")
    public void queryDslTest(){
        testInsert();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QCafe cafe = QCafe.cafe;

        booleanBuilder.and(cafe.rdnmAdr.like("%고덕로%"));

        Pageable pageable = PageRequest.of(0, 5);
        Page<Cafe> cafePagingResult = cafeRepository.findAll(booleanBuilder, pageable);
        log.info("total elements : " + cafePagingResult.getTotalElements());

        List<Cafe> resultCafeList = cafePagingResult.getContent();
        for(Cafe resultCafe: resultCafeList) {
            log.info(resultCafe.toString());
        }
    }

    @Test
    @DisplayName("근처 카페목록 조회")
    public void getCafeListTest(){
        // 현재위치
        Point currPoint = geometryFactory.createPoint( new Coordinate(127.1488309, 37.5594976) );
        // 근처 카페목록 조회
        List<CafeDto> cafeList = cafeRepository.getCafeList(currPoint);
        // 결과출력
        cafeList.forEach(cafeDto -> log.info(cafeDto.toString()));
    }

}