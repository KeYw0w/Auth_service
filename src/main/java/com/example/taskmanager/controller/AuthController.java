package com.example.taskmanager.controller;

import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.UserService;
import com.example.taskmanager.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto){
        if(userRepository.existsByUsername(userDto.getUsername())){
            return ResponseEntity.badRequest().body("This user already exist");
        }
        else{
            userService.saveUser(userDto);
            return ResponseEntity.ok("Well done");
        }
    }
    @GetMapping("/signup")
    public ResponseEntity<?> signin(@RequestBody UserDto userDto){
        if(userRepository.existsByUsername(userDto.getUsername())){
            return ResponseEntity.ok("Well done");
        }
        else{
            return ResponseEntity.badRequest().body("User not found");
        }
    }
}
