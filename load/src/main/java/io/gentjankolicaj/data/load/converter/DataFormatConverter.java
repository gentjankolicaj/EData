package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.load.common.command.DataFormatCommand;
import io.gentjankolicaj.data.load.common.domain.DataFormat;
import io.gentjankolicaj.data.load.common.dto.DataFormatDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<DataFormatDTO> sourceToDto(List<DataFormat> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<DataFormatDTO> tempList=new ArrayList<>(source.size());
            for(DataFormat temp:source){
                tempList.add(sourceToDto(temp));
                            }
            return tempList;
        }
    }

    @Override
    public List<DataFormatCommand> sourceToCommand(List<DataFormat> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<DataFormatCommand> tempList=new ArrayList<>(source.size());
            for(DataFormat temp:source){
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
