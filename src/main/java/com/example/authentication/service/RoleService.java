package com.example.authentication.service;

import com.example.authentication.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role findByRoleId(Long roleId);
    Role findByName(String rolename);
    Role addNewRole(Role role);
    Role updateRole(Long roleId, Role role);
    String deleteRole(Long roleId);
    void initRole();
}
