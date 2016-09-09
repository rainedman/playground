package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by will cao on 9/9/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
