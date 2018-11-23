package edata.common.domain.nasa.power;

import edata.common.domain.DataFormat;
import edata.common.domain.TemperatureUnit;
import edata.common.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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


    @Column(name="startDate")
    private Date startDate;

    @Column(name="endDate")
    private Date endDate;

    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="identifier")
    private Identifier identifier;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rawDataFormat")
    private DataFormat rawDataFormat;
}
