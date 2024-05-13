package com.LotteryOfPilgrims.LotteryOfPilgrims.repository;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Lottery;
import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long> {

    @Query("SELECT totalno FROM Lottery ")
    int getTotalNo();

    @Query("SELECT Count(P.id) FROM Lottery L , Pilgrims P WHERE L.disage <= P.age")
    int getabovecount();

    @Query("SELECT Count(P.id) FROM Lottery L , Pilgrims P WHERE L.disage > P.age")
    int getbelowcount();

    @Query("SELECT P.id FROM Lottery L , Pilgrims P WHERE L.disage <= P.age")
    List<Long> getDisIDS();

    @Query("SELECT P.id FROM Lottery L , Pilgrims P WHERE L.disage > P.age")
    List<Long> getotherIDS();

    @Query("SELECT disper FROM Lottery ")
    int getAccD();

    @Query("SELECT P.id ,  P.Name , P.age  FROM Pilgrims P WHERE id=?1")
    String getDataGivenID(Long id);

    @Query("SELECT" +
           " new com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims(P.id ,  P.Name , P.age) "  +
            "FROM Pilgrims P WHERE id=?1")
    Pilgrims getListPilgrimsGivenID(Long id);

    @Modifying
    @Query("DELETE FROM Lottery")
    void deleteAll();

    @Query("SELECT A.accid FROM AcceptedPilgrims A")
    List<Long> GetAcceptedPilgrimsIDs();

    @Query("SELECT A.accid ,  A.accName , A.accage FROM AcceptedPilgrims A WHERE A.accid=?1 ")
    String CheckPerformedQuery(Long id);



//    @Modifying
//    @Query("INSERT INTO " +
//            "new com.LotteryOfPilgrims.LotteryOfPilgrims.model.AcceptedPilgrims(accid , accName , accage) "+
//            "VALUES (?1,?2 , ?3) ")
//    void InsertAcceptedData(long accid , String accName , int accage);

//    @Query("INSERT INTO AcceptedPilgrims(accid) select :id from Pilgrims")
//    @Modifying(clearAutomatically = true)
//    void InsertAcceptedD(@Param("id")Long id);

}

