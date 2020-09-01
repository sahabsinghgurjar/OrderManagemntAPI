package com.sahab.ordermanagement.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahab.ordermanagement.user.model.OrderUserEntity;

@Repository
public interface OrderUserRepo extends JpaRepository<OrderUserEntity, String>{
	
	List<OrderUserEntity> findAll();

}
