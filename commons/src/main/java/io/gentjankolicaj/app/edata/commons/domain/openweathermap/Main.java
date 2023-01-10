package io.gentjankolicaj.app.edata.commons.domain.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("main")
public class Main implements Serializable {

    private Float temp;
    private Float pressure;
    private Float humidity;
    private Float tempMin;
    private Float tempMax;
}
