package edata.common.command;

import edata.common.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommand {

    @NotNull
    private Long id;

    @NotNull
    private List<RoleCommand> rolesCommand;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private GenderCommand genderCommand;

    private Date birthday;

    private String birthplace;

    @NotNull
    private CountryCommand countryCommand;

    @NotNull
    private String rights;

    private Date createdDate;

    private Date updatedDate;
}
