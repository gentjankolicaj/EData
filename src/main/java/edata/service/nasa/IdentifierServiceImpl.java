package edata.service.nasa;

import edata.common.command.nasa.power.IdentifierCommand;
import edata.common.domain.nasa.power.Identifier;
import edata.common.dto.nasa.power.IdentifierDTO;
import edata.converter.nasa.power.IdentifierConverter;
import edata.exception.resource.NullIdException;
import edata.exception.resource.IdentifierNotFoundException;
import edata.exception.resource.NullReferenceException;
import edata.repository.nasa.power.IdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IdentifierServiceImpl implements IdentifierService {

    private final IdentifierRepository identifierRepository;
    private final IdentifierConverter identifierConverter;

    @Autowired
    public IdentifierServiceImpl(IdentifierRepository identifierRepository,IdentifierConverter identifierConverter) {
        this.identifierRepository = identifierRepository;
        this.identifierConverter=identifierConverter;
    }

    @Override
    public List<IdentifierDTO> getAllDTO() {
        List<IdentifierDTO> list=new ArrayList<>();
        Iterable<Identifier> iterable=identifierRepository.findAll();
        for(Identifier temp:iterable){
            list.add(identifierConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<IdentifierCommand> getAllCommand() {
        List<IdentifierCommand> list=new ArrayList<>();
        Iterable<Identifier> iterable=identifierRepository.findAll();
        for(Identifier temp:iterable){
            list.add(identifierConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public IdentifierDTO saveDTO(IdentifierDTO identifierDTO) {
        if(identifierDTO==null){
            throw new NullReferenceException("Identifier not saved.Reference passed is null !!!");
        }else {
            Identifier savedObject = identifierRepository.save(identifierConverter.dtoToSource(identifierDTO));
            return identifierConverter.sourceToDto(savedObject);
        }
    }

    @Override
    public IdentifierCommand saveCommand(IdentifierCommand identifierCommand) {
        if(identifierCommand==null) {
            throw new NullReferenceException("Identifier not saved.Reference passed is null !!!");
        }else {
            Identifier savedObject = identifierRepository.save(identifierConverter.commandToSource(identifierCommand));
            return identifierConverter.sourceToCommand(savedObject);
        }
    }

    @Override
    public IdentifierDTO updateDTO(IdentifierDTO identifierDTO) {
        if(identifierDTO==null){
            throw new NullReferenceException("Identifier not found.Reference passed is null !!!");
        }else{
            Identifier identifier=identifierConverter.dtoToSource(identifierDTO);
            Optional<Identifier> optional=identifierRepository.findById(identifier.getIdentifier());
            if(!optional.isPresent()){
                IdentifierDTO updated=identifierConverter.sourceToDto(identifierRepository.save(identifier));
                return updated;
            }else{
                return identifierConverter.sourceToDto(optional.get());
            }
        }

     }

    @Override
    public IdentifierCommand updateCommand(IdentifierCommand identifierCommand) {
        if(identifierCommand==null){
            throw new NullReferenceException("Identifier not found.Reference passed is null !!!");
        }else{
            Identifier identifier=identifierConverter.commandToSource(identifierCommand);
            Optional<Identifier> optional=identifierRepository.findById(identifier.getIdentifier());
            if(!optional.isPresent()){
                IdentifierCommand updated=identifierConverter.sourceToCommand(identifierRepository.save(identifier));
                return updated;
            }else{
                return identifierConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public IdentifierDTO getByIdDTO(String id) {
        if(id==null){
            throw new NullIdException("Identifier id is null.");
        }else {
            Optional<Identifier> optional = identifierRepository.findById(id);
            if (!optional.isPresent()) {
                throw new IdentifierNotFoundException("Identifier with id " + id + " not found.");
            } else {
                return identifierConverter.sourceToDto(optional.get());
            }
        }
      }

    @Override
    public IdentifierCommand getByIdCommand(String id) {
        if(id==null){
            throw new NullIdException("Identifier id is null.");
        }else {
            Optional<Identifier> optional = identifierRepository.findById(id);
            if (!optional.isPresent()) {
                throw new IdentifierNotFoundException("Identifier with id " + id + " not found.");
            } else {
                return identifierConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(IdentifierDTO identifierDTO) {
        if(identifierDTO==null){
            throw new NullReferenceException("Identifier not deleted.Reference passed is null !!!");

        }else{
            Identifier identifier=identifierConverter.dtoToSource(identifierDTO);
            identifierRepository.delete(identifier);
        }
    }

    @Override
    public void deleteCommand(IdentifierCommand identifierCommand) {
        if(identifierCommand==null){
            throw new NullReferenceException("Identifier not deleted.Reference passed is null !!!");

        }else{
            Identifier identifier=identifierConverter.commandToSource(identifierCommand);
            identifierRepository.delete(identifier);
        }
    }


}
