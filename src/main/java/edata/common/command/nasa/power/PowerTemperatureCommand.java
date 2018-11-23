package edata.common.command.nasa.power;


import edata.common.command.DataFormatCommand;
import edata.common.command.TemperatureUnitCommand;
import edata.common.command.UserCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerTemperatureCommand {

    private Long id;

    private UserCommand userCommand;

    private Float value;

    private TemperatureUnitCommand TemperatureUnitCommand;

    private Date startDate;

    private Date endDate;

    private String url;

    private IdentifierCommand identifierCommand;

    private DataFormatCommand rawDataFormatCommand;
}
