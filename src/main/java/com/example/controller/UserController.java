package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.ResponseStructure;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/save-user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
	 	user =userService.saveUser(user);
	 	 return ResponseEntity.status(HttpStatus.CREATED)
	 			 .body(ResponseStructure.create(HttpStatus.CREATED.value(),"User created",user));
	}
	
	
	@GetMapping("/find-user")
	public  ResponseEntity<ResponseStructure<User>>findUser( @RequestParam int userId) {
		
	User user= userService.findUser(userId);
	return ResponseEntity.status(HttpStatus.FOUND)
			 .body(ResponseStructure.create(HttpStatus.FOUND.value(),"User find successfully",user));
	
	}
	
	@DeleteMapping("/delete-user")
	public  ResponseEntity<ResponseStructure<User>> deleteUser( @RequestParam int userId) {
		User user=userService.deleteUSer(userId);
		return ResponseEntity.status(HttpStatus.OK)
				 .body(ResponseStructure.create(HttpStatus.OK.value(),"User find successfully",user));
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		
		 user= userService.updateUser(user);
		 return ResponseEntity.status(HttpStatus.OK)
				 .body(ResponseStructure.create(HttpStatus.OK.value(),"User find successfully",user));
		 
	}
	
}
