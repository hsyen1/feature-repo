package com.assessment.feature.service;

import com.assessment.feature.common.ResultInfo;
import com.assessment.feature.service.model.UserAccessBO;
import com.assessment.feature.service.model.UserAccessRequestBO;

/**
 * @author: Yen Han Sern
 * Created on: 5:01 PM, 13/06/2021
 */
public interface FeatureService {

    UserAccessBO getUserAccess(String email, String featureCode);

    UserAccessBO updateUserAccess(UserAccessRequestBO userAccessRequestBO);
}
