package com.hhbravo.springmongodbdemo.service;

import com.hhbravo.springmongodbdemo.document.Users;

import java.util.List;

public interface IUsersService {

    List<Users> getAll();

    Users getById(Integer id);

    Users create(Users users);
}
