package edata.common.command.nasa.power;


import edata.common.command.DataFormatCommand;
import edata.common.command.TemperatureUnitCommand;
import edata.common.command.UserCommand;
import edata.statistic.core.Attribute;
import edata.statistic.core.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureCommand implements Item {

    @NotNull
    private Long id;

    @NotNull
    private UserCommand userCommand;

    @NotNull
    private Float value;

    @NotNull
    private TemperatureUnitCommand temperatureUnitCommand;

    @NotNull
    private Date date;

    @NotNull
    private String url;

    @NotNull
    private IdentifierCommand identifierCommand;

    @NotNull
    private DataFormatCommand rawDataFormatCommand;

    @Override
    public Attribute getAttribute() {
        Attribute attribute= new Attribute();
        attribute.setName("Temperature");
        attribute.setValue(this.value);
        return attribute;
    }
}
