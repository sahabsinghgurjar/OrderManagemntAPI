package com.sahab.ordermanagement.user.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahab.ordermanagement.user.model.OrderUser;
import com.sahab.ordermanagement.user.services.OrderUserService;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private OrderUserService orderUserService;

	@GetMapping("myUser/{userId}")
	public OrderUser getUser(@PathVariable String userId) {
		OrderUser user = new OrderUser();
		user.setAddress("");
		user.setUserId(userId);
		return user;

	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody OrderUser user) {
		orderUserService.reisterUser(user);
		
		return ResponseEntity.ok("User successfully registered.");
	}

	@GetMapping("all")
	public List<OrderUser> getAllUsers() {
		return orderUserService.getAllUsers();
	}

	@GetMapping("/ping")
	public String ping() {
		return "ping success.";

	}
}
