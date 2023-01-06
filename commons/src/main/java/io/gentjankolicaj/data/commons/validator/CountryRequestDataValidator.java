package io.gentjankolicaj.data.commons.validator;

import io.gentjankolicaj.data.commons.validator.core.MyRequestDataValidator;

import java.util.List;


public class CountryRequestDataValidator implements MyRequestDataValidator<String, List<String>> {

    public CountryRequestDataValidator() {
    }

    @Override
    public boolean validateFirst(String requestData) {
        if (requestData == null || requestData.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validateSecond(List<String> requestData) {
        boolean status = true;
        for (String data : requestData) {
            if (data == null || data.equals(""))
                status = false;

        }
        return status;
    }
}
