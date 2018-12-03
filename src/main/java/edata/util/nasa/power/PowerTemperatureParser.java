package edata.util.nasa.power;

import edata.common.domain.nasa.power.PowerTemperature;
import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;



public class PowerTemperatureParser {

    public static List<PowerTemperature> parseTemperature(String rawText,String tempSymbol){
        List<PowerTemperature> list=new ArrayList<PowerTemperature>();

       String values= StringUtils.substringBetween(rawText,"\"properties\": {\n" +
              "    \"parameter\": {\n" +
              "     \""+tempSymbol+"\": {\n" +
              "      "," }\n" +
            "    }\n" +
            "   }, \n" +
            "   \"type\": \"Feature\"\n" +
            "  }");

        String header=StringUtils.substringBetween(rawText," \"header\":","}, \n" +
                " \"messages\":");

        return list;
    }


}
