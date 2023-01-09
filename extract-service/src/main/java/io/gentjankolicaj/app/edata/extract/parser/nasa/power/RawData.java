package io.gentjankolicaj.app.edata.extract.parser.nasa.power;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawData {

    private LocalDate date;
    private Float value;
    private String url;
    private Header header;
    private ParameterInformation parameterInformation;

}
