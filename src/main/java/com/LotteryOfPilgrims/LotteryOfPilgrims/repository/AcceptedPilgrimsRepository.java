package com.LotteryOfPilgrims.LotteryOfPilgrims.repository;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.AcceptedPilgrims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AcceptedPilgrimsRepository extends JpaRepository<AcceptedPilgrims, Long> {

}
