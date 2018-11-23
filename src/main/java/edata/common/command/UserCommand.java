package edata.common.command;

import edata.common.dto.CountryDTO;
import edata.common.dto.GenderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommand {

    private Long id;

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
