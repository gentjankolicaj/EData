package edata.validator;

import edata.validator.core.MyRequestDataValidator;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CountryRequestDataValidator implements MyRequestDataValidator<String, List<String>> {

    public CountryRequestDataValidator() {
    }

    @Override
    public boolean validateFirst(String requestData) {
        if(requestData==null||requestData.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean validateSecond(List<String> requestData) {
        boolean status=true;
        for(String data:requestData){
        if(requestData==null||requestData.equals(""))
           status=false;

        }
        return status;
    }
}
