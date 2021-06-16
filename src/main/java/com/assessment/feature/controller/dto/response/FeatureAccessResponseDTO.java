package com.assessment.feature.controller.dto.response;

import com.assessment.feature.common.ResultInfo;

/**
 * @author: Yen Han Sern
 * Created on: 5:03 PM, 13/06/2021
 */
public class FeatureAccessResponseDTO extends ResultInfo {

    private boolean canAccess;

    public boolean isCanAccess() {
        return canAccess;
    }

    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
