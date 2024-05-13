package com.LotteryOfPilgrims.LotteryOfPilgrims.controller;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Lottery;
import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import com.LotteryOfPilgrims.LotteryOfPilgrims.service.LotteryService;
import com.LotteryOfPilgrims.LotteryOfPilgrims.service.PilgrimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PerformLottery")
@CrossOrigin
public class LotteryController {

    @Autowired
    private LotteryService lotteryservice;

    @Autowired
    private PilgrimsService pilgrimsservice;


    @PostMapping("/Perform")
    public String Add(@RequestBody Lottery lottery){
        lotteryservice.Add(lottery);
        pilgrimsservice.getListPilgrimsGivenID();
        return "New Pilgrim is added";
    }


}
