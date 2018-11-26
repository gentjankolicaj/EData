package edata.common.domain.open_weather_map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    private Long id;
    private String main;
    private String description;
    private String icon;
}
