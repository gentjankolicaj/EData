package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.commons.domain.Gender;
import io.gentjankolicaj.data.load.common.command.GenderCommand;
import io.gentjankolicaj.data.load.common.dto.GenderDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderConverter implements MyConverter<Gender, GenderDTO, GenderCommand> {

    public GenderConverter() {
    }

    @Override
    public GenderDTO sourceToDto(Gender source) {
        if (source == null) {
            return null;
        } else {
            if (source.getValue().equals(Gender.F)) {
                return GenderDTO.F;
            } else if (source.getValue().equals(Gender.M)) {
                return GenderDTO.M;
            } else {
                return GenderDTO.O;
            }
        }
    }

    @Override
    public GenderCommand sourceToCommand(Gender source) {
        if (source == null) {
            return null;
        } else {
            if (source.getValue().equals(Gender.F)) {
                return GenderCommand.F;
            } else if (source.getValue().equals(Gender.M)) {
                return GenderCommand.M;
            } else {
                return GenderCommand.O;
            }
        }
    }

    @Override
    public Gender dtoToSource(GenderDTO dto) {
        if (dto == null) {
            return null;
        } else {
            if (dto.getValue().equals(GenderDTO.F)) {
                return Gender.F;
            } else if (dto.getValue().equals(GenderDTO.M)) {
                return Gender.M;
            } else {
                return Gender.O;
            }
        }
    }

    @Override
    public Gender commandToSource(GenderCommand command) {
        if (command == null) {
            return null;
        } else {
            if (command.getValue().equals(GenderCommand.F)) {
                return Gender.F;
            } else if (command.getValue().equals(GenderCommand.M)) {
                return Gender.M;
            } else {
                return Gender.O;
            }
        }
    }

    @Override
    public List<GenderDTO> sourceToDto(List<Gender> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<GenderDTO> tempList = new ArrayList<>(source.size());
            for (Gender temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<GenderCommand> sourceToCommand(List<Gender> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<GenderCommand> tempList = new ArrayList<>(source.size());
            for (Gender temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }

}
