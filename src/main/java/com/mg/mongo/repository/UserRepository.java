package com.mg.mongo.repository;

import com.mg.mongo.repository.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
