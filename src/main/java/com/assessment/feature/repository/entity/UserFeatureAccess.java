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
public class UserFeatureAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;

    private long featureId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(long featureId) {
        this.featureId = featureId;
    }
}
