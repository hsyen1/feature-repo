package com.assessment.feature.repository.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author: Yen Han Sern
 * Created on: 12:24 AM, 17/06/2021
 */
@Embeddable
public class UserFeatureAccessId implements Serializable {

    private long userId;

    private long featureId;

    public UserFeatureAccessId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFeatureAccessId that = (UserFeatureAccessId) o;
        return userId == that.userId &&
                featureId == that.featureId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, featureId);
    }
}
