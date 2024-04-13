package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "thread_image")
public class ThreadImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imgId")
    private int imgId;

    @Column(name = "`name`")
    private String name;

    @Column(name = "path", columnDefinition = "LONGTEXT")
    @Lob
    private String path;

    @Column(name = "`created_at`")
    private Timestamp createdAt;
    @PrePersist
    private void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @Column(name = "`updated_at`")
    private Timestamp updatedAt;
    @PreUpdate
    private void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;

}
