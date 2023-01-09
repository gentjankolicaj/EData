package io.gentjankolicaj.app.edata.load.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private List<RoleDTO> rolesDTO;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private GenderDTO genderDTO;

    private Date birthday;

    private String birthplace;

    private CountryDTO countryDTO;

    private String rights;

    private Date createdDate;

    private Date updatedDate;
}
