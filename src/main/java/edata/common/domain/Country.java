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
    private String countryName;

    private String phonePrefix;

    private String isoCodes;


}
