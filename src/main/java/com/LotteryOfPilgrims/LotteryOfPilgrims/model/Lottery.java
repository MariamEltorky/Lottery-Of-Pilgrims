package com.LotteryOfPilgrims.LotteryOfPilgrims.model;

import javax.persistence.*;

@Entity
public class Lottery {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long processid;

    private int totalno;
    private int disage;
    private int disper;

    public Lottery() {
    }

    public Long getProcessid() {
        return processid;
    }

    public void setProcessid(Long processid) {
        this.processid = processid;
    }

    public int getTotalno() {
        return totalno;
    }

    public void setTotalno(int totalno) {
        this.totalno = totalno;
    }

    public int getDisage() {
        return disage;
    }

    public void setDisage(int disage) {
        this.disage = disage;
    }

    public int getDisper() {
        return disper;
    }

    public void setDisper(int disper) {
        this.disper = disper;
    }
}
