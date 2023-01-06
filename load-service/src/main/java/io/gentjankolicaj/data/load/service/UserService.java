package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.load.common.command.UserCommand;
import io.gentjankolicaj.data.load.common.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllDTO();

    List<UserCommand> getAllCommand();

    UserDTO saveDTO(UserDTO userDTO);

    UserCommand saveCommand(UserCommand userCommand);

    UserDTO updateDTO(UserDTO userDTO);

    UserCommand updateCommand(UserCommand userCommand);


    UserDTO getByIdDTO(Long id);

    UserCommand getByIdCommand(Long id);

    User getById(Long id);

    void deleteDTO(UserDTO userDTO);

    void deleteCommand(UserCommand userCommand);


    UserDTO getByEmailAndPasswordDTO(String email, String password);

    UserCommand getByEmailAndPasswordCommand(String email, String password);

    User getByUsername(String username);


}
