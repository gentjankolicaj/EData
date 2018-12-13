package edata.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;




    //authentication type
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService)
       .passwordEncoder(getPasswordEncoder());
    }


    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }


    //authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
         http.authorizeRequests()
                 .antMatchers("/help").permitAll()
                 .antMatchers("/contact").permitAll()
                 .antMatchers("/about").permitAll()
                 .antMatchers("/home").permitAll()
                 .antMatchers("/sign").permitAll()
                 .antMatchers("/user/**","/api/**").authenticated()
                 .and()
                   .formLogin().loginPage("/sign/").permitAll();
    }
}
