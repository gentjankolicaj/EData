package io.gentjankolicaj.app.edata.commons.domain;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("temperatureUnit")
public class TemperatureUnit implements Serializable {

    @Id
    @Column(name = "unitCode")
    private String unitCode;

    @Column(name = "unitName")
    private String unitName;

    @Column(name = "unitDescription")
    private String unitDescription;
}