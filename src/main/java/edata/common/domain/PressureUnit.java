package edata.common.domain;

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
@Table(name="pressureUnit")
public class PressureUnit {

    @Id
    @Column(name="unitCode")
    private String unitCode;

    @Column(name="unitName")
    private String unitName;

    @Column(name="unitDescription")
    private String unitDescription;
}
