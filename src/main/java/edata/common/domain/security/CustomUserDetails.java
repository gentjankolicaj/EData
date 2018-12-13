package edata.common.domain.security;

import edata.common.domain.Role;
import edata.common.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails() {
    }

    public CustomUserDetails(final User user){
        super.setId(user.getId());
        super.setRoles(user.getRoles());
        super.setUsername(user.getUsername());
        super.setPassword(user.getPassword());
        super.setEmail(user.getEmail());
        super.setFirstName(user.getFirstName());
        super.setLastName(user.getLastName());
        super.setGender(user.getGender());
        super.setBirthday(user.getBirthday());
        super.setBirthplace(user.getBirthplace());
        super.setRights(user.getRights());
        super.setUpdatedDate(user.getUpdatedDate());
        super.setCreatedDate(user.getCreatedDate());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       List<Role> rolesList=getRoles();
       List<SimpleGrantedAuthority> grantedAuthorityList=new ArrayList<>();
       for(Role temp:rolesList){
           grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+temp.getRole()));
       }
       return grantedAuthorityList;

    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}