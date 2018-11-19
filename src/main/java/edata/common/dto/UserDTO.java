package edata.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private GenderDTO genderDTO;

    private Date birthday;

    private String birthplace;

    private CountryDTO countryDTO;

    private String rights;

    private Date createdDate;

    private Date updatedDate;

}
