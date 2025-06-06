package com.skillImprov.dao.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillImprov.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	public boolean existsByUserName(String username);
	public Optional<User> findByEmail(String email);
}
