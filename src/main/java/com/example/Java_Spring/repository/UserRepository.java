package com.example.Java_Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Java_Spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User save(User user);

    User findById(long id);

    List<User> findAll();

    List<User> findByEmail(String email);

    User findFirstByEmailOrAddress(String email, String address);
}
