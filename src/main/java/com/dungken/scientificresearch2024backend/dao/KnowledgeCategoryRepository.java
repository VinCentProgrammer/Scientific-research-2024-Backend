package com.dungken.scientificresearch2024backend.dao;

import com.dungken.scientificresearch2024backend.entity.KnowledgeCategory;
import com.dungken.scientificresearch2024backend.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "knowledge-cat")
public interface KnowledgeCategoryRepository extends JpaRepository<KnowledgeCategory, Integer> {
}
