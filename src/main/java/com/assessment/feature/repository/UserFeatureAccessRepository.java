package com.assessment.feature.repository;

import com.assessment.feature.repository.entity.UserFeatureAccess;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Yen Han Sern
 * Created on: 10:46 PM, 16/06/2021
 */
public interface UserFeatureAccessRepository extends JpaRepository<UserFeatureAccess, Long> {

    UserFeatureAccess findByUserIdAndFeatureId(Long userId, Long featureId);

    void deleteByUserIdAndFeatureId(Long userId, Long featureId);
}
