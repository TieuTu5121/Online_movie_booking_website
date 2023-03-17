package com.example.nedcinema.Impl;

import com.example.nedcinema.entity.Roles;
import com.example.nedcinema.repository.RoleRepository;
import com.example.nedcinema.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository ;
    @Override
    public Roles createRole(Roles roles) {
        return roleRepository.save(roles);
    }

    @Override
    public Roles updateRole(int id, Roles roles) {
        return null;
    }

    @Override
    public void deleteRole(int id) {

    }

    @Override
    public Roles getRole(int UserUID) {
        return null;
    }

    @Override
    public List<Roles> getAll() {
        return null;
    }
}
