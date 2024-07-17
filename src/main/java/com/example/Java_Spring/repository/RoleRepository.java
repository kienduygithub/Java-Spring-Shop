package com.example.Java_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Java_Spring.domain.Role;
import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Role findByName(String name);

}
