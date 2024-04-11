package com.dungken.scientificresearch2024backend.dao;

import com.dungken.scientificresearch2024backend.entity.TheoryExample;
import com.dungken.scientificresearch2024backend.entity.TheoryKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "theory-keyword")
public interface TheoryKeywordRepository extends JpaRepository<TheoryKeyword, Integer> {
}
