package io.gentjankolicaj.app.edata.load.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCmd {
    private Long roleId;
    private String role;
    private List<UserCmd> usersCommand;
}
