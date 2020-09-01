package com.sahab.ordermanagement.user.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahab.ordermanagement.user.model.OrderUser;
import com.sahab.ordermanagement.user.repo.OrderUserRepo;

@Service
public class OrderUserService {
	@Autowired
	private OrderUserRepo userRepo;
	
	public List<OrderUser> getAllUsers(){
		return userRepo.findAll().stream().map(userEntity->{
			OrderUser orderUser=new OrderUser();
			orderUser.setAddress(userEntity.getAddress());
			orderUser.setEmail(userEntity.getEmail());
			orderUser.setPhone(userEntity.getPhone());
			orderUser.setUserId(userEntity.getUserId());
			orderUser.setFirstName(userEntity.getFirstName());
			orderUser.setLastName(userEntity.getLastName());
			return orderUser;
		}).collect(Collectors.toList());
	}

}
