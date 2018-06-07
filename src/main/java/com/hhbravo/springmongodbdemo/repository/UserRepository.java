package com.hhbravo.springmongodbdemo.repository;


import com.hhbravo.springmongodbdemo.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
