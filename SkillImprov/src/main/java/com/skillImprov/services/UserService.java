package com.skillImprov.services;

import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.dto.LoginDTO;
import com.skillImprov.dto.RegisterDTO;
import com.skillImprov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String login(LoginDTO loginDTO) {
    	Optional<User> userOptional = findByEmail(loginDTO.getEmail());
    	if(userOptional.isPresent()) {
    		if(userOptional.get().getPassword().equals(loginDTO.getPassword())) return "Login Successful";
    		return "Wrong Password !";
    	}
    	return "User does not exist";
    }
    
    
    public String register(RegisterDTO registerDTO) {
        Optional<User> userOptional = findByEmail(registerDTO.getEmail());

        if (userOptional.isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(registerDTO.getUserName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        userDao.save(user);

        return "User registered successfully";
    }

    
    // Save or update user
    public User save(User user) {
        return userDao.save(user);
    }

    // Find user by ID
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    // Find all users
    public List<User> findAll() {
        return userDao.findAll();
    }

    // Delete user by ID
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    // Delete a user entity
    public void delete(User user) {
        userDao.delete(user);
    }

    // Check if user exists by ID
    public boolean existsById(Long id) {
        return userDao.existsById(id);
    }

    // Count total users
    public long count() {
        return userDao.count();
    }

    // Find user by email (if you added this method in UserDao)
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    // Check if username exists (if you added this method in UserDao)
    public boolean existsByUserName(String username) {
        return userDao.existsByUserName(username);
    }
}
