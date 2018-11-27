package edata.common.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PressureUnitCommand {

    @NotNull
    private String unitCode;

    @NotNull
    private String unitName;

    @NotNull
    private String unitDescription;
}
