package com.wanja727.kgjguide.controller;

import com.wanja727.kgjguide.dto.ReviewDTO;
import com.wanja727.kgjguide.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/review/modify")
    public @ResponseBody ResponseEntity modifyReview(@RequestBody ReviewDTO reviewDTO){
        System.out.println("reviewDTO = " + reviewDTO);
        Long reviewId = reviewService.modify(reviewDTO);
        return new ResponseEntity<Long>(reviewId, HttpStatus.OK);
    }

    @PostMapping("/review/remove")
    public @ResponseBody ResponseEntity removeReview(@RequestParam Long reviewId){
        System.out.println("reviewId = " + reviewId);
        reviewService.remove(reviewId);
        return new ResponseEntity<Long>(reviewId, HttpStatus.OK);
    }
}
