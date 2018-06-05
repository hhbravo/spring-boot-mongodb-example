package com.example.springbootmongodbexample.config;

import com.example.springbootmongodbexample.document.Users;
import com.example.springbootmongodbexample.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created on 5/06/2018.
 *
 * @author Entelgy
 */
@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
        return strings -> {
            usersRepository.save(new Users(1L, "Hans", "Development", 3000L));
            usersRepository.save(new Users(1L, "Franklin", "Development", 6000L));
        };
    }


}
