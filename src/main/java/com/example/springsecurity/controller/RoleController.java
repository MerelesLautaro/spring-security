package com.example.springsecurity.controller;


import com.example.springsecurity.model.Permission;
import com.example.springsecurity.model.Role;
import com.example.springsecurity.service.IPermissionService;
import com.example.springsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private IRoleService rolServ;

    @Autowired
    private IPermissionService permServ;

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody Role role){
        Set<Permission> permList = new HashSet<>();
        Permission readPermission;

        for(Permission permission : role.getPermissionsList()){
            readPermission = permServ.findById(permission.getId()).orElse(null);
            if(readPermission  != null){
                permList.add(readPermission);
            }
        }

        role.setPermissionsList(permList);
        return ResponseEntity.ok(rolServ.save(role));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Role>> findRoles(){
        return ResponseEntity.ok(rolServ.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable Long id){
        Optional<Role> role = rolServ.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
