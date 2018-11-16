package edata.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date birthday;

    private String birthplace;

    private Country country;

    private String rights;

    private Date createdDate;

    private Date updatedDate;







}
