package edata.converter;

import edata.common.command.RoleCommand;
import edata.common.domain.Role;
import edata.common.dto.RoleDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleConverter implements MyConverter<Role, RoleDTO, RoleCommand> {


    public RoleConverter() {
    }

    @Override
    public RoleDTO sourceToDto(Role source) {
        if(source==null){
            return null;
        }else{
            RoleDTO roleDTO=new RoleDTO();
            roleDTO.setRoleId(source.getRoleId());
            roleDTO.setRole(source.getRole());
           return roleDTO;
        }
    }

    @Override
    public RoleCommand sourceToCommand(Role source) {
        if(source==null){
            return null;
        }else{
            RoleCommand roleCommand=new RoleCommand();
            roleCommand.setRoleId(source.getRoleId());
            roleCommand.setRole(source.getRole());
            return roleCommand;
        }
    }

    @Override
    public Role dtoToSource(RoleDTO dto) {
        if(dto==null){
            return null;
        }else{
            Role role=new Role();
            role.setRoleId(dto.getRoleId());
            role.setRole(dto.getRole());
            return role;
        }
    }

    @Override
    public Role commandToSource(RoleCommand command) {
        if(command==null){
            return null;
        }else{
            Role role=new Role();
            role.setRoleId(command.getRoleId());
            role.setRole(command.getRole());
            return role;
        }
    }

    @Override
    public List<RoleDTO> sourceToDto(List<Role> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<RoleDTO> list=new ArrayList<>();
            for(Role temp:source){
                list.add(sourceToDto(temp));
            }
            return list;
        }
    }


    public List<Role> dtoToSource(List<RoleDTO> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<Role> list=new ArrayList<>();
            for(RoleDTO temp:source){
                list.add(dtoToSource(temp));
            }
            return list;
        }
    }


    public List<Role> commandToSource(List<RoleCommand> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<Role> list=new ArrayList<>();
            for(RoleCommand temp:source){
                list.add(commandToSource(temp));
            }
            return list;
        }
    }

    @Override
    public List<RoleCommand> sourceToCommand(List<Role> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<RoleCommand> list=new ArrayList<>();
            for(Role temp:source){
                list.add(sourceToCommand(temp));
            }
            return list;
        }
    }
}
