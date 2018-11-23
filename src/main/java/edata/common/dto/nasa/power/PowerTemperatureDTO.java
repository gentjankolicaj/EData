package edata.common.dto.nasa.power;

import edata.common.domain.User;

import edata.common.dto.DataFormatDTO;
import edata.common.dto.TemperatureUnitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureDTO {

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
