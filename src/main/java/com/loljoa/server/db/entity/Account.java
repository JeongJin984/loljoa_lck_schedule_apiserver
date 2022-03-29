package com.loljoa.server.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    Long accountId;

    @Column(unique = true)
    String userId;

    @Column(unique = true)
    String nickname;
    String password;

    @ManyToOne(targetEntity = Tier.class)
    Tier tier;

    @OneToMany(mappedBy = "better")
    List<BettingState> bettingStates = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "commenter")
    List<PostComment> postComments = new ArrayList<>();

    @OneToMany(mappedBy = "commenter")
    List<LeagueComment> leagueComments = new ArrayList<>();

    public Account(Long accountId) {
        this.accountId = accountId;
    }

    public Account(String userId, String nickname, String password, Tier rank) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
    }
}
