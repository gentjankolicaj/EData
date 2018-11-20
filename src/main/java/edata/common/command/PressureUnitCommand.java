package edata.common.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PressureUnitCommand {

    private String unitCode;

    private String unitName;

    private String unitDescription;
}
