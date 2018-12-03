package edata.util.nasa.power;

import edata.common.domain.nasa.power.PowerPressure;
import edata.util.DateUtil;
import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;

import java.util.*;


public class PowerPressureParser {

    public static List<PowerPressure> parsePressure(String rawText,String pressureSymbol){
        List<PowerPressure> list=new ArrayList<PowerPressure>();

        String  values= StringUtils.substringBetween(rawText,"\"properties\": {\n" +
                "    \"parameter\": {\n" +
                "     \"PS\": {\n" +
                "      ","     }\n" +
                "    }\n" +
                "   }, \n" +
                "   \"type\": \"Feature\"\n" +
                "  }\n" +
                " ");
        Map<String,String> dataMap=null;
        if(values!=null){
            dataMap=findData(':',values);
        }


        String header=StringUtils.substringBetween(rawText," \"header\":","}, \n" +
                " \"messages\":");

        Set<String> keySet=dataMap.keySet();
        for(String key:keySet){
            PowerPressure temp=new PowerPressure();
            temp.setDate(DateUtil.parse("yyyyMMDD",key));
            temp.setValue(Float.valueOf(dataMap.get(key)));
            list.add(temp);
        }


        return list;


    }

  private static  Map<String,String> findData(char c,String values){
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
                i=i+25;
            }
        }
        return temp;
    }


}
