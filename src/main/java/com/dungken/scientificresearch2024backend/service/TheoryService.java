package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.entity.PostDetail;
import com.dungken.scientificresearch2024backend.entity.TheoryCategory;
import com.dungken.scientificresearch2024backend.entity.TheoryDetail;

public interface TheoryService {
    public TheoryDetail addTheory(TheoryDetail theoryDetail);
    public TheoryDetail updateTheory(TheoryDetail theoryDetail);
    public TheoryDetail findById(int id);
    public TheoryCategory findTheoryCategoryByCatId(int catId);
    public TheoryDetail findByTheoryCatId(int catId);
}
