package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.dto.ReviewDTO;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Review;
import com.wanja727.kgjguide.entity.Users;
import com.wanja727.kgjguide.repository.CafeRepository;
import com.wanja727.kgjguide.repository.ReviewRepository;
import com.wanja727.kgjguide.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReviewService {

    private final ModelMapper modelMapper;

    private final ReviewRepository reviewRepository;
    private final CafeRepository cafeRepository;
    private final UsersRepository usersRepository;

    public Long register(ReviewDTO reviewDTO) {

        Cafe cafe = cafeRepository.findById(reviewDTO.getCafeId()).orElseThrow(EntityNotFoundException::new);;
        Users users = usersRepository.findById(1L).orElseThrow(EntityNotFoundException::new);

        Review review = Review.builder()
                .consentScore(reviewDTO.getConsentScore())
                .comfortScore(reviewDTO.getComfortScore())
                .wifiScore(reviewDTO.getWifiScore())
                .floor(reviewDTO.getFloor())
                .user(users)
                .cafe(cafe)
                .content(reviewDTO.getContent())
                .storeSize(reviewDTO.getStoreSize())
                .build();

        //Review review = modelMapper.map(reviewDTO, Review.class);
        reviewRepository.save(review);
        System.out.println("review.getReviewId() = " + review.getReviewId());

        return review.getReviewId();
    }
}