package com.dungken.scientificresearch2024backend.dao;

import com.dungken.scientificresearch2024backend.entity.Keyword;
import com.dungken.scientificresearch2024backend.entity.Theory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "theory")
public interface TheoryRepository extends JpaRepository<Theory, Integer> {
}
