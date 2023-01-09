package io.gentjankolicaj.app.edata.commons.domain.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sys {

    private Long type;
    private Long id;
    private Float message;
    private String country;
    private Long sunrise;
    private Long sunset;
}
