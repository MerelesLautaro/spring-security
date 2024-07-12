package com.example.springsecurity.controller;

import com.example.springsecurity.model.Permission;
import com.example.springsecurity.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    @Autowired
    private IPermissionService permServ;

    @PostMapping("/save")
    public ResponseEntity<Permission> save(@RequestBody Permission permission){
        return ResponseEntity.ok(permServ.save(permission));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Permission>> findAllPermissions(){
        return ResponseEntity.ok(permServ.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Permission> findPermissionById(@PathVariable Long id){
        Optional<Permission> permission = permServ.findById(id);
        //Mapea permission en caso que tenga contenido ('ok') en caso de que no -> da un response entity not found
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
