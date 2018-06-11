package com.hhbravo.springmongodbdemo.service.impl;

import com.hhbravo.springmongodbdemo.document.Users;
import com.hhbravo.springmongodbdemo.repository.IUserRepository;
import com.hhbravo.springmongodbdemo.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<Users> getAll() {
        return repository.findAll();
    }

    @Override
    public Users getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Users create(Users users) {
        return repository.save(users);
    }
}
