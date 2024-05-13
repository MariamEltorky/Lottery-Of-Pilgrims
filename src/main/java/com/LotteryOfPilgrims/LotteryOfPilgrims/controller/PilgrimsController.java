package com.LotteryOfPilgrims.LotteryOfPilgrims.controller;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.LotteryRepository;
import com.LotteryOfPilgrims.LotteryOfPilgrims.service.PilgrimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pilgrims")
@CrossOrigin
public class PilgrimsController {

    @Autowired
    private PilgrimsService pilgrimsservice;


    @PostMapping("/upload")
    public String add(@RequestBody Pilgrims Pilgrim){
        pilgrimsservice.uploadData(Pilgrim);
        return "New Pilgrim is added";
    }

    @GetMapping("/getAll")
    public List<Pilgrims> list(){
        return pilgrimsservice.getAllPilgrims();
    }

    @GetMapping("/getLotteryIDS")
    public List<Long>  getLotteryIDS(){
        return pilgrimsservice.getLotteryIDS();
    }


    @GetMapping("/getGivenID")
    public  List<String> getGivenID(){
        return pilgrimsservice.GetGivenID();
    }

    @GetMapping("/getGivenPilgrimsID")
    public  List<Pilgrims> getListPilgrimsGivenID(){
        return pilgrimsservice.getListPilgrimsGivenID();
    }


    @GetMapping("/getrows")
    public  String GetRows(){
        return pilgrimsservice.GetRows();
    }


    @GetMapping("/checkperformed")
    public  String checkPerformed(@RequestBody Long idd){
        return pilgrimsservice.CheckPerformed(idd);
    }





}
