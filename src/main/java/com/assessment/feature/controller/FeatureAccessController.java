package com.assessment.feature.controller;

import com.assessment.feature.controller.dto.request.FeatureAccessRequestDTO;
import com.assessment.feature.controller.dto.response.FeatureAccessResponseDTO;
import com.assessment.feature.service.FeatureService;
import com.assessment.feature.service.model.UserAccessBO;
import com.assessment.feature.service.model.UserAccessRequestBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Yen Han Sern
 * Created on: 5:03 PM, 13/06/2021
 */
@RestController
public class FeatureAccessController {

    @Autowired
    private FeatureService featureService;

    Logger logger = LoggerFactory.getLogger(FeatureAccessController.class);

    @GetMapping(value = "/feature")
    public FeatureAccessResponseDTO getAccess(@RequestParam String email, @RequestParam String featureName) {
        UserAccessBO userAccessBO = featureService.getUserAccess(email, featureName);

        return composeAccessResult(userAccessBO);
    }

    @PostMapping(value = "/feature")
    public ResponseEntity<String> updateAccess(@RequestBody FeatureAccessRequestDTO request) {
        UserAccessBO userAccessBO = featureService.updateUserAccess(convertToUserAccessBO(request));

        return userAccessBO.isSuccess() ?
                new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    private UserAccessRequestBO convertToUserAccessBO(FeatureAccessRequestDTO requestDTO) {
        UserAccessRequestBO userAccessRequestBO = new UserAccessRequestBO();

        userAccessRequestBO.setFeatureCode(requestDTO.getFeatureName());
        userAccessRequestBO.setEmail(requestDTO.getEmail());
        userAccessRequestBO.setEnable(requestDTO.isEnable());

        return userAccessRequestBO;
    }

    private FeatureAccessResponseDTO composeAccessResult(UserAccessBO userAccessBO) {
        FeatureAccessResponseDTO responseDTO = new FeatureAccessResponseDTO();

        if(!userAccessBO.isSuccess()) {
            responseDTO.setSuccess(false);
            responseDTO.setMessage(userAccessBO.getMessage());
        }

        responseDTO.setCanAccess(userAccessBO.isCanAccess());

        return responseDTO;
    }
}
