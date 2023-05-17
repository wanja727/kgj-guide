package com.wanja727.kgjguide.controller;

import com.wanja727.kgjguide.config.auth.LoginUser;
import com.wanja727.kgjguide.config.auth.dto.SessionUser;
import com.wanja727.kgjguide.dto.CafeDetailDTO;
import com.wanja727.kgjguide.service.BookmarkService;
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

    private final BookmarkService bookmarkService;

    @PostMapping(value = "cafe/{cafeId}")
    public @ResponseBody ResponseEntity CafeInfo(Model model, @PathVariable("cafeId") String cafeId) throws Exception {
        System.out.println("cafeId = " + cafeId);
        CafeDetailDTO cafeDetailDTO = cafeService.getCafeInfo(cafeId);
        return new ResponseEntity<CafeDetailDTO>(cafeDetailDTO, HttpStatus.OK);
    }

    @PostMapping(value = "cafe/{cafeId}/bookmark-reg")
    public @ResponseBody ResponseEntity Bookmark(Model model, @PathVariable("cafeId") String cafeId, @LoginUser SessionUser user) throws Exception {
        System.out.println("cafeId = " + cafeId);
        Long bookmarkId = bookmarkService.register(cafeId, user);
//        CafeDetailDTO cafeDetailDTO = cafeService.getCafeInfo(cafeId);
        return new ResponseEntity<Long>(bookmarkId, HttpStatus.OK);
    }

//    @PostMapping(value = "cafe/{cafeId}/bookmark-del")
//    public @ResponseBody ResponseEntity Bookmark(Model model, @PathVariable("cafeId") String cafeId) throws Exception {
//        System.out.println("cafeId = " + cafeId);
//    }
}
