package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "task")
@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "isDone")
    private boolean isDone;


}
