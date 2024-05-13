package com.LotteryOfPilgrims.LotteryOfPilgrims.service;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.AcceptedPilgrims;
import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.AcceptedPilgrimsRepository;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.LotteryRepository;
import com.LotteryOfPilgrims.LotteryOfPilgrims.repository.PilgrimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PilgrimsServiceImp implements PilgrimsService{

    @Autowired
    private PilgrimsRepository pilgrimsrepository;
    @Autowired
    private LotteryRepository lotteryrepository;

    @Autowired
    private AcceptedPilgrimsRepository acceptedpilgrimsRepository;

    private AcceptedPilgrims acceptedPilgrims;


    @Override
    public Pilgrims uploadData(Pilgrims pilgrim) {

        return pilgrimsrepository.save(pilgrim);
    }

    @Override
    public List<Pilgrims> getAllPilgrims() {
        return pilgrimsrepository.findAll();
    }

    @Override
    public List<Long> PerformingLottery(int max ,  List<Long> ids) {
        List<Long> ListOfAcceptedIds = new ArrayList<Long>();
        Random rand = new Random();
        for (int i = 0; i < max; i++) {
            int randomIndex = rand.nextInt(ids.size());
            ListOfAcceptedIds.add(ids.get(randomIndex));
            ids.remove(randomIndex);
        }

        return ListOfAcceptedIds;
    }


    @Override
    public List<Long> getLotteryIDS() {

        List<Long> EmptyList = Collections.<Long>emptyList();

        int size=pilgrimsrepository.findAll().size();   //all 7
        int total=lotteryrepository.getTotalNo();     //all 6 user input
        List<Long> ListALLData = new ArrayList<Long>();
        for (int k=0; k < size ; k++) {
            ListALLData.add(pilgrimsrepository.findAll().get(k).getId());
        }
            if (size <= total) {
                return ListALLData;
            }
            else {

                int DisAgeCount = lotteryrepository.getabovecount();   //d  3
                int OtherAgeCount = lotteryrepository.getbelowcount();   //o   4
                List<Long> FinalList = new ArrayList<Long>();
//                if (DisAgeCount>=total) {
//                    List<Long> ListOfD = lotteryrepository.getDisIDS();
////                    int ACCD =Integer.parseInt(String.valueOf((lotteryrepository.getAccD() * DisAgeCount) / 100));
//                    List<Long> ListACCD = PerformingLottery(total, ListOfD); // Part Of Final
//                    FinalList.addAll(ListACCD);
//                }
//                else {
                    List<Long> ListOfD = lotteryrepository.getDisIDS();
                    List<Long> ListOfOther = lotteryrepository.getotherIDS();
                    int ACCD = Integer.parseInt(String.valueOf((lotteryrepository.getAccD() * DisAgeCount) / 100));
                    int ACCOther = total - ACCD;
                    List<Long> ListACCD = PerformingLottery(ACCD, ListOfD); // Part Of Final

                    ListALLData.removeAll(ListACCD);

                    List<Long> ListACCOther = PerformingLottery(ACCOther, ListALLData);

                    FinalList.addAll(ListACCD);
                    FinalList.addAll(ListACCOther);


                //}

                return  FinalList;

            }
        //        return pilgrimsrepository.findAll().size();
    }

    @Override
    public List<String> GetGivenID() {
        List<String> ReturnedData = new ArrayList<String>();
        List<Long> ListALLDataIDs = this.getLotteryIDS();
        for (int i = 0 ; i < ListALLDataIDs.size() ; i++) {
            ReturnedData.add(lotteryrepository.getDataGivenID(ListALLDataIDs.get(i).longValue()));
        }

        return ReturnedData;
    }

    @Override
    public String GetRows() {
        StringBuilder stb = new StringBuilder();
        String s = "";
        List<String> ListALLData = this.GetGivenID();
        for (int i=0;i<ListALLData.size();i++) {
            s = ListALLData.get(i);
            stb.append("'");
            stb.append(s);
            stb.append("'");
            stb.append(",");
        }
        int x=0;
        x=stb.length();
        stb.deleteCharAt(x-1);
        String rows = null;
        rows = stb.toString().trim();
        return rows;
    }

    @Override
    public List<Pilgrims> getListPilgrimsGivenID() {
        acceptedpilgrimsRepository.deleteAll();

//        List<Pilgrims> ReturnedDataTemp = new ArrayList<Pilgrims>();
        List<Pilgrims> ReturnedData= new ArrayList<Pilgrims>();
        List<Long> ListALLDataIDs = this.getLotteryIDS();
        for (int i = 0 ; i < ListALLDataIDs.size() ; i++) {
            ReturnedData.add(lotteryrepository.getListPilgrimsGivenID(ListALLDataIDs.get(i)));
        }
        for (int i=0;i<ReturnedData.size();i++) {
            Long temp_id = ReturnedData.get(i).getId();
            String temp_name = ReturnedData.get(i).getName();
            int temp_age = ReturnedData.get(i).getAge();
            AcceptedPilgrims accpil = new AcceptedPilgrims(temp_id , temp_name ,temp_age );
            acceptedpilgrimsRepository.save(accpil);
        }

        return ReturnedData;
    }

    @Override
    public String CheckPerformed(Long id) {
            if (lotteryrepository.CheckPerformedQuery(id) != "") {
                return "Not Performed";
            }
            else {
                return "Performed";
            }
    }

//    @Override
//    public void InsertAccepted(long aid, String aName, int aAge) {
//        List<Pilgrims> ReturnedData=this.getListPilgrimsGivenID();
//
//    }



}
