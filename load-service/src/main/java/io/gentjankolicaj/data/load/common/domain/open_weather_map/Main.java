package io.gentjankolicaj.data.load.common.domain.open_weather_map;

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
