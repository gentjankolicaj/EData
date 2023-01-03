package io.gentjankolicaj.data.load.common.domain.nasa.power;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nasaPowerIdentifier")
public class Identifier {

    @Id
    @Column(name = "identifier")
    private String identifier;

}
