package edata.common.domain.open_weather_map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Long id;
    private String name;
    private Long cod;
}
