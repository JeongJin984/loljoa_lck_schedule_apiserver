package com.loljoa.server.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Tier {
    @Id
    @GeneratedValue
    private Long tierId;

    String name;

    @OneToMany(mappedBy = "tier")
    List<Account> account = new ArrayList<>();

    public Tier(String name) {
        this.name = name;
    }
}
