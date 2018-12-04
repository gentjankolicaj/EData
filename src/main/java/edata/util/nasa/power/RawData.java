package edata.util.nasa.power;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawData {

    private Date date;
    private Float value;
    private String url;
    private Header header;
    private ParameterInformation parameterInformation;

}
