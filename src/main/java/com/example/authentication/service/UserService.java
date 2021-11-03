package com.example.authentication.service;

import com.example.authentication.domain.Role;
import com.example.authentication.domain.User;
import com.example.authentication.repository.RoleRepository;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    public void initAdmin(){
        User adminUser = new User();
        adminUser.setEmail("admin@gg.gg");
        adminUser.setFirst_name("Super");
        adminUser.setLast_name("ADMIN");
        adminUser.setPassword("pass");

        Set<Role> roles = new HashSet<>();
        Role adminRole = new Role();
        adminRole.setName(null);
        roles.add(adminRole);
        adminUser.setRoles(roles);

        userRepository.save(adminUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }
}
