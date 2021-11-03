package com.example.authentication.service;

import com.example.authentication.domain.Role;
import com.example.authentication.domain.User;
import com.example.authentication.repository.RoleRepository;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("NO_SUCH_USER")
        );
    }

    public User registerUser(User user){
        addDefaultRoleToNewUser(user);
        return userRepository.save(user);
    }

    public void addDefaultRoleToNewUser(User user){
        Role defaultRole = roleRepository.findByName("USER");
        user.addRole(defaultRole);
    }

    public void adminRoleOnStartUp(User user){
        Role adminRole = roleRepository.findByName("ADMIN");
        user.addRole(adminRole);
    }

    public void initSuperUser(){
        User adminUser = new User();
        adminUser.setEmail("admin");
        adminUser.setFirstName("super");
        adminUser.setLastName("admin");
        adminUser.setPassword("password");

        userRepository.save(adminUser);
    }
}
