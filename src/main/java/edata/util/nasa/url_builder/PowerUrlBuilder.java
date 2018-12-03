package edata.util.nasa.url_builder;

import edata.common.enums.power.Identifier;
import edata.common.enums.power.DataParameters;
import edata.common.enums.power.OutputFormat;
import edata.common.enums.power.TempAverage;
import edata.common.enums.power.UserCommunity;
import edata.validator.UrlParamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PowerUrlBuilder {

    private final UrlParamValidator urlParamValidator;

    private String baseUrl="https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute";
    private Identifier identifier;
    private DataParameters dataParameters;
    private String startDate;
    private String endDate;
    private UserCommunity userCommunity;
    private TempAverage tempAverage;
    private OutputFormat outputFormat;
    private String lat;
    private String lon;
    private String bbox;

    @Autowired
    public PowerUrlBuilder(UrlParamValidator urlParamValidator) {
        this.urlParamValidator = urlParamValidator;
    }

    public PowerUrlBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public PowerUrlBuilder setDataParameters(DataParameters dataParameters) {
        this.dataParameters = dataParameters;
        return this;
    }

    public PowerUrlBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public PowerUrlBuilder setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public PowerUrlBuilder setUserCommunity(UserCommunity userCommunity) {
        this.userCommunity = userCommunity;
        return this;
    }

    public PowerUrlBuilder setTempAverage(TempAverage tempAverage) {
        this.tempAverage = tempAverage;
        return this;
    }

    public PowerUrlBuilder setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat=outputFormat;
        return this;
    }

    public PowerUrlBuilder setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public PowerUrlBuilder setLon(String lon) {
        this.lon = lon;
        return this;
    }

    public PowerUrlBuilder setBbox(String bbox) {
        this.bbox = bbox;
        return this;
    }

    public String build(){
        String url=this.baseUrl;
        if(identifier.equals(Identifier.SinglePoint)){
            //https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute&identifier=SinglePoint&
            // parameters=T2M,PS,ALLSKY_SFC_SW_DWN&startDate=20160301&endDate=20160331&userCommunity=SSE&
            // tempAverage=DAILY&outputList=JSON,ASCII&lat=36&lon=45&user=anonymous

            urlParamValidator.validateSecond(identifier.getValue(),dataParameters.getValue(),startDate,endDate,userCommunity.getValue(),tempAverage.getValue(),outputFormat.getValue(),lon,lat);

            url=url+"&identifier="+identifier.getValue()+"&parameters="+this.dataParameters.getValue()+
                    "&startDate="+this.startDate+"&endDate="+endDate+
                    "&userCommunity="+userCommunity.getValue()+"&tempAverage="+this.tempAverage.getValue()
                    +"&outputList="+this.outputFormat+"&lat="+this.lat+"&lon="+this.lon+"&user=anonymous" ;
            return url;

        }else if(identifier.equals(Identifier.Regional)){
            //  https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute&
            // identifier=Regional&parameters=T2M,ALLSKY_SFC_SW_DWN&startDate=19830701&endDate=19830705
            // &userCommunity=SSE&tempAverage=DAILY&
            // outputList=ASCII&bbox=-40,-70,-38,-66&user=anonymous

            urlParamValidator.validateSecond(identifier.getValue(),dataParameters.getValue(),startDate,endDate,userCommunity.getValue(),tempAverage.getValue(),outputFormat.getValue(),bbox);


            url=url+"&identifier="+identifier.getValue()+"&parameters="+this.dataParameters.getValue()+
                    "&startDate="+this.startDate+"&endDate="+endDate+
                    "&userCommunity="+userCommunity.getValue()+"&tempAverage="+this.tempAverage.getValue()
                    +"&outputList="+this.outputFormat+"&bbox="+this.bbox+"&user=anonymous" ;
            return url;
        }else{

            //https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute&identifier=Global
            // &parameters=T2M,ALLSKY_SFC_SW_DWN,PS&userCommunity=SSE
            // &tempAverage=CLIMATOLOGY&
            // outputList=NETCDF&user=anonymous

            urlParamValidator.validateSecond(identifier.getValue(),dataParameters.getValue(),userCommunity.getValue(),tempAverage.getValue(),outputFormat.getValue());


            url=url+"&identifier="+identifier.getValue()+"&parameters="+this.dataParameters.getValue()+
                    "&userCommunity="+userCommunity.getValue()+"&tempAverage="+this.tempAverage.getValue()
                    +"&outputList="+this.outputFormat+"&user=anonymous" ;
            return url;

        }
    }
}
