package com.assessment.feature.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: Yen Han Sern
 * Created on: 5:04 PM, 13/06/2021
 */
@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String featureCode;

    private String featureName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
