package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "knowledge_cat")
public class KnowledgeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "knowledge_cat_id")
    private int knowledgeCatId;

    @Column(name = "knowledge_cat_name")
    private String knowledgeCatName;

    @Column(name = "`desc`")
    private String desc;

    @OneToMany(mappedBy = "knowledgeCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KnowledgeDetail> listKnowledge;
}
