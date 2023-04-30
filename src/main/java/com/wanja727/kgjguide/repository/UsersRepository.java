package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
