package com.skillImprov.controller;
//controller/UserController.java

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillImprov.dto.LoginDTO;
import com.skillImprov.dto.RegisterDTO;
import com.skillImprov.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {
	
	UserService userService = new UserService();

 @PostMapping("/register")
 public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registorDTO) {
     String message = userService.register(registorDTO);
     return ResponseEntity.ok(message);
 }

 @PostMapping("/login")
 public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
     String message = userService.login(loginDTO);

     if(!message.equals("Login Successful")) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

     return ResponseEntity.ok("Login successful");
 }
}
