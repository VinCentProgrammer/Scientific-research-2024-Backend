package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "post_cat")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_cat_id")
    private int postCatId;

    @Column(name = "post_cat_name")
    private String postCatName;

    @Column(name = "`desc`")
    private String desc;

    @OneToMany(mappedBy = "postCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostDetail> posts;
}
