package com.example.authentication.service;

import com.example.authentication.domain.Role;
import com.example.authentication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleServiceImplementation implements RoleService{

    @Autowired private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRoleId(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(
                () -> new NoSuchElementException("ROLE DOES NOT EXIST")
        );
    }

    @Override
    public Role findByName(String roleName){
        return roleRepository.findByName(roleName);
    }

    @Override
    public Role addNewRole(Role role) {
//        try {
            return roleRepository.save(role);
//        } catch (EntityExistsException e){
//            throw e;
//        }
    }

    @Override
    public Role updateRole(Long roleId, Role role) {
        Role existingRole = roleRepository.findById(roleId).orElseThrow(
                () -> new NoSuchElementException("Role not found in database")
        );
        existingRole.setName(role.getName());

        return roleRepository.save(existingRole);
    }

    @Override
    public String deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(
                () -> new NoSuchElementException("Role "+ roleId + "doest not exist")
        );
        roleRepository.deleteById(roleId);
        return "Role has been deleted!";
    }

    @Override
    public void initRole(){
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);
    }
}
