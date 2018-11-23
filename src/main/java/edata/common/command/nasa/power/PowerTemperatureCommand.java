package edata.common.command.nasa.power;


import edata.common.domain.DataFormat;
import edata.common.domain.PressureUnit;
import edata.common.domain.User;
import edata.common.domain.nasa.power.Identifier;
import edata.common.dto.DataFormatDTO;
import edata.common.dto.TemperatureUnitDTO;
import edata.common.dto.nasa.power.IdentifierDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureCommand {



    private Long id;


    private User user;


    private Float value;


    private TemperatureUnitDTO temperatureUnitDTO;


    private Date startDate;


    private Date endDate;

    private String url;


    private IdentifierDTO identifierDTO;


    private DataFormatDTO rawDataFormatDTO;
}
