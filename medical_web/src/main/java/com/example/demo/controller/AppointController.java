package com.example.demo.controller;

import com.example.demo.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appoint")
public class AppointController {

    @Autowired
    private AppointService appointService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean addRecord(
            @RequestParam(value = "pid") String pid,
            @RequestParam(value = "did") String did
    ) {
        return appointService.addRecord(pid, did);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public boolean removeRecord(
            @RequestParam(value = "pid") String pid,
            @RequestParam(value = "did") String did
    ) {
        return appointService.removeRecord(pid, did);
    }
}
