package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Entity
@Data
@Table(name = "thread")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private int threadId;

    @Column(name = "question")
    private String question;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "number_replies")
    private int numberReplies;

    @Column(name = "number_view")
    private int numberView;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    @JoinTable(
            name = "user_thread",
            joinColumns = @JoinColumn(name = "thread_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
