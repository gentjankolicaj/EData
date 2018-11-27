package edata.common.command.nasa.power;


import edata.common.command.DataFormatCommand;
import edata.common.command.TemperatureUnitCommand;
import edata.common.command.UserCommand;
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
public class PowerTemperatureCommand {

    @NotNull
    private Long id;

    @NotNull
    private UserCommand userCommand;

    @NotNull
    private Float value;

    @NotNull
    private TemperatureUnitCommand temperatureUnitCommand;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String url;

    @NotNull
    private IdentifierCommand identifierCommand;

    @NotNull
    private DataFormatCommand rawDataFormatCommand;
}
