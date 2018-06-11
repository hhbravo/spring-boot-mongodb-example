package com.hhbravo.springmongodbdemo.config;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@EnableMongoRepositories
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoDBUri;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {

        MongoClientOptions.Builder mcoBuilder = MongoClientOptions.builder();
        MongoClientURI mongoClientUri = new MongoClientURI(mongoDBUri, mcoBuilder);
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClientUri);
        return new MongoTemplate(simpleMongoDbFactory);
    }
}