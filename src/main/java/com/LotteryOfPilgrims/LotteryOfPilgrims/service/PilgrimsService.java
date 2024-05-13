package com.LotteryOfPilgrims.LotteryOfPilgrims.service;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;

import java.util.List;

public interface PilgrimsService {
    public Pilgrims uploadData (Pilgrims pilgrim);
    public List<Pilgrims> getAllPilgrims();

    public List<Long> getLotteryIDS();

    public List<Long> PerformingLottery (int max , List<Long> ids);

    public  List<String> GetGivenID ();

    public String GetRows ();


    public  List<Pilgrims> getListPilgrimsGivenID ();

    public String CheckPerformed(Long id);

//    public void InsertAccepted(long aid , String aName , int aAge);




}
