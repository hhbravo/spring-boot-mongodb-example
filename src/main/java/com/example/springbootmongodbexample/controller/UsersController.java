package com.example.springbootmongodbexample.controller;

import com.example.springbootmongodbexample.document.Users;
import com.example.springbootmongodbexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 5/06/2018.
 *
 * @author Entelgy
 */
@RestController
@RequestMapping("/rest/users/")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }
}
