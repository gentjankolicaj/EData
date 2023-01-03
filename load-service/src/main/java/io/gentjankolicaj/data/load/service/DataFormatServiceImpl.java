package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.DataFormatCommand;
import io.gentjankolicaj.data.load.common.domain.DataFormat;
import io.gentjankolicaj.data.load.common.dto.DataFormatDTO;
import io.gentjankolicaj.data.load.converter.DataFormatConverter;
import io.gentjankolicaj.data.load.exception.resource.DataFormatNotFoundException;
import io.gentjankolicaj.data.load.exception.resource.NullIdException;
import io.gentjankolicaj.data.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.data.load.repository.DataFormatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataFormatServiceImpl implements DataFormatService {

    private final DataFormatRepository dataFormatRepository;
    private final DataFormatConverter dataFormatConverter;

    public DataFormatServiceImpl(DataFormatRepository dataFormatRepository, DataFormatConverter dataFormatConverter) {
        this.dataFormatRepository = dataFormatRepository;
        this.dataFormatConverter = dataFormatConverter;
    }

    @Override
    public List<DataFormatDTO> getAllDTO() {
        List<DataFormatDTO> list = new ArrayList<>();
        Iterable<DataFormat> iterable = dataFormatRepository.findAll();
        for (DataFormat dataFormat : iterable) {
            list.add(dataFormatConverter.sourceToDto(dataFormat));
        }
        return list;
    }

    @Override
    public List<DataFormatCommand> getAllCommand() {
        List<DataFormatCommand> list = new ArrayList<>();
        Iterable<DataFormat> iterable = dataFormatRepository.findAll();
        for (DataFormat dataFormat : iterable) {
            list.add(dataFormatConverter.sourceToCommand(dataFormat));
        }
        return list;
    }

    @Override
    public DataFormatDTO saveDTO(DataFormatDTO dataFormatDTO) {
        if (dataFormatDTO == null) {
            throw new NullReferenceException("DataFormat not saved.Reference passed is null !!!");
        } else {
            DataFormat savedDataFormat = dataFormatRepository.save(dataFormatConverter.dtoToSource(dataFormatDTO));
            return dataFormatConverter.sourceToDto(savedDataFormat);
        }
    }

    @Override
    public DataFormatCommand saveCommand(DataFormatCommand dataFormatCommand) {
        if (dataFormatCommand == null) {
            throw new NullReferenceException("DataFormat not saved.Reference passed is null !!!");
        } else {
            DataFormat savedDataFormat = dataFormatRepository.save(dataFormatConverter.commandToSource(dataFormatCommand));
            return dataFormatConverter.sourceToCommand(savedDataFormat);
        }
    }

    @Override
    public DataFormatDTO updateDTO(DataFormatDTO dataFormatDTO) {
        if (dataFormatDTO == null) {
            throw new NullReferenceException("DataFormat not updated.Reference passed is null !!!");
        } else {
            DataFormat newDataFormat = dataFormatConverter.dtoToSource(dataFormatDTO);
            Optional<DataFormat> optional = dataFormatRepository.findById(newDataFormat.getFormat());
            if (!optional.isPresent()) {
                DataFormat savedDataFormat = dataFormatRepository.save(newDataFormat);
                return dataFormatConverter.sourceToDto(savedDataFormat);
            } else {
                return dataFormatDTO;
            }
        }
    }

    @Override
    public DataFormatCommand updateCommand(DataFormatCommand dataFormatCommand) {
        if (dataFormatCommand == null) {
            throw new NullReferenceException("DataFormat not updated.Reference passed is null !!!");
        } else {
            DataFormat newDataFormat = dataFormatConverter.commandToSource(dataFormatCommand);
            Optional<DataFormat> optional = dataFormatRepository.findById(newDataFormat.getFormat());
            if (!optional.isPresent()) {
                DataFormat savedDataFormat = dataFormatRepository.save(newDataFormat);
                return dataFormatConverter.sourceToCommand(savedDataFormat);
            } else {
                return dataFormatCommand;
            }
        }
    }

    @Override
    public DataFormatDTO getByIdDTO(String id) {
        if (id == null) {
            throw new NullIdException("DataFormat id is null.");
        } else {
            Optional<DataFormat> optional = dataFormatRepository.findById(id);
            if (!optional.isPresent()) {
                throw new DataFormatNotFoundException("DataFormat with id " + id + " not found.");
            } else {
                return dataFormatConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public DataFormatCommand getByIdCommand(String id) {
        if (id == null) {
            throw new NullIdException("DataFormat id is null.");
        } else {
            Optional<DataFormat> optional = dataFormatRepository.findById(id);
            if (!optional.isPresent()) {
                throw new DataFormatNotFoundException("DataFormat with id " + id + " not found.");
            } else {
                return dataFormatConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(DataFormatDTO dataFormatDTO) {
        if (dataFormatDTO == null) {
            throw new NullReferenceException("DataFormat not deleted.Reference passed is null !!!");
        } else {
            DataFormat dataFormat = dataFormatConverter.dtoToSource(dataFormatDTO);
            dataFormatRepository.delete(dataFormat);
        }

    }

    @Override
    public void deleteCommand(DataFormatCommand dataFormatCommand) {
        if (dataFormatCommand == null) {
            throw new NullReferenceException("DataFormat not deleted.Reference passed is null !!!");
        } else {
            DataFormat dataFormat = dataFormatConverter.commandToSource(dataFormatCommand);
            dataFormatRepository.delete(dataFormat);
        }
    }

}
