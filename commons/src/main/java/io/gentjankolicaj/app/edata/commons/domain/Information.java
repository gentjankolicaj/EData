package io.gentjankolicaj.app.edata.commons.domain;


import io.gentjankolicaj.app.edata.commons.enums.InformationScope;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language")
    private Language language;

    @Column(name = "scope")
    @Enumerated(EnumType.STRING)
    private InformationScope informationScope;

    @Column(name = "field")
    private String field;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "title")
    private String title;

    @Column(name = "tip")
    private String tip;


}
