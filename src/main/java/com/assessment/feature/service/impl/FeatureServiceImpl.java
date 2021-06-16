package com.assessment.feature.service.impl;

import com.assessment.feature.repository.entity.Feature;
import com.assessment.feature.repository.entity.User;
import com.assessment.feature.repository.entity.UserFeatureAccess;
import com.assessment.feature.repository.FeatureRepository;
import com.assessment.feature.repository.UserFeatureAccessRepository;
import com.assessment.feature.repository.UserRepository;
import com.assessment.feature.service.FeatureService;
import com.assessment.feature.service.model.UserAccessBO;
import com.assessment.feature.service.model.UserAccessRequestBO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


/**
 * @author: Yen Han Sern
 * Created on: 5:25 PM, 13/06/2021
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private UserFeatureAccessRepository userFeatureAccessRepository;

    Logger logger = LoggerFactory.getLogger(FeatureServiceImpl.class);

    @Override
    public UserAccessBO getUserAccess(String email, String featureName) {
        UserAccessBO userAccessBO = new UserAccessBO();

        try {
            validateParams(email, featureName);

            // check if user exists
            User user = userRepository.findByEmail(email);

            Assert.notNull(user, "No such user exists.");

            Feature feature = featureRepository.findByFeatureName(featureName);

            // check if it is a valid code
            Assert.notNull(feature, "No such feature exists.");

            // query access
            UserFeatureAccess userFeatureAccess = userFeatureAccessRepository
                    .findByUserIdAndFeatureId(user.getId(), feature.getId());

            boolean canAccess = userFeatureAccess != null;

            userAccessBO.setCanAccess(canAccess);
            userAccessBO.setUserId(user.getId());
            userAccessBO.setEmail(user.getEmail());
            userAccessBO.setFeatureName(feature.getFeatureName());
            userAccessBO.setSuccess(true);
        } catch(IllegalArgumentException e) {

            logger.error("An exception has occurred: ", e);

            userAccessBO.setSuccess(false);
            userAccessBO.setMessage(e.getMessage());
        }

        return userAccessBO;
    }

    @Override
    @Transactional
    public UserAccessBO updateUserAccess(UserAccessRequestBO userAccessRequestBO) {

        String userEmail = userAccessRequestBO.getEmail();
        String featureName = userAccessRequestBO.getFeatureName();
        boolean enable = userAccessRequestBO.isEnable();
        UserAccessBO userAccessBO = new UserAccessBO();

        try {
            validateParams(userEmail, featureName);

            // check if user exists
            User user = userRepository.findByEmail(userEmail);

            Assert.notNull(user, "No such user exists.");

            Feature feature = featureRepository.findByFeatureName(featureName);

            // check if it is a valid code
            Assert.notNull(feature, "No such feature exists.");

            // query existing access
            UserFeatureAccess existingUserAccess = userFeatureAccessRepository
                    .findByUserIdAndFeatureId(user.getId(), feature.getId());

            if(null == existingUserAccess && enable) {
                UserFeatureAccess userFeatureAccess = new UserFeatureAccess();
                userFeatureAccess.setFeatureId(feature.getId());
                userFeatureAccess.setUserId(user.getId());
                userFeatureAccessRepository.save(userFeatureAccess);
                userAccessBO.setSuccess(true);
            } else if(null != existingUserAccess && !enable) {
                userFeatureAccessRepository.deleteByUserIdAndFeatureId(user.getId(), feature.getId());
                userAccessBO.setSuccess(true);
            } else {
                userAccessBO.setSuccess(false);
            }

        } catch(IllegalArgumentException e) {
            logger.error("An exception has occurred: ", e);

            userAccessBO.setSuccess(false);
            userAccessBO.setMessage(e.getMessage());
        }
        return userAccessBO;
    }

    private void validateParams(String email, String featureName) {
        Assert.isTrue(StringUtils.isNotBlank(email), "user email cannot be blank.");

        Assert.isTrue(StringUtils.isNotBlank(featureName), "feature name cannot be blank");
    }
}
