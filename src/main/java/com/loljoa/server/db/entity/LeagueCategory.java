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
public class LeagueCategory {
    @Id
    @GeneratedValue
    private Long categoryId;

    String name;

    @OneToMany(mappedBy = "category")
    private List<League> leagues = new ArrayList<>();

    @OneToMany(mappedBy = "leagueCategory")
    private List<Post> posts = new ArrayList<>();

    public LeagueCategory(String name) {
        this.name = name;
    }
}
