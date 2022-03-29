package com.loljoa.server.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Long postId;

    private String content;

    @ManyToOne(targetEntity = LeagueCategory.class)
    private LeagueCategory leagueCategory;

    @ManyToOne(targetEntity = Account.class)
    private Account writer;

    @OneToMany(mappedBy = "post", cascade = { CascadeType.ALL, CascadeType.REMOVE })
    private List<PostComment> comments = new ArrayList<>();
}
