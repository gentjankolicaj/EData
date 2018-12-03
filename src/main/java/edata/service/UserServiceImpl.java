package edata.service;

import edata.common.command.UserCommand;
import edata.common.domain.User;
import edata.common.dto.UserDTO;
import edata.converter.UserConverter;
import edata.exception.resource.NullIdException;
import edata.exception.resource.NullReferenceException;
import edata.exception.resource.UserNotFoundException;
import edata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //todo: implementing not implemented methods from datalayer

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDTO> getAllDTO() {
       List<UserDTO> list=new ArrayList<>();
       Iterable<User> iterable=userRepository.findAll();
       for(User temp:iterable){
           list.add(userConverter.sourceToDto(temp));
       }
       return list;
    }

    @Override
    public List<UserCommand> getAllCommand() {
        List<UserCommand> list=new ArrayList<>();
        Iterable<User> iterable=userRepository.findAll();
        for(User temp:iterable){
            list.add(userConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public UserDTO saveDTO(UserDTO userDTO) {
        if(userDTO==null){
            throw new NullReferenceException("User not saved.Reference passed is null !!!");
        }else{
            User savedUser=userRepository.save(userConverter.dtoToSource(userDTO));
            return userConverter.sourceToDto(savedUser);
        }
    }

    @Override
    public UserCommand saveCommand(UserCommand userCommand) {
        if(userCommand==null){
            throw new NullReferenceException("User not saved.Reference passed is null !!!");
        }else{
            User savedUser=userRepository.save(userConverter.commandToSource(userCommand));
            return userConverter.sourceToCommand(savedUser);
        }
    }

    @Override
    public UserDTO updateDTO(UserDTO userDTO) {
        if(userDTO==null){
            throw new NullReferenceException("User not updated.Reference passed is null !!!.");
        }else{
            User newUser=userConverter.dtoToSource(userDTO);
            Optional<User> optional=userRepository.findById(newUser.getId());
            if(!optional.isPresent()){
                User savedUser=userRepository.save(newUser);
                return userConverter.sourceToDto(savedUser);
            }else{
                User actual=optional.get();
                actual.setUsername(newUser.getUsername());
                actual.setPassword(newUser.getPassword());
                actual.setEmail(newUser.getEmail());
                actual.setFirstName(newUser.getFirstName());
                actual.setLastName(newUser.getLastName());
                actual.setGender(newUser.getGender());
                actual.setBirthday(newUser.getBirthday());
                actual.setBirthplace(newUser.getBirthplace());
                actual.setRights(newUser.getRights());
                actual.setCountry(newUser.getCountry());
                actual.setCreatedDate(newUser.getCreatedDate());
                actual.setUpdatedDate(newUser.getUpdatedDate());
                return userConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public UserCommand updateCommand(UserCommand userCommand) {
        if(userCommand==null){
            throw new NullReferenceException("User not updated.Reference passed is null !!!.");
        }else{
            User newUser=userConverter.commandToSource(userCommand);
            Optional<User> optional=userRepository.findById(newUser.getId());
            if(!optional.isPresent()){
                User savedUser=userRepository.save(newUser);
                return userConverter.sourceToCommand(savedUser);
            }else{
                User actual=optional.get();
                actual.setUsername(newUser.getUsername());
                actual.setPassword(newUser.getPassword());
                actual.setEmail(newUser.getEmail());
                actual.setFirstName(newUser.getFirstName());
                actual.setLastName(newUser.getLastName());
                actual.setGender(newUser.getGender());
                actual.setBirthday(newUser.getBirthday());
                actual.setBirthplace(newUser.getBirthplace());
                actual.setRights(newUser.getRights());
                actual.setCountry(newUser.getCountry());
                actual.setCreatedDate(newUser.getCreatedDate());
                actual.setUpdatedDate(newUser.getUpdatedDate());
                return userConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public UserDTO getByIdDTO(Long id) {
        if(id==null){
            throw new NullIdException("User id is null.");
        }else{
            Optional<User> optional=userRepository.findById(id);
            if(!optional.isPresent()){
                throw new UserNotFoundException("User with id "+id+" not found.");
            }else{
                return userConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public UserCommand getByIdCommand(Long id) {
        if(id==null){
            throw new NullIdException("User id is null.");
        }else{
            Optional<User> optional=userRepository.findById(id);
            if(!optional.isPresent()){
                throw new UserNotFoundException("User with id "+id+" not found.");
            }else{
                return userConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public User getById(Long id) {
        if(id==null){
            throw new NullIdException("User id is null.");
        }else{
            Optional<User> optional=userRepository.findById(id);
            if(!optional.isPresent()){
                throw new UserNotFoundException("User with id "+id+" not found.");
            }else{
                return optional.get();
            }
        }
    }

    @Override
    public void deleteDTO(UserDTO userDTO) {
        if(userDTO==null){
            throw new NullReferenceException("User not deleted.Reference passed is null !!!");
        }else{
            User user=userConverter.dtoToSource(userDTO);
            userRepository.delete(user);
        }
    }

    @Override
    public void deleteCommand(UserCommand userCommand) {
        if(userCommand==null){
            throw new NullReferenceException("User not deleted.Reference passed is null !!!");
        }else{
            User user=userConverter.commandToSource(userCommand);
            userRepository.delete(user);
        }
    }
}
