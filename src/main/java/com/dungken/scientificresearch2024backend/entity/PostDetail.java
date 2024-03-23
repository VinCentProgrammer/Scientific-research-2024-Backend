package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Data
@Table(name = "post_detail")
public class PostDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String title;

    @Column(name = "`desc`")
    private String desc;

    @Column(name = "detail")
    private String detail;

    @Column(name = "thumbnail", columnDefinition = "LONGTEXT")
    @Lob
    private String thumbnail;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "post_cat_id", nullable = false)
    private PostCategory postCategory;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
