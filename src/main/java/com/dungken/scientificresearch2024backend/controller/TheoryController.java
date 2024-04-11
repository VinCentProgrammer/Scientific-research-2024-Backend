package com.dungken.scientificresearch2024backend.controller;

import com.dungken.scientificresearch2024backend.dao.PostCategoryRepository;
import com.dungken.scientificresearch2024backend.dao.UserRepository;
import com.dungken.scientificresearch2024backend.dto.PostRequest;
import com.dungken.scientificresearch2024backend.dto.TheoryDetailRequest;
import com.dungken.scientificresearch2024backend.entity.*;
import com.dungken.scientificresearch2024backend.service.PostService;
import com.dungken.scientificresearch2024backend.service.TheoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/theory")
public class TheoryController {
    private UserRepository userRepository;
    private TheoryService theoryService;

    @Autowired
    public TheoryController(UserRepository userRepository, TheoryService theoryService) {
        this.userRepository = userRepository;
        this.theoryService = theoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTheory(@RequestBody TheoryDetailRequest theoryDetailRequest){
        User user = userRepository.findById(theoryDetailRequest.getUserId()).orElse(null);
        TheoryCategory theoryCategory = theoryService.findTheoryCategoryByCatId(theoryDetailRequest.getTheoryCatId());

        if (user == null && theoryCategory == null) {
            return ResponseEntity.badRequest().body("User or theory category not found");
        }

        TheoryDetail theoryDetail = new TheoryDetail();
        theoryDetail.setTitle(theoryDetailRequest.getTitle());
        theoryDetail.setContent(theoryDetailRequest.getContent());
        theoryDetail.setTheoryCategory(theoryCategory);
        theoryDetail.setUser(user);

        theoryService.addTheory(theoryDetail);
        return ResponseEntity.ok("Insert theory detail successfully!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTheory(@RequestBody TheoryDetailRequest theoryDetailRequest){
        TheoryDetail theoryDetail = theoryService.findById(theoryDetailRequest.getTheoryDetailId());
        User user = userRepository.findById(theoryDetailRequest.getUserId()).orElse(null);
        TheoryCategory theoryCategory = theoryService.findTheoryCategoryByCatId(theoryDetailRequest.getTheoryCatId());


        if (theoryDetail == null && theoryCategory == null) {
            return ResponseEntity.badRequest().body("Theory or theory cat not found");
        }

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        theoryDetail.setTitle(theoryDetailRequest.getTitle());
        theoryDetail.setContent(theoryDetailRequest.getContent());
        theoryDetail.setTheoryCategory(theoryCategory);
        theoryDetail.setUser(user);

        theoryService.updateTheory(theoryDetail);
        return ResponseEntity.ok("Update theory detail successfully!");
    }
}
