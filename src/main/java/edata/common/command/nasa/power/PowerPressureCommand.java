package edata.common.command.nasa.power;


import com.sun.javafx.beans.IDProperty;
import edata.common.domain.DataFormat;
import edata.common.domain.PressureUnit;
import edata.common.domain.User;
import edata.common.domain.nasa.power.Identifier;
import edata.common.dto.DataFormatDTO;
import edata.common.dto.PressureUnitDTO;
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
public class PowerPressureCommand {


    private Long id;


    private User user;


    private Float value;


    private PressureUnitDTO pressureUnitDTO;


    private Date startDate;


    private Date endDate;

    private String url;


    private IdentifierDTO identifierDTO;


    private DataFormatDTO rawDataFormatDTO;



}
