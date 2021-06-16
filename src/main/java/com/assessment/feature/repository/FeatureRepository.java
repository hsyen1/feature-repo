package com.assessment.feature.repository;

import com.assessment.feature.repository.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Yen Han Sern
 * Created on: 10:46 PM, 16/06/2021
 */
public interface FeatureRepository extends JpaRepository<Feature, Long> {

    Feature findByFeatureCode(String featureCode);
}
