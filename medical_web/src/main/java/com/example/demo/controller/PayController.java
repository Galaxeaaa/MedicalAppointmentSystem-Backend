package com.example.demo.controller;

import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping(value = "/setpayrecord", method = RequestMethod.POST)
    public boolean setPayRecord(
            @RequestParam(value = "pid", required = true) String userId,
            @RequestParam(value = "time", required = true) String time
    ) {
        return payService.setPayRecord(userId, time);
    }

    @RequestMapping(value = "/getlastpaytime", method = RequestMethod.GET)
    public String getLastPayTime(
            @RequestParam(value = "pid", required = true) String userId
    ) {
        return payService.getLastPayTime(userId);
    }

    @RequestMapping(value = "/lessthan1hour", method = RequestMethod.GET)
    public boolean lessThan1hour(
            @RequestParam(value = "pid", required = true) String userId
    ) {
        return payService.lessThan1hr(userId);
    }
}
