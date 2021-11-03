package com.example.authentication.controller;

import com.example.authentication.domain.Role;
import com.example.authentication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/ROLE_{name}")
    public Role findByRoleName(@PathVariable(value = "name") String roleName){
        return roleService.findByName(roleName);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") Long roleId){
        return roleService.findByRoleId(roleId);
    }

    @PostMapping
    public Role addNewRole(@RequestBody Role role){
        return roleService.addNewRole(role);
    }

    @PutMapping("/{id}")
    Role updateRole(@PathVariable(value = "id") Long roleId, @RequestBody Role role){
        return roleService.updateRole(roleId, role);
    }

    @DeleteMapping("/{id}")
    String deleteRole(@PathVariable Long roleId){
        return roleService.deleteRole(roleId);
    }

    @PostConstruct
    public void initRole(){
        roleService.initRole();
    }


}
