package edata.common.command;

import edata.common.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCommand {

    private String role;

    private List<UserCommand> usersCommand;
}
