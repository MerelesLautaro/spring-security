package com.example.springsecurity.service;

import com.example.springsecurity.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    public List<Permission> findAll();
    public Optional<Permission> findById(Long id);
    public Permission save(Permission permission);
    public void deleteById(Long id);
    public Permission update(Permission permission);
}
