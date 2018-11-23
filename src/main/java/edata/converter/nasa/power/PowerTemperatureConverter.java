package edata.converter.nasa.power;

import edata.common.command.nasa.power.PowerTemperatureCommand;
import edata.common.domain.nasa.power.PowerTemperature;
import edata.common.dto.nasa.power.PowerTemperatureDTO;
import edata.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

@Component
public class PowerTemperatureConverter implements MyNasaPowerConverter<PowerTemperature, PowerTemperatureDTO, PowerTemperatureCommand> {

    public PowerTemperatureConverter() {
    }

    @Override
    public PowerTemperatureDTO sourceToDto(PowerTemperature source) {
        return null;
    }

    @Override
    public PowerTemperatureCommand sourceToCommand(PowerTemperature source) {
        return null;
    }

    @Override
    public PowerTemperature dtoToSource(PowerTemperatureDTO dto) {
        return null;
    }

    @Override
    public PowerTemperature commandToSource(PowerTemperatureCommand command) {
        return null;
    }
}
