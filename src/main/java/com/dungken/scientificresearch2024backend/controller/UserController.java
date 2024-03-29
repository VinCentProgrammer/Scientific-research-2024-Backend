package com.dungken.scientificresearch2024backend.controller;

import com.dungken.scientificresearch2024backend.dto.UserRequest;
import com.dungken.scientificresearch2024backend.entity.User;
import com.dungken.scientificresearch2024backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        ResponseEntity<?> response = accountService.addUser(userRequest);
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest){
        ResponseEntity<?> response = accountService.updateUser(userRequest);
        return response;
    }
}
