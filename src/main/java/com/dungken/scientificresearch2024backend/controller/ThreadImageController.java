package com.dungken.scientificresearch2024backend.controller;

import com.dungken.scientificresearch2024backend.dao.ThreadRepository;
import com.dungken.scientificresearch2024backend.dto.ThreadImageRequest;
import com.dungken.scientificresearch2024backend.entity.Thread;
import com.dungken.scientificresearch2024backend.entity.ThreadImage;
import com.dungken.scientificresearch2024backend.service.ThreadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/thread/image")
public class ThreadImageController {
    private ThreadImageService threadImageService;
    private ThreadRepository threadRepository;

    @Autowired
    public ThreadImageController(ThreadImageService threadImageService, ThreadRepository threadRepository) {
        this.threadImageService = threadImageService;
        this.threadRepository = threadRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addThreadImage(@RequestBody ThreadImageRequest threadImageRequest){
        Thread thread = threadRepository.findById(threadImageRequest.getThreadId()).orElse(null);

        if (thread == null) {
            return ResponseEntity.badRequest().body("Thread not found");
        }

        ThreadImage threadImage = new ThreadImage();
        threadImage.setImgId(threadImageRequest.getImgId());
        threadImage.setName(threadImageRequest.getName());
        threadImage.setPath(threadImageRequest.getPath());
        threadImage.setThread(thread);

        threadImageService.addThreadImage(threadImage);

        return ResponseEntity.ok("Insert threadImage successfully!");
    }

}
