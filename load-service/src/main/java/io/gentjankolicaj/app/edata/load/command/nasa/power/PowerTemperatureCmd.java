package io.gentjankolicaj.app.edata.load.command.nasa.power;


import io.gentjankolicaj.app.edata.load.command.TemperatureUnitCmd;
import io.gentjankolicaj.app.edata.load.statistic.core.Attribute;
import io.gentjankolicaj.app.edata.load.statistic.core.Item;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureCmd implements Item {

    @NotNull
    private Long id;

    @NotNull
    private Float value;

    @NotNull
    private TemperatureUnitCmd temperatureUnitCmd;

    @NotNull
    private LocalDate date;

    @NotNull
    private String url;


    @Override
    public Attribute getAttribute() {
        Attribute attribute = new Attribute();
        attribute.setName("Temperature");
        attribute.setValue(this.value);
        return attribute;
    }
}
