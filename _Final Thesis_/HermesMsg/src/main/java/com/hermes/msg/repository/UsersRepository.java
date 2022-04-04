package com.hermes.msg.repository;

import com.hermes.msg.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    public Optional<Users> findByUsername(String username);

    public Boolean existsByUsername(String username);
}
