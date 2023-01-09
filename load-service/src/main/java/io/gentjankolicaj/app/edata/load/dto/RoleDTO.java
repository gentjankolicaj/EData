package io.gentjankolicaj.app.edata.load.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long roleId;

    private String role;

    private List<UserDTO> usersDTO;
}
