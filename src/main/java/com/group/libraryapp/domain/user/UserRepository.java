package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where name = ?
   Optional<User> findByName(String name); //반환타입은 User
}
