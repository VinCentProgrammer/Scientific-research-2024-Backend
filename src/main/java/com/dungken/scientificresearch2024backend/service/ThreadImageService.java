package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.entity.ThreadImage;

public interface ThreadImageService {
    public ThreadImage addThreadImage(ThreadImage threadImage);
    public ThreadImage updateThreadImage(ThreadImage threadImage);
    public ThreadImage findById(int id);
}
