package com.example.springsecurity.service;

import com.example.springsecurity.model.UserSec;
import com.example.springsecurity.repository.IUserSecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSecService implements IUserSecService{
    @Autowired
    private IUserSecRepository userRepo;

    @Override
    public List<UserSec> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserSec save(UserSec userSec) {
        return userRepo.save(userSec);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(UserSec userSec) {
        userRepo.save(userSec);
    }
}
