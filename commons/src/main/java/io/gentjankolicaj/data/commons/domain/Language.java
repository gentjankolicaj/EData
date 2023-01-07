package io.gentjankolicaj.data.commons.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "languages")
public class Language {

    @Id
    @Column(name = "language")
    private String language;

    @ManyToMany(mappedBy = "languages")
    private List<Country> countries;


}