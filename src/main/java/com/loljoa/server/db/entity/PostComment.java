package com.loljoa.server.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue
    private Long commentId;

    private String content;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

    @ManyToOne(targetEntity = Account.class)
    private Account commenter;
}
