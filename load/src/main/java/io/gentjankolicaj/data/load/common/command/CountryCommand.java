package io.gentjankolicaj.data.load.common.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
