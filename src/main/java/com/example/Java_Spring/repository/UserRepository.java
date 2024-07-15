package com.example.Java_Spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Java_Spring.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User save(User user);
}
