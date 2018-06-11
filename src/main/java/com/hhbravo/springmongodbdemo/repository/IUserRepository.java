package com.hhbravo.springmongodbdemo.repository;


import com.hhbravo.springmongodbdemo.document.Users;

import java.util.List;

public interface IUserRepository {

    List<Users> findAll();

    Users findOne(Integer id);

    Users save(Users users);
}
