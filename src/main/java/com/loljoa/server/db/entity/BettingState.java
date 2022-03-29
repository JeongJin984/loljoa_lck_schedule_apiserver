package com.loljoa.server.db.entity;

import javax.persistence.*;

@Entity
public class BettingState {
    @Id
    @GeneratedValue
    Long stateId;

    @ManyToOne(targetEntity = BettingChoice.class, fetch = FetchType.LAZY)
    private BettingChoice choice;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    private Account better;
}
