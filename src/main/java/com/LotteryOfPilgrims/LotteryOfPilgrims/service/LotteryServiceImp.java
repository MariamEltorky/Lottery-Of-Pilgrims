package com.LotteryOfPilgrims.LotteryOfPilgrims.service;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Lottery;
import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.AcceptedPilgrimsRepository;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.LotteryRepository;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.PilgrimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImp implements LotteryService{

    @Autowired
    private LotteryRepository lotteryrepository;

    @Autowired
    private AcceptedPilgrimsRepository acceptedpilgrimsrepository;

    @Override
    public Lottery Add(Lottery lottery) {
        lotteryrepository.deleteAll();

        return lotteryrepository.save(lottery);
    }


}
