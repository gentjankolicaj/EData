package edata.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name="role")
    private String role;

    @ManyToMany
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="id"))
    private List<User> users;
}