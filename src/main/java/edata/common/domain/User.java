package edata.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="birthplace")
    private String birthplace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country")
    private Country country;

    @Column(name="rights")
    private String rights;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;

}
