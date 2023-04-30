package com.wanja727.kgjguide.controller;

import com.wanja727.kgjguide.config.auth.dto.SessionUser;
import com.wanja727.kgjguide.dto.CafeDto;
import com.wanja727.kgjguide.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainController {

    private final CafeService cafeService;
    private final HttpSession httpSession;

    @GetMapping(value = "/")
    public String main(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        System.out.println("user = " + user);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "main";
    }

    @PostMapping(value = "/")
    public @ResponseBody ResponseEntity getCafeList(@RequestBody Map<String, Double> map) {
        System.out.println("map.toString() = " + map.toString());

        List<CafeDto> cafeList = cafeService.getCafeList(map.get("lng"), map.get("lat"));
        return new ResponseEntity<List<CafeDto>>(cafeList, HttpStatus.OK);
    }
}
