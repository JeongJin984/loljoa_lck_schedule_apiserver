package com.loljoa.server.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BettingChoice {
    @Id
    @GeneratedValue
    private Long choiceId;

    @ManyToOne(targetEntity = GameData.class)
    private GameData targetGame;

    @OneToMany(mappedBy = "choice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BettingState> bettingStates = new ArrayList<>();
}
