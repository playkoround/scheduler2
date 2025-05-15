package com.sparta.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20)
    private String title;

    private String content;

    @OneToMany(mappedBy = "schedule",
    orphanRemoval = true,
    cascade = CascadeType.ALL)
    private List<Comment> comments;

}
