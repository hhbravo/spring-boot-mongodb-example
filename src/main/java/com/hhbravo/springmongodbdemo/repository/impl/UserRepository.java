package com.hhbravo.springmongodbdemo.repository.impl;

import com.hhbravo.springmongodbdemo.document.Users;
import com.hhbravo.springmongodbdemo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public UserRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Users> findAll() {
        return mongoOperations.findAll(Users.class);
    }

    @Override
    public Users findOne(Integer id) {
        return mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Users.class);
    }

    @Override
    public Users save(Users users) {
        mongoOperations.save(users);
        return users;
    }
}
