package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.load.common.command.UserCommand;
import io.gentjankolicaj.data.load.common.domain.User;
import io.gentjankolicaj.data.load.common.dto.UserDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter implements MyConverter<User, UserDTO, UserCommand> {

    private final CountryConverter countryConverter;
    private final GenderConverter genderConverter;
    private final RoleConverter roleConverter;

    @Autowired
    public UserConverter(CountryConverter countryConverter, GenderConverter genderConverter, RoleConverter roleConverter) {
        this.countryConverter = countryConverter;
        this.genderConverter = genderConverter;
        this.roleConverter = roleConverter;
    }

    @Override
    public UserDTO sourceToDto(User source) {
        if (source == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(source.getId());
            userDTO.setUsername(source.getUsername());
            userDTO.setPassword(source.getPassword());
            userDTO.setEmail(source.getEmail());
            userDTO.setFirstName(source.getFirstName());
            userDTO.setLastName(source.getLastName());
            userDTO.setGenderDTO(genderConverter.sourceToDto(source.getGender()));
            userDTO.setBirthday(source.getBirthday());
            userDTO.setBirthplace(source.getBirthplace());
            userDTO.setCountryDTO(countryConverter.sourceToDto(source.getCountry()));
            userDTO.setRights(source.getRights());
            userDTO.setUpdatedDate(source.getUpdatedDate());
            userDTO.setCreatedDate(source.getCreatedDate());
            return userDTO;
        }
    }

    @Override
    public UserCommand sourceToCommand(User source) {
        if (source == null) {
            return null;
        } else {
            UserCommand userCommand = new UserCommand();
            userCommand.setId(source.getId());
            userCommand.setUsername(source.getUsername());
            userCommand.setPassword(source.getPassword());
            userCommand.setEmail(source.getEmail());
            userCommand.setFirstName(source.getFirstName());
            userCommand.setLastName(source.getLastName());
            userCommand.setGenderCommand(genderConverter.sourceToCommand(source.getGender()));
            userCommand.setBirthday(source.getBirthday());
            userCommand.setBirthplace(source.getBirthplace());
            userCommand.setCountryCommand(countryConverter.sourceToCommand(source.getCountry()));
            userCommand.setRights(source.getRights());
            userCommand.setUpdatedDate(source.getUpdatedDate());
            userCommand.setCreatedDate(source.getCreatedDate());
            return userCommand;
        }
    }

    @Override
    public User dtoToSource(UserDTO dto) {
        if (dto == null) {
            return null;
        } else {
            User user = new User();
            user.setId(dto.getId());
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setGender(genderConverter.dtoToSource(dto.getGenderDTO()));
            user.setBirthday(dto.getBirthday());
            user.setBirthplace(dto.getBirthplace());
            user.setCountry(countryConverter.dtoToSource(dto.getCountryDTO()));
            user.setRights(dto.getRights());
            user.setUpdatedDate(dto.getUpdatedDate());
            user.setCreatedDate(dto.getCreatedDate());
            return user;
        }
    }

    @Override
    public User commandToSource(UserCommand command) {
        if (command == null) {
            return null;
        } else {
            User user = new User();
            user.setId(command.getId());
            user.setUsername(command.getUsername());
            user.setPassword(command.getPassword());
            user.setEmail(command.getEmail());
            user.setLastName(command.getLastName());
            user.setFirstName(command.getFirstName());
            user.setGender(genderConverter.commandToSource(command.getGenderCommand()));
            user.setBirthplace(command.getBirthplace());
            user.setBirthday(command.getBirthday());
            user.setCountry(countryConverter.commandToSource(command.getCountryCommand()));
            user.setRights(command.getRights());
            user.setUpdatedDate(command.getUpdatedDate());
            user.setCreatedDate(command.getCreatedDate());
            return user;
        }
    }

    @Override
    public List<UserDTO> sourceToDto(List<User> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<UserDTO> tempList = new ArrayList<>(source.size());
            for (User temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }

    }

    @Override
    public List<UserCommand> sourceToCommand(List<User> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<UserCommand> tempList = new ArrayList<>(source.size());
            for (User temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
