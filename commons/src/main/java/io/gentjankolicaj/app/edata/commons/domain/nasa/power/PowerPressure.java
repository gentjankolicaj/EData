package io.gentjankolicaj.app.edata.commons.domain.nasa.power;

import io.gentjankolicaj.app.edata.commons.cache.Cacheable;
import io.gentjankolicaj.app.edata.commons.domain.PressureUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("nasaPowerPressure")
public class PowerPressure implements Serializable, Cacheable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit")
    private PressureUnit pressureUnit;

    @Column(name = "date")
    private LocalDate date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rawDataFormat")
    private String rawDataFormat;


    @Override
    public Class<?> getClazz() {
        return PowerPressure.class;
    }
}
