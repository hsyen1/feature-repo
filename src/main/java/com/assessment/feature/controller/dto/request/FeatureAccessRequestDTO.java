package com.assessment.feature.controller.dto.request;

/**
 * @author: Yen Han Sern
 * Created on: 5:30 PM, 13/06/2021
 */
public class FeatureAccessRequestDTO {

    private String email;

    private String featureName;

    private boolean enable;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
