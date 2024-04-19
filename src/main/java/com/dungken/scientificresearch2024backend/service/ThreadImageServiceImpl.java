package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.dao.ThreadImageRepository;
import com.dungken.scientificresearch2024backend.entity.ThreadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadImageServiceImpl implements ThreadImageService{
    private ThreadImageRepository threadImageRepository;

    @Autowired
    public ThreadImageServiceImpl(ThreadImageRepository threadImageRepository) {
        this.threadImageRepository = threadImageRepository;
    }

    @Override
    public ThreadImage addThreadImage(ThreadImage threadImage) {
        return threadImageRepository.save(threadImage);
    }

    @Override
    public ThreadImage updateThreadImage(ThreadImage threadImage) {
        return threadImageRepository.saveAndFlush(threadImage);
    }

    @Override
    public ThreadImage findById(int id) {
        return threadImageRepository.findById(id).orElse(null);
    }

}
