package io.gentjankolicaj.data.load.common.domain;

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
@Table(name="country")
public class Country {

    @Id
    @Column(name="countryName")
    private String countryName;

    @Column(name="phonePrefix")
    private String phonePrefix;

    @Column(name="isoCodes")
    private String isoCodes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="country_languages",joinColumns = @JoinColumn(name="countryName"),inverseJoinColumns = @JoinColumn(name="language"))
    private List<Language> languages;

}
