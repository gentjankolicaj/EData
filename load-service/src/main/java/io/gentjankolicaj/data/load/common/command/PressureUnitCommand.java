package io.gentjankolicaj.data.load.common.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
