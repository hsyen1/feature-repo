package com.assessment.feature.service.model;

import com.assessment.feature.common.ResultInfo;

/**
 * @author: Yen Han Sern
 * Created on: 5:03 PM, 13/06/2021
 *
 * BO = Business Object, commonly used in the Service layer
 */
public class UserAccessBO extends ResultInfo {

    private long userId;

    private String email;

    private String featureCode;

    private boolean canAccess;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public boolean isCanAccess() {
        return canAccess;
    }

    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
