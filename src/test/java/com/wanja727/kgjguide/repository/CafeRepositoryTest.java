package com.wanja727.kgjguide.repository;

import com.querydsl.core.BooleanBuilder;
import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.QCafe;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
class CafeRepositoryTest {

    @Autowired
    private CafeRepository cafeRepository;

    private GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    @Order(1)
    @Test
    @DisplayName("카페목록 저장 테스트")
    public void testInsert() {

        // 카페정보 저장할 List
        List<Cafe> cafeList = new ArrayList<>();

        // 도로명주소 "아리수로" 위치한 카페목록 - 19건
        cafeList.add(Cafe.builder().cafeId("16654572").cafeNm("커피인류고래힐점").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921) )).build());
        cafeList.add(Cafe.builder().cafeId("16188265").cafeNm("더텐PC카페").brchNm("더텐PC").indsSclsNm("커피전문점/카페/다방").bldNm("강일타워").rdnmAdr("서울특별시 강동구 아리수로93길 27").point(geometryFactory.createPoint( new Coordinate(127.173797947816,37.5656151686338) )).build());
        cafeList.add(Cafe.builder().cafeId("12080498").cafeNm("커피클래식").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 아리수로64길 22").point(geometryFactory.createPoint( new Coordinate(127.153439895287,37.5610918249633) )).build());
        cafeList.add(Cafe.builder().cafeId("16047415").cafeNm("이디야커피").brchNm("고덕래미안힐스점").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561) )).build());
        cafeList.add(Cafe.builder().cafeId("17014690").cafeNm("홀트강동복지관").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("홀트강동복지관").rdnmAdr("서울특별시 강동구 아리수로93길 41").point(geometryFactory.createPoint( new Coordinate(127.17324797717,37.5662150250254) )).build());
        cafeList.add(Cafe.builder().cafeId("25398615").cafeNm("스테이지28카페").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 아리수로61길 105").point(geometryFactory.createPoint( new Coordinate(127.146934200676,37.5658205798925) )).build());
        cafeList.add(Cafe.builder().cafeId("16675641").cafeNm("오션스터디카페").brchNm("강일점").indsSclsNm("커피전문점/카페/다방").bldNm("강일큐브").rdnmAdr("서울특별시 강동구 아리수로 423").point(geometryFactory.createPoint( new Coordinate(127.17429410087,37.5647626379122) )).build());
        cafeList.add(Cafe.builder().cafeId("16160024").cafeNm("JOO인테리어가구카페").brchNm("JOO인테리어가구").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561) )).build());
        cafeList.add(Cafe.builder().cafeId("16039944").cafeNm("한방애차").brchNm("").indsSclsNm("전통찻집/인삼찻집").bldNm("임페리얼타워").rdnmAdr("서울특별시 강동구 아리수로93길 19").point(geometryFactory.createPoint( new Coordinate(127.174094920627,37.5653739617982) )).build());
        cafeList.add(Cafe.builder().cafeId("15995178").cafeNm("복고다방").brchNm("고덕하나로마트점").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148519736767,37.5577946285561) )).build());
        cafeList.add(Cafe.builder().cafeId("23203185").cafeNm("커피베이강동강일점").brchNm("강동강일점").indsSclsNm("커피전문점/카페/다방").bldNm("강일리버파크3단지아파트").rdnmAdr("서울특별시 강동구 아리수로93길 40").point(geometryFactory.createPoint( new Coordinate(127.175090469376,37.5654259747658) )).build());
        cafeList.add(Cafe.builder().cafeId("17509550").cafeNm("냥냥하우스").brchNm("").indsSclsNm("애견카페").bldNm("강일프라자").rdnmAdr("서울특별시 강동구 아리수로93길 33-9").point(geometryFactory.createPoint( new Coordinate(127.173174222586,37.5657189286176) )).build());
        cafeList.add(Cafe.builder().cafeId("17450884").cafeNm("피넛커피").brchNm("강동점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 아리수로 376-1").point(geometryFactory.createPoint( new Coordinate(127.169934774758,37.5618216626877) )).build());
        cafeList.add(Cafe.builder().cafeId("17851427").cafeNm("디저트카페제이").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("아이메디컬").rdnmAdr("서울특별시 강동구 아리수로93나길 38").point(geometryFactory.createPoint( new Coordinate(127.174090013757,37.5719696427688) )).build());
        cafeList.add(Cafe.builder().cafeId("17867292").cafeNm("메가엠지씨커피고덕래미안점").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921) )).build());
        cafeList.add(Cafe.builder().cafeId("17967779").cafeNm("원유로스페셜티강동구").brchNm("강일동점").indsSclsNm("커피전문점/카페/다방").bldNm("강동리버스트6단지").rdnmAdr("서울특별시 강동구 아리수로93가길 87").point(geometryFactory.createPoint( new Coordinate(127.171516110799,37.5713208701938) )).build());
        cafeList.add(Cafe.builder().cafeId("17913627").cafeNm("컴포즈커피").brchNm("강동강일점").indsSclsNm("커피전문점/카페/다방").bldNm("아이메디컬").rdnmAdr("서울특별시 강동구 아리수로93나길 38").point(geometryFactory.createPoint( new Coordinate(127.174090013757,37.5719696427688) )).build());
        cafeList.add(Cafe.builder().cafeId("18628343").cafeNm("메가엠지씨커피강일").brchNm("리버파크점").indsSclsNm("커피전문점/카페/다방").bldNm("골드프라자").rdnmAdr("서울특별시 강동구 아리수로93길 9").point(geometryFactory.createPoint( new Coordinate(127.174334204355,37.5652314667596) )).build());
        cafeList.add(Cafe.builder().cafeId("18884457").cafeNm("매머드커피고덕래미안점").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("래미안힐스테이트고덕").rdnmAdr("서울특별시 강동구 아리수로50길 50").point(geometryFactory.createPoint( new Coordinate(127.148577656864,37.55767790921) )).build());

        // 도로명주소 "고덕로" 위치한 카페목록 - 78건
        cafeList.add(Cafe.builder().cafeId("25299054").cafeNm("커피하우스").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("삼익그린맨션").rdnmAdr("서울특별시 강동구 고덕로 210").point(geometryFactory.createPoint( new Coordinate(127.147048586973,37.5538013497357) )).build());
        cafeList.add(Cafe.builder().cafeId("23476791").cafeNm("카페까사데").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕삼환고층아파트").rdnmAdr("서울특별시 강동구 고덕로62길 126").point(geometryFactory.createPoint( new Coordinate(127.151852114316,37.5493847394624) )).build());
        cafeList.add(Cafe.builder().cafeId("12451227").cafeNm("소커피암사점").brchNm("암사점").indsSclsNm("커피전문점/카페/다방").bldNm("부강빌딩").rdnmAdr("서울특별시 강동구 고덕로 106").point(geometryFactory.createPoint( new Coordinate(127.13699008317,37.5545211868) )).build());
        cafeList.add(Cafe.builder().cafeId("16768691").cafeNm("썸베이크").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("상일BUS종점차고지").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902) )).build());
        cafeList.add(Cafe.builder().cafeId("16598133").cafeNm("스타벅스").brchNm("강동암사DT점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 43").point(geometryFactory.createPoint( new Coordinate(127.13000020369,37.5551006269805) )).build());
        cafeList.add(Cafe.builder().cafeId("16740801").cafeNm("카페아이엠티").brchNm("고덕메가스퀘어점").indsSclsNm("커피전문점/카페/다방").bldNm("상일BUS종점차고지").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902) )).build());
        cafeList.add(Cafe.builder().cafeId("16674144").cafeNm("타임유스터디카페").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("아주빌딩").rdnmAdr("서울특별시 강동구 고덕로83길 12").point(geometryFactory.createPoint( new Coordinate(127.168895270422,37.5575793910593) )).build());
        cafeList.add(Cafe.builder().cafeId("25438048").cafeNm("카페엔젤").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 133").point(geometryFactory.createPoint( new Coordinate(127.140331828712,37.5552483870889) )).build());
        cafeList.add(Cafe.builder().cafeId("16196215").cafeNm("하이").brchNm("스트FIT수학학원").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("16195308").cafeNm("호야커피").brchNm("암사점").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("12535968").cafeNm("카페베네2").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 89").point(geometryFactory.createPoint( new Coordinate(127.135265118787,37.5549230508521) )).build());
        cafeList.add(Cafe.builder().cafeId("17006403").cafeNm("카페").brchNm("도시농업파믹스센터이야기북").indsSclsNm("커피전문점/카페/다방").bldNm("도시농업파믹스센터").rdnmAdr("서울특별시 강동구 고덕로 314").point(geometryFactory.createPoint( new Coordinate(127.160711414527,37.555620274129) )).build());
        cafeList.add(Cafe.builder().cafeId("17006767").cafeNm("요거프레소").brchNm("고덕센트럴아이파크점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕센트럴IPARK").rdnmAdr("서울특별시 강동구 고덕로80길 99").point(geometryFactory.createPoint( new Coordinate(127.166390554855,37.5507677732735) )).build());
        cafeList.add(Cafe.builder().cafeId("16765440").cafeNm("공차").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("상일BUS종점차고지").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169328836168,37.5572670727902) )).build());
        cafeList.add(Cafe.builder().cafeId("16955050").cafeNm("감성커피").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움").rdnmAdr("서울특별시 강동구 고덕로 333").point(geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176) )).build());
        cafeList.add(Cafe.builder().cafeId("12671190").cafeNm("생각나니").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로61길 148").point(geometryFactory.createPoint( new Coordinate(127.151343819698,37.5612750087517) )).build());
        cafeList.add(Cafe.builder().cafeId("17080078").cafeNm("팔공티").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움").rdnmAdr("서울특별시 강동구 고덕로 333").point(geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176) )).build());
        cafeList.add(Cafe.builder().cafeId("17125772").cafeNm("커피충전").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로14길 66").point(geometryFactory.createPoint( new Coordinate(127.131001172777,37.5517470680262) )).build());
        cafeList.add(Cafe.builder().cafeId("17131496").cafeNm("나나니스캔디").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움").rdnmAdr("서울특별시 강동구 고덕로 333").point(geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176) )).build());
        cafeList.add(Cafe.builder().cafeId("17109120").cafeNm("Biensur").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("용성빌딩").rdnmAdr("서울특별시 강동구 고덕로27길 19").point(geometryFactory.createPoint( new Coordinate(127.137552814725,37.5557777634037) )).build());
        cafeList.add(Cafe.builder().cafeId("17171830").cafeNm("세라젬웰카페").brchNm("고덕점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕센트럴푸르지오").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253) )).build());
        cafeList.add(Cafe.builder().cafeId("23253436").cafeNm("카페러블리").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로10길 22").point(geometryFactory.createPoint( new Coordinate(127.129823738389,37.5537297252966) )).build());
        cafeList.add(Cafe.builder().cafeId("22497312").cafeNm("그랑카페").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로3길 10").point(geometryFactory.createPoint( new Coordinate(127.128628957005,37.5552527046732) )).build());
        cafeList.add(Cafe.builder().cafeId("15201763").cafeNm("1993주얼리").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로19길 8").point(geometryFactory.createPoint( new Coordinate(127.133859203846,37.5551380092204) )).build());
        cafeList.add(Cafe.builder().cafeId("16061902").cafeNm("떡까페마실방").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("현대아파트").rdnmAdr("서울특별시 강동구 고덕로61길 37").point(geometryFactory.createPoint( new Coordinate(127.151938450404,37.5567469791794) )).build());
        cafeList.add(Cafe.builder().cafeId("17152583").cafeNm("홍성문커피").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("신세계이마트명일점").rdnmAdr("서울특별시 강동구 고덕로 276").point(geometryFactory.createPoint( new Coordinate(127.155594698112,37.5547007581608) )).build());
        cafeList.add(Cafe.builder().cafeId("17140821").cafeNm("이디야커피").brchNm("암사3동점").indsSclsNm("커피전문점/카페/다방").bldNm("프라이어팰리스").rdnmAdr("서울특별시 강동구 고덕로 130").point(geometryFactory.createPoint( new Coordinate(127.140887149503,37.5541981957238) )).build());
        cafeList.add(Cafe.builder().cafeId("12460974").cafeNm("커피베이").brchNm("고덕래미안점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로61길 104").point(geometryFactory.createPoint( new Coordinate(127.151660562307,37.5592949664444) )).build());
        cafeList.add(Cafe.builder().cafeId("23794526").cafeNm("콩셔틀").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로23길 13").point(geometryFactory.createPoint( new Coordinate(127.13494199384,37.5554613161049) )).build());
        cafeList.add(Cafe.builder().cafeId("21878825").cafeNm("요거프레소").brchNm("암사점").indsSclsNm("커피전문점/카페/다방").bldNm("부강빌딩").rdnmAdr("서울특별시 강동구 고덕로 106").point(geometryFactory.createPoint( new Coordinate(127.13699008317,37.5545211868) )).build());
        cafeList.add(Cafe.builder().cafeId("16951001").cafeNm("일일커피").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 102").point(geometryFactory.createPoint( new Coordinate(127.136559831308,37.5545360623044) )).build());
        cafeList.add(Cafe.builder().cafeId("16232316").cafeNm("블링엔젤").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("15838352").cafeNm("카페베네암사").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 89").point(geometryFactory.createPoint( new Coordinate(127.135265118787,37.5549230508521) )).build());
        cafeList.add(Cafe.builder().cafeId("17171142").cafeNm("와플대학").brchNm("상일동역캠퍼스").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움").rdnmAdr("서울특별시 강동구 고덕로 333").point(geometryFactory.createPoint( new Coordinate(127.159471263976,37.5561971380176) )).build());
        cafeList.add(Cafe.builder().cafeId("20303047").cafeNm("카페이유").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 52-18").point(geometryFactory.createPoint( new Coordinate(127.130613926305,37.5539067463908) )).build());
        cafeList.add(Cafe.builder().cafeId("17153261").cafeNm("카페밀").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로61길 106").point(geometryFactory.createPoint( new Coordinate(127.151647814458,37.5594210224169) )).build());
        cafeList.add(Cafe.builder().cafeId("16581121").cafeNm("이디야커피").brchNm("암사3동점").indsSclsNm("커피전문점/카페/다방").bldNm("프라이어팰리스").rdnmAdr("서울특별시 강동구 고덕로 140").point(geometryFactory.createPoint( new Coordinate(127.140725816202,37.554449316893) )).build());
        cafeList.add(Cafe.builder().cafeId("17104088").cafeNm("커피인류").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("17103746").cafeNm("스윗퐁당").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로83길 158").point(geometryFactory.createPoint( new Coordinate(127.166090222316,37.5614701909619) )).build());
        cafeList.add(Cafe.builder().cafeId("20528972").cafeNm("다온").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("삼익그린맨션").rdnmAdr("서울특별시 강동구 고덕로 210").point(geometryFactory.createPoint( new Coordinate(127.149445711747,37.5520075217112) )).build());
        cafeList.add(Cafe.builder().cafeId("17102161").cafeNm("디비디비딥").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("우전빌딩").rdnmAdr("서울특별시 강동구 고덕로 40").point(geometryFactory.createPoint( new Coordinate(127.129644136818,37.5545753918183) )).build());
        cafeList.add(Cafe.builder().cafeId("16977092").cafeNm("감성커피").brchNm("고덕역점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 262").point(geometryFactory.createPoint( new Coordinate(127.154610523855,37.5546576734399) )).build());
        cafeList.add(Cafe.builder().cafeId("17185736").cafeNm("유어턴커피로스터스").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로20길 18-1").point(geometryFactory.createPoint( new Coordinate(127.13360146811,37.5539377168494) )).build());
        cafeList.add(Cafe.builder().cafeId("17264421").cafeNm("파니스").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("시립서울장애인종합복지관").rdnmAdr("서울특별시 강동구 고덕로 201").point(geometryFactory.createPoint( new Coordinate(127.148526565486,37.5561998118108) )).build());
        cafeList.add(Cafe.builder().cafeId("17257032").cafeNm("DE1993JEWELRYCAFE").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("리지빌딩").rdnmAdr("서울특별시 강동구 고덕로19길 8").point(geometryFactory.createPoint( new Coordinate(127.133859099567,37.5551470189916) )).build());
        cafeList.add(Cafe.builder().cafeId("17253045").cafeNm("커피베이").brchNm("강동롯데캐슬퍼스트점").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 133").point(geometryFactory.createPoint( new Coordinate(127.140331828712,37.5552483870889) )).build());
        cafeList.add(Cafe.builder().cafeId("17435226").cafeNm("투썸플레이스").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕아르테온(근린생활시설-2)").rdnmAdr("서울특별시 강동구 고덕로 360").point(geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375) )).build());
        cafeList.add(Cafe.builder().cafeId("17435278").cafeNm("인더후드").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕아르테온(근린생활시설-2)").rdnmAdr("서울특별시 강동구 고덕로 360").point(geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375) )).build());
        cafeList.add(Cafe.builder().cafeId("17497668").cafeNm("프롬하츠커피온조대왕문화센터점").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("온조대왕문화체육관").rdnmAdr("서울특별시 강동구 고덕로 285").point(geometryFactory.createPoint( new Coordinate(127.157439387278,37.5567232887965) )).build());
        cafeList.add(Cafe.builder().cafeId("17437673").cafeNm("커피에반하다").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕아르테온(근린생활시설-2)").rdnmAdr("서울특별시 강동구 고덕로 360").point(geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375) )).build());
        cafeList.add(Cafe.builder().cafeId("17513079").cafeNm("커스텀커피").brchNm("강동상일점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕아르테온(근린생활시설-2)").rdnmAdr("서울특별시 강동구 고덕로 380").point(geometryFactory.createPoint( new Coordinate(127.16811526511,37.5564746103375) )).build());
        cafeList.add(Cafe.builder().cafeId("17524881").cafeNm("카페").brchNm("프레쉬몽땅").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로28길 10-5").point(geometryFactory.createPoint( new Coordinate(127.137595280389,37.5540570606798) )).build());
        cafeList.add(Cafe.builder().cafeId("17529162").cafeNm("디저트39").brchNm("고덕역점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 266").point(geometryFactory.createPoint( new Coordinate(127.155096850589,37.5546881861549) )).build());
        cafeList.add(Cafe.builder().cafeId("17527493").cafeNm("베어밀크").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로27길 33").point(geometryFactory.createPoint( new Coordinate(127.137751021138,37.5562567695086) )).build());
        cafeList.add(Cafe.builder().cafeId("17460952").cafeNm("소피스티케이트").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕센트럴푸르지오").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253) )).build());
        cafeList.add(Cafe.builder().cafeId("17687305").cafeNm("원유로스페셜티강동구").brchNm("고덕역점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 266").point(geometryFactory.createPoint( new Coordinate(127.155096850589,37.5546881861549) )).build());
        cafeList.add(Cafe.builder().cafeId("17584839").cafeNm("카리타로").brchNm("").indsSclsNm("사주카페").bldNm("삼익그린맨션").rdnmAdr("서울특별시 강동구 고덕로 210").point(geometryFactory.createPoint( new Coordinate(127.14921881565,37.5530511107837) )).build());
        cafeList.add(Cafe.builder().cafeId("17711841").cafeNm("카페").brchNm("오메가").indsSclsNm("커피전문점/카페/다방").bldNm("삼익그린맨션").rdnmAdr("서울특별시 강동구 고덕로 210").point(geometryFactory.createPoint( new Coordinate(127.149445711747,37.5520075217112) )).build());
        cafeList.add(Cafe.builder().cafeId("17871661").cafeNm("야옹커피").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("프라이어팰리스").rdnmAdr("서울특별시 강동구 고덕로 130").point(geometryFactory.createPoint( new Coordinate(127.139465466806,37.553818410595) )).build());
        cafeList.add(Cafe.builder().cafeId("17859073").cafeNm("커스텀커피").brchNm("강동암사점").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("17965341").cafeNm("펫니스").brchNm("").indsSclsNm("애견카페").bldNm("고덕리엔파크2단지아파트").rdnmAdr("서울특별시 강동구 고덕로 427").point(geometryFactory.createPoint( new Coordinate(127.172729340058,37.559885987492) )).build());
        cafeList.add(Cafe.builder().cafeId("17972055").cafeNm("원유로스페셜티강동구").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로 391").point(geometryFactory.createPoint( new Coordinate(127.168955860414,37.5572193953854) )).build());
        cafeList.add(Cafe.builder().cafeId("18028320").cafeNm("시나본").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕센트럴푸르지오").rdnmAdr("서울특별시 강동구 고덕로 399").point(geometryFactory.createPoint( new Coordinate(127.169655642763,37.5573955193253) )).build());
        cafeList.add(Cafe.builder().cafeId("18097314").cafeNm("메가엠지씨커피고덕그라시움점").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움(제2상가)").rdnmAdr("서울특별시 강동구 고덕로79길 29").point(geometryFactory.createPoint( new Coordinate(127.164702064569,37.5580634015011) )).build());
        cafeList.add(Cafe.builder().cafeId("18046146").cafeNm("피엘").brchNm("엠까페").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움").rdnmAdr("서울특별시 강동구 고덕로 333").point(geometryFactory.createPoint( new Coordinate(127.166240577475,37.5571191574342) )).build());
        cafeList.add(Cafe.builder().cafeId("18251163").cafeNm("제로투식스티커피").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("우전빌딩").rdnmAdr("서울특별시 강동구 고덕로 40").point(geometryFactory.createPoint( new Coordinate(127.129644136818,37.5545753918183) )).build());
        cafeList.add(Cafe.builder().cafeId("18364576").cafeNm("이디야커피").brchNm("고덕교차로").indsSclsNm("커피전문점/카페/다방").bldNm("대한연세요양원").rdnmAdr("서울특별시 강동구 고덕로 421").point(geometryFactory.createPoint( new Coordinate(127.172553117705,37.557397839641) )).build());
        cafeList.add(Cafe.builder().cafeId("18429383").cafeNm("코드").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("강동롯데캐슬퍼스트아파트").rdnmAdr("서울특별시 강동구 고덕로 131").point(geometryFactory.createPoint( new Coordinate(127.143842286341,37.5550846728847) )).build());
        cafeList.add(Cafe.builder().cafeId("18607628").cafeNm("카페35").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("대명빌딩").rdnmAdr("서울특별시 강동구 고덕로20라길 5").point(geometryFactory.createPoint( new Coordinate(127.133956821233,37.5525707219079) )).build());
        cafeList.add(Cafe.builder().cafeId("18635908").cafeNm("담담").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로24길 24").point(geometryFactory.createPoint( new Coordinate(127.13544871715,37.5537259937506) )).build());
        cafeList.add(Cafe.builder().cafeId("18665828").cafeNm("레인바우").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로10길 26").point(geometryFactory.createPoint( new Coordinate(127.129780566447,37.5535491964013) )).build());
        cafeList.add(Cafe.builder().cafeId("18704869").cafeNm("멍핀").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로20라길 15").point(geometryFactory.createPoint( new Coordinate(127.134476865896,37.5526195878589) )).build());
        cafeList.add(Cafe.builder().cafeId("18683441").cafeNm("퍼스트커피랩").brchNm("강동암사점").indsSclsNm("커피전문점/카페/다방").bldNm("작은도시테라홈즈").rdnmAdr("서울특별시 강동구 고덕로20가길 27").point(geometryFactory.createPoint( new Coordinate(127.135455558462,37.554113497019) )).build());
        cafeList.add(Cafe.builder().cafeId("18771053").cafeNm("하이").brchNm("오커피상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움(제1상가)").rdnmAdr("서울특별시 강동구 고덕로 353").point(geometryFactory.createPoint( new Coordinate(127.16439805106,37.5569078997681) )).build());
        cafeList.add(Cafe.builder().cafeId("18863483").cafeNm("카페썸머").brchNm("").indsSclsNm("커피전문점/카페/다방").bldNm("").rdnmAdr("서울특별시 강동구 고덕로23길 6").point(geometryFactory.createPoint( new Coordinate(127.135195030309,37.5551117587961) )).build());
        cafeList.add(Cafe.builder().cafeId("18771791").cafeNm("풀꽃").brchNm("").indsSclsNm("전통찻집/인삼찻집").bldNm("정산아파트").rdnmAdr("서울특별시 강동구 고덕로 47").point(geometryFactory.createPoint( new Coordinate(127.13039745085,37.5550044375247) )).build());
        cafeList.add(Cafe.builder().cafeId("18972626").cafeNm("매머드익스프레스").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕그라시움(제4상가)").rdnmAdr("서울특별시 강동구 고덕로 385").point(geometryFactory.createPoint( new Coordinate(127.168399703426,37.5573596483776) )).build());
        cafeList.add(Cafe.builder().cafeId("19103356").cafeNm("읍천리382").brchNm("상일동역점").indsSclsNm("커피전문점/카페/다방").bldNm("고덕아르테온(근린생활시설-3)").rdnmAdr("서울특별시 강동구 고덕로80길 20").point(geometryFactory.createPoint( new Coordinate(127.165272343493,37.5556435960111) )).build());

        // 루프돌면서 INSERT
        cafeList.forEach(cafe -> {
            Cafe result = cafeRepository.save(cafe);
            log.info("INSERT 성공 상가업소번호: " + result.getCafeId());
        });
    }

    @Order(2)
    @Test
    @DisplayName("상가업소번호로 카페 조회 테스트")
    public void testSelect() {

        String cafeId = "17509550";
        Optional<Cafe> result = cafeRepository.findById(cafeId);
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