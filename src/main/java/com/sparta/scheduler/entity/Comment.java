package com.sparta.scheduler.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(optional = false)
    private Schedule schedule;

    @OneToMany(mappedBy = "comment",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Reply> reply;


}
