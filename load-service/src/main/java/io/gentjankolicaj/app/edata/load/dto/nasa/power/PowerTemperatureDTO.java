package io.gentjankolicaj.app.edata.load.dto.nasa.power;

import io.gentjankolicaj.app.edata.load.dto.TemperatureUnitDTO;
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
