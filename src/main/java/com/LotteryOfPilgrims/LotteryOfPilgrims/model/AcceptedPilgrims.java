package com.LotteryOfPilgrims.LotteryOfPilgrims.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AcceptedPilgrims {
    @Id
    private Long accid;
    private String accName;

    private int accage;

    public AcceptedPilgrims(Long accid, String accName, int accage) {
        this.accid = accid;
        this.accName = accName;
        this.accage = accage;
    }

    public AcceptedPilgrims() {
    }

    public Long getAccid() {
        return accid;
    }

    public void setAccid(Long accid) {
        this.accid = accid;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getAccage() {
        return accage;
    }

    public void setAccage(int accage) {
        this.accage = accage;
    }
}
