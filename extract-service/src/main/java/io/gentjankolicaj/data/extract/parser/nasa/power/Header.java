package io.gentjankolicaj.data.extract.parser.nasa.power;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Header {

    private String apiVersion;
    private String title;
    private Date startDate;
    private Date endDate;

}
