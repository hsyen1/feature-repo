package com.assessment.feature.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author: Yen Han Sern
 * Created on: 5:15 PM, 13/06/2021
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo {

    private Boolean success;

    private String message;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
