package edata.util.nasa.power;

import edata.common.domain.nasa.power.PowerPressure;
import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class PowerPressureParser {

    public static List<PowerPressure> parsePressure(String rawText,String pressureSymbol){
        List<PowerPressure> list=new ArrayList<PowerPressure>();

        String values= StringUtils.substringBetween(rawText,"\"properties\": {\n" +
                "    \"parameter\": {\n" +
                "     \"PS\": {\n" +
                "      ","     }\n" +
                "    }\n" +
                "   }, \n" +
                "   \"type\": \"Feature\"\n" +
                "  }\n" +
                " ");
        String header=StringUtils.substringBetween(rawText," \"header\":","}, \n" +
                " \"messages\":");


        return list;


    }
}
