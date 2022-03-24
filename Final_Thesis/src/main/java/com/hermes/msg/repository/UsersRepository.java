package com.hermes.msg.repository;

import com.hermes.msg.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
	
}
