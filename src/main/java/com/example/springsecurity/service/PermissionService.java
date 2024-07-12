package com.example.springsecurity.service;

import com.example.springsecurity.model.Permission;
import com.example.springsecurity.repository.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService{
    @Autowired
    private IPermissionRepository permRepo;

    @Override
    public List<Permission> findAll() {
        return permRepo.findAll();
    }

    @Override
    public Optional<Permission> findById(Long id) {
        return permRepo.findById(id);
    }

    @Override
    public Permission save(Permission permission) {
        permRepo.save(permission);
        return permission;
    }

    @Override
    public void deleteById(Long id) {
        permRepo.deleteById(id);
    }

    @Override
    public Permission update(Permission permission) {
        this.save(permission);
        return permission;
    }
}
