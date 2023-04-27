package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
