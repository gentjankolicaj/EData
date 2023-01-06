package io.gentjankolicaj.data.commons.domain.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Main {

    private Float temp;
    private Float pressure;
    private Float humidity;
    private Float tempMin;
    private Float tempMax;
}
