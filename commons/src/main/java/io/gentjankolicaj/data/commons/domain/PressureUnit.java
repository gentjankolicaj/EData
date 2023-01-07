package io.gentjankolicaj.data.commons.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pressureUnit")
public class PressureUnit implements Serializable {

    @Id
    @Column(name = "unitCode")
    private String unitCode;

    @Column(name = "unitName")
    private String unitName;

    @Column(name = "unitDescription")
    private String unitDescription;
}
