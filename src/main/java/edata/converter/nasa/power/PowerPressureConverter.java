package edata.converter.nasa.power;

import edata.common.command.nasa.power.PowerPressureCommand;
import edata.common.domain.nasa.power.PowerPressure;
import edata.common.dto.nasa.power.PowerPressureDTO;
import edata.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

@Component
public class PowerPressureConverter implements MyNasaPowerConverter<PowerPressure, PowerPressureDTO, PowerPressureCommand> {

    public PowerPressureConverter() {
    }

    @Override
    public PowerPressureDTO sourceToDto(PowerPressure source) {
        return null;
    }

    @Override
    public PowerPressureCommand sourceToCommand(PowerPressure source) {
        return null;
    }

    @Override
    public PowerPressure dtoToSource(PowerPressureDTO dto) {
        return null;
    }

    @Override
    public PowerPressure commandToSource(PowerPressureCommand command) {
        return null;
    }
}
