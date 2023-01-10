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
@RedisHash("clouds")
public class Clouds implements Serializable {

    private Float all;
}
