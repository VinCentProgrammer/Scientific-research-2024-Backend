package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.entity.TheoryCategory;

public interface TheoryCatService {
    public TheoryCategory addTheoryCat(TheoryCategory theoryCategory);
    public TheoryCategory updateTheoryCat(TheoryCategory theoryCategory);
    public TheoryCategory findById(int id);
}
