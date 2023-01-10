package io.gentjankolicaj.app.edata.commons.domain.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("sys")
public class Sys implements Serializable {

    private Long type;
    private Long id;
    private Float message;
    private String country;
    private Long sunrise;
    private Long sunset;
}
