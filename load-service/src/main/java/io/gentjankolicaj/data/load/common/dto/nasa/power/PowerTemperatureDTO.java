package io.gentjankolicaj.data.load.common.dto.nasa.power;

import io.gentjankolicaj.data.load.common.dto.TemperatureUnitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureDTO {

    private Long id;

    private Float value;

    private TemperatureUnitDTO temperatureUnitDTO;

    private LocalDate date;


}
