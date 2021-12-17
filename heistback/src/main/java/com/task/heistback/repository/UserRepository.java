package com.task.heistback.repository;

import com.task.heistback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User as users WHERE users.email = ?1 AND users.password = ?2")
    public User FindAllWithDescriptionQuery(String username, String password);

}
