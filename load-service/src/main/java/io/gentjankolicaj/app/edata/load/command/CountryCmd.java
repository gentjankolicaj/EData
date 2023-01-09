package io.gentjankolicaj.app.edata.load.command;

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
public class CountryCmd {

    @NotNull
    private String countryName;

    @NotNull
    private String phonePrefix;

    @NotNull
    private String isoCodes;

    private List<LanguageCmd> languagesCommand;

}
