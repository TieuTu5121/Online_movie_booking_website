package com.example.nedcinema.service;

import com.example.nedcinema.entity.Roles;

import java.util.List;

public interface RoleService {
    public Roles createRole(Roles roles);
    public Roles updateRole(int UserUID, Roles roles);
    public void deleteRole(int UserUID);
    public Roles getRole(int UserUID);
    public List<Roles> getAll();
}
