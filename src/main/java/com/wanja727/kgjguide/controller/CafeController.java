package com.wanja727.kgjguide.controller;

import com.wanja727.kgjguide.dto.CafeDetailDTO;
import com.wanja727.kgjguide.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @PostMapping(value = "cafe/{cafeId}")
    public @ResponseBody ResponseEntity CafeInfo(Model model, @PathVariable("cafeId") String cafeId) throws Exception {
        System.out.println("cafeId = " + cafeId);
        CafeDetailDTO cafeDetailDTO = cafeService.getCafeInfo(cafeId);
        return new ResponseEntity<CafeDetailDTO>(cafeDetailDTO, HttpStatus.OK);
    }
}
