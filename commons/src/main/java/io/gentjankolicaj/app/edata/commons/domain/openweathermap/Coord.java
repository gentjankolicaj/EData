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
@RedisHash("coord")
public class Coord implements Serializable {

    private Float lon;
    private Float lat;
}
