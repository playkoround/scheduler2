package com.sparta.scheduler.entity;

import jakarta.persistence.*;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(optional = false)
    private Comment comment;
}
