package io.gentjankolicaj.data.load.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private String countryName;

    private String phonePrefix;

    private String isoCodes;

    private List<LanguageDTO> languagesDTO;

}
