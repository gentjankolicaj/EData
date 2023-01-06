package io.gentjankolicaj.data.commons.domain.nasa.power;

import io.gentjankolicaj.data.commons.domain.TemperatureUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nasaPowerTemperature")
public class PowerTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit")
    private TemperatureUnit temperatureUnit;

    @Column(name = "date")
    private LocalDate date;


    @JoinColumn(name = "rawDataFormat")
    private String rawDataFormat;
}
