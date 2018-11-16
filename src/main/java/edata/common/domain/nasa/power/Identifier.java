package edata.common.domain.nasa.power;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nasaPowerIdentifier")
public class Identifier {

    @Id
    @Column(name="identifier")
    private String identifier;

}
