package com.mmacedoaraujo.repository;

import com.mmacedoaraujo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * from user_tb WHERE UPPER(name) LIKE CONCAT(UPPER(?1), '%')", nativeQuery = true)
    public List<User> findByName(String name);
}
