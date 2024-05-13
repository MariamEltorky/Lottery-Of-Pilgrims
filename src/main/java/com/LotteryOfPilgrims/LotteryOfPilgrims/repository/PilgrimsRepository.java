package com.LotteryOfPilgrims.LotteryOfPilgrims.repository;

import com.LotteryOfPilgrims.LotteryOfPilgrims.model.Pilgrims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilgrimsRepository extends JpaRepository<Pilgrims , Long> {
}
