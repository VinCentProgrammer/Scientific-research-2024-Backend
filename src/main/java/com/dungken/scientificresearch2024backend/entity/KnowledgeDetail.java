package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Data
@Table(name = "knowledge_detail")
public class KnowledgeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "knowledge_id")
    private int knowledgeId;

    @Column(name = "title")
    private String title;

    @Column(name = "detail")
    private String detail;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "knowledge_cat_id", nullable = false)
    private KnowledgeCategory knowledgeCategory;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
