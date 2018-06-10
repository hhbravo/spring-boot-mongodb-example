package com.example.springbootmongodbexample.repository;

import com.example.springbootmongodbexample.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 5/06/2018.
 *
 * @author Entelgy
 */
public interface UsersRepository extends MongoRepository<Users,Long>{
}
