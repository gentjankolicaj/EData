package edata.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="countryName")
    private String countryName;

    @Column(name="phonePrefix")
    private String phonePrefix;

    @Column(name="isoCodes")
    private String isoCodes;

}
