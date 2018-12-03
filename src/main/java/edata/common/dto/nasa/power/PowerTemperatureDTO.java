package edata.common.dto.nasa.power;

import edata.common.domain.User;

import edata.common.dto.DataFormatDTO;
import edata.common.dto.TemperatureUnitDTO;
import edata.common.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureDTO {

    private Long id;

    private UserDTO userDTO;

    private Float value;

    private TemperatureUnitDTO temperatureUnitDTO;

    private Date date;

    private String url;

    private IdentifierDTO identifierDTO;

    private DataFormatDTO rawDataFormatDTO;
}
