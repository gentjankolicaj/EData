package io.gentjankolicaj.data.load.common.command.nasa.power;

import io.gentjankolicaj.data.load.common.command.PressureUnitCommand;
import io.gentjankolicaj.data.load.statistic.core.Attribute;
import io.gentjankolicaj.data.load.statistic.core.Item;
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
public class PowerPressureCommand implements Item {

    @NotNull
    private Long id;


    @NotNull
    private Float value;

    @NotNull
    private PressureUnitCommand pressureUnitCommand;

    @NotNull
    private LocalDate date;

    @Override
    public Attribute getAttribute() {
        Attribute attribute = new Attribute();
        attribute.setName("Pressure");
        attribute.setValue(this.value);
        return attribute;
    }
}
