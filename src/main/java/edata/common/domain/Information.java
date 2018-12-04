package edata.common.domain;


import edata.common.enums.InformationScope;
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
@Table(name="information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="language")
    private Language language;

    @Column(name="scope")
    @Enumerated(EnumType.STRING)
    private InformationScope informationScope;

    @Column(name="field")
    private String field;

    @Column(name="subject")
    private String subject;

    @Column(name="message")
    private String message;

    @Column(name="title")
    private String title;

    @Column(name="tip")
    private String tip;


}
