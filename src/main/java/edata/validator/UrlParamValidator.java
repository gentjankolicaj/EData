package edata.validator;

import edata.exception.url.BadUrlParamException;
import edata.validator.core.MyParamValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UrlParamValidator implements MyParamValidator<String,String[],List<String>, ArrayList<String>> {
    @Override
    public boolean validateFirst(String requestData) {
        if(requestData==null||requestData.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean validateSecond(String... requestData) {
             for(String data:requestData){
              if(data==null||data.equals(""))
                throw new BadUrlParamException("One of the url params is null or empty.");

               }
        return true;
    }

    @Override
    public boolean validateThird(List<String> requestData) {
        return false;
    }

    @Override
    public boolean validateFourth(ArrayList<String> requestData) {
        return false;
    }
}
