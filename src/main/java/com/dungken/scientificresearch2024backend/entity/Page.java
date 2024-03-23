package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Data
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private int pageId;

    @Column(name = "page_name")
    private String pageName;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "detail")
    private String detail;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
