package edata.util.nasa.power;

import edata.common.domain.nasa.power.PowerTemperature;
import edata.util.DateUtil;
import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;

import java.util.*;


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

        Map<String,String> dataMap=null;
        if(values!=null){
            dataMap=findData(':',values);
        }

        String header=StringUtils.substringBetween(rawText," \"header\":","}, \n" +
                " \"messages\":");

        Set<String> keySet=dataMap.keySet();
        for(String key:keySet){
            PowerTemperature temp=new PowerTemperature();
            temp.setDate(DateUtil.parse("yyyyMMDD",key));
            temp.setValue(Float.valueOf(dataMap.get(key)));
            list.add(temp);
        }

        return list;
    }

    private static Map<String,String> findData(char c, String values){
        Map<String,String> temp=new HashMap<String,String>();
        for(int i=0;i<values.length();i++){
            if(values.charAt(i)==c){
                String date=values.substring(i-10,i);
                String value=values.substring(i+1,i+7).trim();
                if(date.contains("\"")){
                    date=StringUtils.remove(date,'"');

                }
                if(value.contains(",")){
                    value=StringUtils.remove(value,',');
                }
                temp.put(date,value);
                i=i+24;
            }
        }
        return temp;
    }




}
