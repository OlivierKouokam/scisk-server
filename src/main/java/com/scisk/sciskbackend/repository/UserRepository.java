package com.scisk.sciskbackend.repository;

import com.scisk.sciskbackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    @Query("{email:'?0'}")
    List<User> existsByEmail(String email);

}
