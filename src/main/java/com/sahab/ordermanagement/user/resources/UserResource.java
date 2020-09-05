package com.sahab.ordermanagement.user.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahab.ordermanagement.exceptions.UserAlreadyExistException;
import com.sahab.ordermanagement.exceptions.UserDoesNotExistException;
import com.sahab.ordermanagement.user.model.OrderUser;
import com.sahab.ordermanagement.user.services.OrderUserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private OrderUserService orderUserService;

	@GetMapping("myUser/{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId) {
		try {
			return ResponseEntity.ok(orderUserService.getUser(userId));
		} catch (UserDoesNotExistException e) {
			return ResponseEntity.badRequest().body("User does not exist");
		}

	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody OrderUser user) {
		try {
			orderUserService.reisterUser(user);
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body("User already Exist.");
		}

		return ResponseEntity.ok("User successfully registered.");
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody OrderUser user) {
		try {
			orderUserService.updateUser(user);
		} catch (UserDoesNotExistException e) {
			return ResponseEntity.badRequest().body("User does not Exist.");
		}

		return ResponseEntity.ok("User successfully updated.");
	}

	@PutMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestBody OrderUser user) {
		try {
			orderUserService.deleteUser(user.getUserId());
		} catch (UserDoesNotExistException e) {
			return ResponseEntity.badRequest().body("User does not Exist.");
		}

		return ResponseEntity.ok("User successfully deleted.");
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
