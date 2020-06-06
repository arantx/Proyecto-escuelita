package com.uabc.edu.appswbd.demo_examen.repository;

import java.util.Optional;

import com.uabc.edu.appswbd.demo_examen.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);

}