package com.dungken.scientificresearch2024backend.controller;

import com.dungken.scientificresearch2024backend.entity.User;
import com.dungken.scientificresearch2024backend.service.AccountService;
import com.dungken.scientificresearch2024backend.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private AccountService accountService;
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Validated @RequestBody User user){
        ResponseEntity<?> response = accountService.registerUser(user);
        return response;
    }
    @GetMapping("/list")
    public List<User> getListUser() {
        return myUserService.getUsers();
    }
}
