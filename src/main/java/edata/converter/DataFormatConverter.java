package edata.converter;

import edata.common.command.DataFormatCommand;
import edata.common.domain.DataFormat;
import edata.common.dto.DataFormatDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;

@Component
public class DataFormatConverter implements MyConverter<DataFormat, DataFormatDTO, DataFormatCommand> {

    public DataFormatConverter() {
    }

    @Override
    public DataFormatDTO sourceToDto(DataFormat source) {

        if (source == null) {
            return null;
        } else {
            DataFormatDTO dataFormatDTO = new DataFormatDTO();
            dataFormatDTO.setFormat(source.getFormat());
            return dataFormatDTO;
        }
    }

    @Override
    public DataFormatCommand sourceToCommand(DataFormat source) {
        if (source == null) {
            return null;
        } else {
            DataFormatCommand command = new DataFormatCommand();
            command.setFormat(source.getFormat());
            return command;
        }
    }

    @Override
    public DataFormat dtoToSource(DataFormatDTO dto) {
        if (dto == null) {
            return null;
        } else {
            DataFormat dataFormat = new DataFormat();
            dataFormat.setFormat(dto.getFormat());
            return dataFormat;
        }
    }

    @Override
    public DataFormat commandToSource(DataFormatCommand command) {
        if (command == null) {
            return null;
        } else {
            DataFormat dataFormat = new DataFormat();
            dataFormat.setFormat(command.getFormat());
            return dataFormat;
        }

    }
}
