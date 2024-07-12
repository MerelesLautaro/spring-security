package com.example.springsecurity.controller;


import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.UserSec;
import com.example.springsecurity.service.IRoleService;
import com.example.springsecurity.service.IUserSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserSecController {
    @Autowired
    private IUserSecService userServ;

    @Autowired
    private IRoleService rolServ;

    @GetMapping("/get")
    public ResponseEntity<List<UserSec>> findUsers(){
        return ResponseEntity.ok(userServ.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserSec> findUserById(@PathVariable Long id){
        Optional<UserSec> user = userServ.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<UserSec> save(@RequestBody UserSec userSec){
        Set<Role> roleList = new HashSet<>();
        Role readRole;

        //Encriptar password
        userSec.setPassword(userServ.encriptPassword(userSec.getPassword()));

        for(Role role : userSec.getRolesList()){
            readRole = rolServ.findById(role.getId()).orElse(null);
            if(readRole != null){
                roleList.add(readRole);
            }
        }

        if(!roleList.isEmpty()){
            userSec.setRolesList(roleList);
            return ResponseEntity.ok(userServ.save(userSec));
        }

        return null;
    }

}
