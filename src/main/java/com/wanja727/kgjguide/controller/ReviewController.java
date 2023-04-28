package com.wanja727.kgjguide.controller;

import com.wanja727.kgjguide.dto.ReviewDTO;
import com.wanja727.kgjguide.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/review/register")
    public @ResponseBody ResponseEntity registerReview(@RequestBody ReviewDTO reviewDTO){
        System.out.println("reviewDTO = " + reviewDTO);
        Long reviewId = reviewService.register(reviewDTO);
        return new ResponseEntity<Long>(reviewId, HttpStatus.OK);
    }
}
