package edata.common.command;

import edata.common.domain.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryCommand {

    @NotNull
    private String countryName;

    @NotNull
    private String phonePrefix;

    @NotNull
    private String isoCodes;

    private List<LanguageCommand> languagesCommand;

}
