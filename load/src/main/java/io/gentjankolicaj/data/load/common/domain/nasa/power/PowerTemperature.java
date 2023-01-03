package io.gentjankolicaj.data.load.common.domain.nasa.power;

import io.gentjankolicaj.data.load.common.domain.DataFormat;
import io.gentjankolicaj.data.load.common.domain.TemperatureUnit;
import io.gentjankolicaj.data.load.common.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nasaPowerTemperature")
public class PowerTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    @Column(name="value")
    private Float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="unit")
    private TemperatureUnit temperatureUnit;

    @Column(name="date")
    private Date date;

    @Column(name="url")
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="identifier")
    private Identifier identifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rawDataFormat")
    private DataFormat rawDataFormat;
}
