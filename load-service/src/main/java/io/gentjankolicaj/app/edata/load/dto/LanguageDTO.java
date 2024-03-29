package io.gentjankolicaj.app.edata.load.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    private String language;

    private List<CountryDTO> countriesDTO;
}
