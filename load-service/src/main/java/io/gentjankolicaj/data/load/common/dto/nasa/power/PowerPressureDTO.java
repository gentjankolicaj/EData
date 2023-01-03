package io.gentjankolicaj.data.load.common.dto.nasa.power;

import io.gentjankolicaj.data.load.common.dto.DataFormatDTO;
import io.gentjankolicaj.data.load.common.dto.PressureUnitDTO;
import io.gentjankolicaj.data.load.common.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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