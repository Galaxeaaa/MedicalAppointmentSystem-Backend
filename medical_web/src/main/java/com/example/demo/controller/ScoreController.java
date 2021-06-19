package com.example.demo.controller;

import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/setscore", method = RequestMethod.GET)
    boolean setScore(
            @RequestParam(value = "did", required = true) String did,
            @RequestParam(value = "score", required = true) String score
    ) {
        return scoreService.setScore(did, score);
    }
}
