package edata.service;

import edata.common.command.UserCommand;
import edata.common.domain.User;
import edata.common.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllDTO();
    List<UserCommand> getAllCommand();

    UserDTO saveDTO(UserDTO userDTO);
    UserCommand saveCommand(UserCommand userCommand);

    UserDTO updateDTO(UserDTO userDTO);
    UserCommand updateCommand(UserCommand userCommand);


    UserDTO getByIdDTO(Long id);
    UserCommand  getByIdCommand(Long id);
    User getById(Long id);

    void deleteDTO(UserDTO userDTO);
    void deleteCommand(UserCommand userCommand);


    UserDTO getByEmailAndPasswordDTO(String email,String password);
    UserCommand  getByEmailAndPasswordCommand(String email,String password);


}
