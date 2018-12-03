package edata.common.dto.nasa.power;

import edata.common.domain.User;
import edata.common.dto.DataFormatDTO;
import edata.common.dto.PressureUnitDTO;
import edata.common.dto.UserDTO;
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
public class PowerPressureDTO {

    private Long id;

    private UserDTO userDTO;

    private Float value;

    private PressureUnitDTO pressureUnitDTO;

    private Date date;

    private String url;

    private IdentifierDTO identifierDTO;

    private DataFormatDTO rawDataFormatDTO;

}
