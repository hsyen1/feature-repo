package com.assessment.feature.repository;

import com.assessment.feature.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Yen Han Sern
 * Created on: 10:46 PM, 16/06/2021
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
