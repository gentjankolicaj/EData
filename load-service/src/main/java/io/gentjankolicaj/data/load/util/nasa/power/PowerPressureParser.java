package io.gentjankolicaj.data.load.util.nasa.power;

import io.gentjankolicaj.data.load.common.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.load.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PowerPressureParser {

    public static List<PowerPressure> parsePressure(String rawText, String pressureSymbol) {

        String strValues = StringUtils.substringBetween(rawText, "\"properties\": {\n" +
                "    \"parameter\": {\n" +
                "     \"" + pressureSymbol + "\": {\n" +
                "      ", "     }\n" +
                "    }\n" +
                "   }, \n" +
                "   \"type\": \"Feature\"\n" +
                "  }\n" +
                " ");

        String headerString = StringUtils.substringBetween(rawText, " \"header\":", ", \n" +
                " \"messages\":");

        String paramInfoString = StringUtils.substringBetween(rawText, "\"parameterInformation\": ", " }, \n" +
                " \"time\": [");

        String url = StringUtils.substringBetween(rawText, " \"outputs\": {", " }, \n" +
                " \"parameterInformation\": {");

        Header header = findHeader(headerString);

        ParameterInformation parameterInformation = findParameterInformation(paramInfoString);


        List<RawData> rawData = null;
        if (strValues != null) {
            rawData = findData(':', strValues, url, header, parameterInformation);
        }

        return getDomainList(rawData);
    }

    private static List<RawData> findData(char c, String values, String url, Header header, ParameterInformation parameterInformation) {
        List<RawData> list = new ArrayList<>();
        for (int i = 0; i < values.length(); i++) {
            if (values.charAt(i) == c) {
                RawData rawData = new RawData();
                rawData.setHeader(header);
                rawData.setParameterInformation(parameterInformation);

                Date date = findDate(values, i);
                Float value = findValue(values, i);

                rawData.setDate(date);
                rawData.setValue(value);
                rawData.setUrl(url);

                list.add(rawData);

                i = i + 25;
            }
        }
        return list;
    }


    private static Header findHeader(String headerString) {
        Header header = new Header();
        String apiVersion = StringUtils.substringBetween(headerString, "\"api_version\": \"", "\", \n" +
                "  \"endDate\":");
        String endDate = StringUtils.substringBetween(headerString, "\"endDate\": \"", "\", \n" +
                "  \"fillValue\":");
        String startDate = StringUtils.substringBetween(headerString, "\"startDate\": \"", "\", \n" +
                "  \"title\":");
        String title = StringUtils.substringBetween(headerString, "\"title\": \"", "\"\n" +
                " }");
        header.setApiVersion(apiVersion);
        header.setEndDate(DateUtil.parse("yyyyMMDD", endDate));
        header.setStartDate(DateUtil.parse("yyyyMMDD", startDate));
        header.setTitle(title);
        return header;
    }


    private static ParameterInformation findParameterInformation(String parameterInformationString) {
        ParameterInformation parameterInformation = new ParameterInformation();

        String longName = StringUtils.substringBetween(parameterInformationString, "\"longname\": \"", "\", \n" +
                "   \"units\":");
        String units = StringUtils.substringBetween(parameterInformationString, "\"units\": \"", "\"\n" +
                "  }");
        parameterInformation.setLongName(longName);
        parameterInformation.setUnits(units);
        return parameterInformation;
    }


    private static Date findDate(String str, int index) {
        String date = str.substring(index - 10, index);
        if (date.contains("\"")) {
            date = StringUtils.remove(date, '"');

        }
        return DateUtil.parse("yyyyMMDD", date);
    }

    private static Float findValue(String str, int index) {
        String value = str.substring(index + 1, index + 7).trim();
        if (value.contains(",")) {
            value = StringUtils.remove(value, ',');
        }
        return Float.valueOf(value);
    }


    private static List<PowerPressure> getDomainList(List<RawData> rawDataList) {
        List<PowerPressure> pressureList = new ArrayList<>();
        for (RawData var : rawDataList) {
            PowerPressure temp = new PowerPressure();
            temp.setUrl(var.getUrl());
            temp.setDate(var.getDate());
            temp.setValue(var.getValue());
            pressureList.add(temp);
        }
        return pressureList;

    }


}
